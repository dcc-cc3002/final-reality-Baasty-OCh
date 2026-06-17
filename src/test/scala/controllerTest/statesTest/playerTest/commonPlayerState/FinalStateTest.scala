package controllerTest.statesTest.playerTest.commonPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.commonPlayer.{FinalState, TargetState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class FinalStateTest extends FunSuite{
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
    testState = new FinalState(gameController.getAlly(1),gameController.getEnemy(1),gameModel.participants)
  }
  test("update to TurnState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isTurnState(),true)
  }

}
