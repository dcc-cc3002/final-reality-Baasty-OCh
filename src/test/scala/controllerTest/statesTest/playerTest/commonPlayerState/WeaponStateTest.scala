package controllerTest.statesTest.playerTest.commonPlayerState

import controller.GameController
import controller.states.player.commonPlayer.WeaponState
import controller.states.{GameState, TurnState}
import model.general.GameModel
import model.weapons.common.Sword
import model.weapons.magic.Wand
import munit.FunSuite
import view.GameView

class WeaponStateTest extends FunSuite{
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
    testState = new WeaponState(gameController.state.pj,gameModel.participants)
  }
  test("handleInput"){

  }
  test("update to WeaponState , if pj failed putting a weapon"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isWeaponState(),true)
  }
  test("update to WeaponState , if pj failed putting a weapon"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,4)
    assertEquals(gameController.state.isWeaponState(),true)
  }
  test("update to WeaponState , if pj failed putting a weapon"){
    testState.pj.putWeapon(new Wand())
    testState.update(gameController,5)
    assertEquals(gameController.state.isWeaponState(),true)
  }
  test("update to ActionState"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,0)
    assertEquals(gameController.state.isActionState(),true)
  }
  test("update to TargetState if pj success putting a weapon"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetState(),true)
  }

  test("update to TargetState if pj success putting a weapon"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,2)
    assertEquals(gameController.state.isTargetState(),true)
  }
  test("update to TargetState if pj success putting a weapon"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,3)
    assertEquals(gameController.state.isTargetState(),true)
  }

}
