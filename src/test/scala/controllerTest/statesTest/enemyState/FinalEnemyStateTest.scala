package controllerTest.statesTest.enemyState

import controller.GameController
import controller.states.GameState
import controller.states.enemy.{FinalEnemyState, TargetEnemyState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class FinalEnemyStateTest extends FunSuite{
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
    testState = new FinalEnemyState(gameController.getEnemy(1),gameController.getAlly(1),gameModel.participants)
  }
  test("update to TurnState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isTurnState(),true)
  }

}
