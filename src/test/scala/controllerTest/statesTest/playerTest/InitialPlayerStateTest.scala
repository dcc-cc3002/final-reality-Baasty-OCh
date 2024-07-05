package controllerTest.statesTest.playerTest

import controller.GameController
import controller.states.GameState
import controller.states.player.InitialPlayerState
import model.general.GameModel
import munit.FunSuite
import view.GameView

class InitialPlayerStateTest extends FunSuite{
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
    testState = new InitialPlayerState(gameModel.participants,gameController.state.pj)
  }
  test("update to UnitState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isUnitState(),true)
  }

}
