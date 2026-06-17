package controllerTest.statesTest.enemyState

import controller.GameController
import controller.states.GameState
import controller.states.enemy.{BurnedState, InitialEnemyState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class BurnedStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: BurnedState = _
  override def beforeEach(context: BeforeEach): Unit = {
    testState = new BurnedState(gameController.getEnemy(1),gameModel.participants)
  }
  test("update to TargetEnemyState after was burnt by a Staff"){
    testState.pj.setStatus("Quemado con Baston")
    testState.update(gameController,0)
    assertEquals(gameController.state.isTargetEnemyState(),true)
  }
  test("update to TargetEnemyState after was burnt by a Wand"){
    testState.pj.setStatus("Quemado con Varita")
    testState.update(gameController,0)
    assertEquals(gameController.state.isTargetEnemyState(),true)
  }
  test("update after 4 turns"){
    testState.cnt = 4
    testState.update(gameController,0)
    assertEquals(gameController.state.isTargetEnemyState(),true)
  }
}
