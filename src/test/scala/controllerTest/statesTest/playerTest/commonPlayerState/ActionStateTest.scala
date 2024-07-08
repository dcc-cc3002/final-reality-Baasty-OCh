package controllerTest.statesTest.playerTest.commonPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.UnitState
import controller.states.player.commonPlayer.ActionState
import model.general.GameModel
import model.weapons.common.Sword
import munit.FunSuite
import view.GameView

class ActionStateTest extends FunSuite{
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
    testState = new ActionState(gameController.state.pj,gameModel.participants)
    testState.pj.dropWeapon()
  }
  test("update to SurrenderState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isSurrenderState(),true)
  }
  test("update to WeaponState to attack"){
    testState.update(gameController,1)
    println(gameController.state)
    assertEquals(gameController.state.isWeaponState(),true)
  }
  test("update to WeaponState to change weapon"){

    testState.update(gameController,2)
    assertEquals(gameController.state.isWeaponState(),true)
  }
  test("update to SurrenderState with army pj"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,0)
    assertEquals(gameController.state.isSurrenderState(),true)
  }
  test("update to TargetState with army pj"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetState(),true)
  }
  test("update to WeaponState with army pj"){
    testState.pj.putWeapon(new Sword())
    testState.update(gameController,2)
    assertEquals(gameController.state.isWeaponState(),true)
  }




}
