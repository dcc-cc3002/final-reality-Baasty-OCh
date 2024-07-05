package controllerTest.statesTest

import controller.GameController
import controller.states.GameState
import model.general.{GameModel, GameUnit}
import model.weapons.common.Sword
import munit.FunSuite
import view.GameView

class TurnStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  val testState: GameState = gameController.state

  test("handleInput"){
    testState.handleInput(gameController)
  }
  test("update match 2"){
    testState.update(gameController)
    assertEquals(gameController.state.isInitialPlayerState(),true)
  }
  test("update match 1"){
    val ZZ: GameUnit = gameController.getAlly(2)
    ZZ.putWeapon( new Sword())
    println(ZZ.getName)
    println(ZZ.getWeight)
    testState.update(gameController)
    assertEquals(gameController.state.isInitialEnemyState(),true)
  }

}
