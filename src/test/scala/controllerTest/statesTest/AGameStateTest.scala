package controllerTest.statesTest
package controllerTest


import controller.GameController
import controller.states.{GameState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

/**
 * Test suite for the AGameState class.
 * This class contains various tests to ensure the correct functionality of the AGameState methods.
 */
class AGameStateTest extends FunSuite {
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

  /**
   * Test to check if the state is InitialPlayerState.
   * The default implementation should return false.
   */
  test("isInitialPlayerState") {
    assertEquals(testState.isInitialPlayerState(), false)
  }

  /**
   * Test to check if the state is SurrenderState.
   * The default implementation should return false.
   */
  test("isSurrenderState") {
    assertEquals(testState.isSurrenderState(), false)
  }

  /**
   * Test to check if the state is TurnState.
   * The default implementation should return false.
   */
  test("isTurnState") {
    assertEquals(testState.isTurnState(), true)
  }

  /**
   * Test to check if the state is UnitState.
   * The default implementation should return false.
   */
  test("isUnitState") {
    assertEquals(testState.isUnitState(), false)
  }

  /**
   * Test to check if the state is ActionState.
   * The default implementation should return false.
   */
  test("isActionState") {
    assertEquals(testState.isActionState(), false)
  }

  /**
   * Test to check if the state is FinalState.
   * The default implementation should return false.
   */
  test("isFinalState") {
    assertEquals(testState.isFinalState(), false)
  }

  /**
   * Test to check if the state is TargetState.
   * The default implementation should return false.
   */
  test("isTargetState") {
    assertEquals(testState.isTargetState(), false)
  }

  /**
   * Test to check if the state is WeaponState.
   * The default implementation should return false.
   */
  test("isWeaponState") {
    assertEquals(testState.isWeaponState(), false)
  }

  /**
   * Test to check if the state is ActionMagicState.
   * The default implementation should return false.
   */
  test("isActionMagicState") {
    assertEquals(testState.isActionMagicState(), false)
  }

  /**
   * Test to check if the state is FinalMagicState.
   * The default implementation should return false.
   */
  test("isFinalMagicState") {
    assertEquals(testState.isFinalMagicState(), false)
  }

  /**
   * Test to check if the state is HealingState.
   * The default implementation should return false.
   */
  test("isHealingState") {
    assertEquals(testState.isHealingState(), false)
  }

  /**
   * Test to check if the state is SpellState.
   * The default implementation should return false.
   */
  test("isSpellState") {
    assertEquals(testState.isSpellState(), false)
  }

  /**
   * Test to check if the state is TargetMagicState.
   * The default implementation should return true.
   */
  test("isTargetMagicState") {
    assertEquals(testState.isTargetMagicState(), true)
  }

  /**
   * Test to check if the state is WeaponMagicState.
   * The default implementation should return false.
   */
  test("isWeaponMagicState") {
    assertEquals(testState.isWeaponMagicState(), false)
  }

  /**
   * Test to check if the state is AccionEnemyState.
   * The default implementation should return false.
   */
  test("isAccionEnemyState") {
    assertEquals(testState.isAccionEnemyState(), false)
  }

  /**
   * Test to check if the state is BurnedState.
   * The default implementation should return false.
   */
  test("isBurnedState") {
    assertEquals(testState.isBurnedState(), false)
  }

  /**
   * Test to check if the state is FinalEnemyState.
   * The default implementation should return false.
   */
  test("isFinalEnemyState") {
    assertEquals(testState.isFinalEnemyState(), false)
  }

  /**
   * Test to check if the state is InitialEnemyState.
   * The default implementation should return false.
   */
  test("isInitialEnemyState") {
    assertEquals(testState.isInitialEnemyState(), false)
  }

  /**
   * Test to check if the state is ParalyzedState.
   * The default implementation should return false.
   */
  test("isParalyzedState") {
    assertEquals(testState.isParalyzedState(), false)
  }

  /**
   * Test to check if the state is PoisonedState.
   * The default implementation should return false.
   */
  test("isPoisonedState") {
    assertEquals(testState.isPoisonedState(), false)
  }

  /**
   * Test to check if the state is TargetEnemyState.
   * The default implementation should return false.
   */
  test("isTargetEnemyState") {
    assertEquals(testState.isTargetEnemyState(), false)
  }

  /**
   * Test to check if the state is UnitEnemyState.
   * The default implementation should return false.
   */
  test("isUnitEnemyState") {
    assertEquals(testState.isUnitEnemyState(), false)
  }
}

