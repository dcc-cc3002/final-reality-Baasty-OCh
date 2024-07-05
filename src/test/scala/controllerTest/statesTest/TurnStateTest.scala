package controllerTest.statesTest

import controller.GameController
import controller.states.GameState
import model.general.{GameModel, GameUnit}
import model.weapons.common.Sword
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
  val testState: GameState = gameController.state // by default TurnState

  test("handleInput"){
    testState.handleInput(gameController)
  }
  test("update to InitialPlayerState"){
    testState.update(gameController)
    assertEquals(gameController.state.isInitialPlayerState(),true)
  }
  test("update to UnitState"){
    gameController.state.update(gameController)
    assertEquals(gameController.state.isUnitState(),true)
  }
  test("update to ActionMagicState"){
    gameController.state.handleInput(gameController)
    gameController.state.update(gameController)
    assertEquals(gameController.state.isActionMagicState(),true)
  }
  test("update to SurrenderState"){
    gameController.state.choice = 0
    gameController.state.update(gameController)
    assertEquals(gameController.state.isActionMagicState(),true)
  }


}
