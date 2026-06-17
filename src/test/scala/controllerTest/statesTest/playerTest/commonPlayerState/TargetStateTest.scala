package controllerTest.statesTest.playerTest.commonPlayerState

import controller.GameController
import controller.states.player.commonPlayer.TargetState
import controller.states.{GameState, TurnState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class TargetStateTest extends FunSuite{
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
    testState = new TargetState(gameController.state.pj,gameModel.participants)
  }
  test("update to TargetState, if you chosen a dead enemy"){
    gameController.getEnemy(0).setHp(0)
    testState.update(gameController,0)
    assertEquals(gameController.state.isTargetState(),true)
  }
  /*test("update to FinalState 1"){
    testState.update(gameController,1)
    println(gameController.state)
    assertEquals(gameController.state.isFinalState(),true)
  }
  test("update to FinalState 2"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isFinalState(),true)
  }
  test("update to FinalState 3"){
    testState.update(gameController,3)
    assertEquals(gameController.state.isFinalState(),true)
  }*/

}
