package controllerTest.statesTest.playerTest

import controller.GameController
import controller.states.GameState
import controller.states.player.UnitState
import model.general.GameModel
import munit.FunSuite
import view.GameView

class UnitStateTest extends FunSuite{
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
    testState = new UnitState(gameModel.participants,gameController.state.pj)
  }
  test("handleInput"){
    testState.handleInput(gameController)
    assertEquals(testState.choice,1)
  }
  test("update to ActionState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isActionState(),true)
  }
  test("update to ActionMagicState"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isActionMagicState(),true)
  }


}
