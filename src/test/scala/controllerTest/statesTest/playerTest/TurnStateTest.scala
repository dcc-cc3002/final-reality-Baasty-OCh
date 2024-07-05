package controllerTest.statesTest.playerTest

import controller.GameController
import controller.states.{GameState, TurnState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class TurnStateTest extends FunSuite{ // flujo de jugador zidane
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
    testState = new TurnState(gameModel.participants)
  }
  test("handleInput"){
    testState.handleInput(gameController)
    assertEquals(testState.choice,2)
  }
  test("update to InitialEnemyState"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isInitialEnemyState(),true)
  }
  test("update to InitialPlayerState"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isInitialPlayerState(),true)
  }




}
