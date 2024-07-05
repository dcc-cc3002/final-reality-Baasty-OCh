package controllerTest

import controller.GameController
import controller.states.player.InitialPlayerState
import controller.states.TurnState
import junit.framework.Assert
import junit.framework.Assert.assertTrue
import model.general.{GameModel, GameUnit}
import model.playable.common.Ninja
import munit.FunSuite
import view.GameView

/**
 * Test suite for the GameController class.
 * This class contains various tests to ensure the correct functionality of the GameController.
 */
class GameControllerTest extends FunSuite {

  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)

  /**
   * Test to check if the game has finished.
   * The game should not be finished initially.
   */
  test("hasFinished") {
    assertEquals(gameController.hasFinished(), false)
  }

  /**
   * Test to verify that the default state of the game controller is TurnState.
   */
  test("Default state is TurnsState") {
    assertEquals(gameController.state.isTurnState(), true)
  }

  /**
   * Test to set a new state in the game controller.
   * The new state should be InitialPlayerState.
   */
  /**test("SetState") {
    val pj = gameController.state.calcTurns(gameModel.participants)
    gameController.SetState(new InitialPlayerState(gameModel.participants, pj))
    val newState = gameController.state
    assertEquals(newState.isInitialPlayerState(), true)
  }*/

  /**
   * Test to get the enemy by index.
   * The names of the enemies are checked.
   */
  test("getEnemy") {
    assertEquals(gameController.getEnemy(0).getName, "Messi")
    assertEquals(gameController.getEnemy(1).getName, "Guardiola")
    assertEquals(gameController.getEnemy(2).getName, "Laporta")
  }

  /**
   * Test to get the weapon by index.
   * The names of the weapons are checked.
   */
  test("getWeapon") {
    assertEquals(gameController.getWeapon(0).getName, "Arco")
    assertEquals(gameController.getWeapon(1).getName, "Espada")
    assertEquals(gameController.getWeapon(2).getName, "Hacha")
    assertEquals(gameController.getWeapon(3).getName, "Baston")
    assertEquals(gameController.getWeapon(4).getName, "Varita")
  }

  /**
   * Test to get the ally by index.
   * The names of the allies are checked.
   */
  test("getAlly") {
    assertEquals(gameController.getAlly(0).getName, "Cristiano")
    assertEquals(gameController.getAlly(1).getName, "Vinicius")
    assertEquals(gameController.getAlly(2).getName, "Zidane")
  }

  /**
   * Test to get the turn order of a game unit.
   * The turn order for allies and enemies is checked.
   */
  test("TurnoDe") {
    val pj: GameUnit = gameController.getAlly(0)
    val mpj: GameUnit = gameController.getAlly(1)
    val enemy: GameUnit = gameController.getEnemy(0)
    assertEquals(gameController.TurnoDe(pj), 2)
    assertEquals(gameController.TurnoDe(mpj), 2)
    assertEquals(gameController.TurnoDe(enemy), 1)
  }

  /**
   * Test to get the AI target.
   * The target should be one of the valid options (Cristiano, Vinicius, Zidane).
   * If some allies have 0 HP, the target should be Cristiano.
   */
  test("getAiTarget") {
    val target: GameUnit = gameController.getAITarget()
    val validOptions = Set("Cristiano", "Vinicius", "Zidane")
    assertTrue(validOptions.contains(target.getName))
    val ZZ: GameUnit = gameController.getAlly(2)
    ZZ.setHp(0)
    val VJr: GameUnit = gameController.getAlly(1)
    VJr.setHp(0)
    val newTarget: GameUnit = gameController.getAITarget()
    assertEquals(newTarget.getName, "Cristiano")
  }

  /**
   * Test to put the white flag.
   * The game should be marked as lost after putting the white flag.
   */
  test("PutWhiteFlag") {
    assertEquals(gameController.lose(), false)
    gameController.PutWhiteFlag()
    assertEquals(gameController.lose, true)
  }
}
