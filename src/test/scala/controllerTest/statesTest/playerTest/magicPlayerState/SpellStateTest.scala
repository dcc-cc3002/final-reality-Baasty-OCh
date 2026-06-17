package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.magicPlayer.{ActionMagicState, SpellState}
import model.general.GameModel
import model.nonplayable.Enemy
import model.spell.dark.{Fire, Thunder}
import model.weapons.magic.Wand
import munit.FunSuite
import view.GameView

class SpellStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: SpellState = _ // by default TurnState

  override def beforeEach(context: BeforeEach): Unit = {
    testState = new SpellState(gameController.getAlly(2),gameModel.participants)
    testState.pj.dropWeapon()
    testState.pj.dropSpell()
    testState.pj.putWeapon(new Wand())
    testState.pj.selectSpell(new Fire())
    testState.selected = testState.pj.spell

  }

  test("update to WeaponMagicState"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,3)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,4)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,5)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to SpellState, if pj failed putting the spell"){
    testState.pj.spell = None
    testState.update(gameController,3)
    assertEquals(gameController.state.isSpellState(),true)
  }
  test("update to ActionState"){ // ojo
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.pj.throwSpell(new Enemy("Neymar"))
    testState.selected = Some(new Thunder())
    testState.update(gameController,5)
    assertEquals(gameController.state.isActionMagicState(),true)
  }

}
