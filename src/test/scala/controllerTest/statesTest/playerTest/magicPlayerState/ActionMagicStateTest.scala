package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.player.magicPlayer.ActionMagicState
import controller.states.{GameState, TurnState}
import model.general.GameModel
import model.spell.dark.Fire
import model.weapons.magic.Wand
import munit.FunSuite
import view.GameView

class ActionMagicStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: GameState = _ // by default TurnState

  override def beforeEach(context: BeforeEach): Unit = {
    testState = new ActionMagicState(gameController.getAlly(2),gameModel.participants)
    testState.pj.dropSpell()
    testState.pj.dropWeapon()
  }
  test("update to SurrenderState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isSurrenderState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to SpellState"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isSpellState(),true)
  }
  test("update to WeaponMagicState"){
    testState.update(gameController,3)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to SpellState"){
    testState.update(gameController,4)
    assertEquals(gameController.state.isSpellState(),true)
  }
  test("update to SurrenderState , if pj has a weapon"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,0)
    assertEquals(gameController.state.isSurrenderState(),true)
  }
  test("update to SurrenderState , if pj has a spell"){
    testState.pj.selectSpell(new Fire())
    testState.update(gameController,0)
    assertEquals(gameController.state.isSurrenderState(),true)
  }
  test("update to TargetMagicState, if pj has a weapon"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to TargetMagicState , if pj has a spell"){
    testState.pj.selectSpell(new Fire())
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to SpellState , if pj has a weapon or a spell"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,2)
    assertEquals(gameController.state.isSpellState(),true)
  }
  test("update to WeaponMagicState, if pj has a weapon or spell"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,3)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to SpellState , if pj has a weapon or a spell"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,4)
    assertEquals(gameController.state.isSpellState(),true)
  }



}
