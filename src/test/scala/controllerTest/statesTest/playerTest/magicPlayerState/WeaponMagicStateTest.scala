package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.magicPlayer.{ActionMagicState, WeaponMagicState}
import model.general.GameModel
import model.spell.dark.Fire
import model.spell.light.Healing
import model.weapons.common.{Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
import view.GameView

class WeaponMagicStateTest extends FunSuite{
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
  var testState2: GameState = _ // by default TurnState

  override def beforeEach(context: BeforeEach): Unit = {
    testState = new WeaponMagicState(gameController.getAlly(1),Some(new Healing()),gameModel.participants)
    testState.pj.selectSpell(new Healing)
    testState.pj.putWeapon(new Wand())
    testState2 = new WeaponMagicState(gameController.getAlly(1),gameModel.participants)
    //testState2.pj.putWeapon(new Wand())
  }
  test("update to WeaponMagicState, if pj failed putting a weapon"){
    testState.pj.dropWeapon()
    testState.update(gameController,0)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState, if spell is Healing"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState, if spell is Healing"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to WeaponMagicState, if spell is Healing"){
    testState.update(gameController,3)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to HealingState"){
    testState.update(gameController,4)
    assertEquals(gameController.state.isHealingState(),true)
  }
  test("update to HealingState"){
    testState.update(gameController,5)
    assertEquals(gameController.state.isHealingState(),true)
  }
  test("update to TargetMagicState, if pj spell != healing"){
    testState.pj.dropSpell()
    testState.pj.putWeapon(new Bow())
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to TargetMagicState, if pj spell != healing"){
    testState2.pj.dropSpell()
    testState2.pj.putWeapon(new Sword())
    testState2.update(gameController,2)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to WeaponMagicState"){
    testState2.pj.dropSpell()
    testState2.update(gameController,3)
    println(gameController.state)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to TargetMagicState, if pj spell != healing"){
    testState2.pj.dropSpell()
    testState2.pj.putWeapon(new Wand())
    testState2.update(gameController,4)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to TargetMagicState, if pj spell != healing"){
    testState2.pj.dropSpell()
    testState2.pj.putWeapon(new Staff())
    testState2.update(gameController,5)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }

}
