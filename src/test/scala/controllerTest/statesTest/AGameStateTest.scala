package controllerTest.statesTest
package controllerTest


import controller.GameController
import controller.states.{AGameState, GameState, TurnState}
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
  val TurnTest: AGameState = new TurnState(gameModel.participants)

  /**
   * Test to check if the state is InitialPlayerState.
   * The default implementation should return false.
   */
  test("isInitialPlayerState") {
    assertEquals(TurnTest.isInitialPlayerState(), false)
  }

  /**
   * Test to check if the state is SurrenderState.
   * The default implementation should return false.
   */
  test("isSurrenderState") {
    assertEquals(TurnTest.isSurrenderState(), false)
  }

  /**
   * Test to check if the state is TurnState.
   * The default implementation should return false.
   */
  test("isTurnState") {
    assertEquals(TurnTest.isTurnState(), true)
  }

  /**
   * Test to check if the state is UnitState.
   * The default implementation should return false.
   */
  test("isUnitState") {
    assertEquals(TurnTest.isUnitState(), false)
  }

  /**
   * Test to check if the state is ActionState.
   * The default implementation should return false.
   */
  test("isActionState") {
    assertEquals(TurnTest.isActionState(), false)
  }

  /**
   * Test to check if the state is FinalState.
   * The default implementation should return false.
   */
  test("isFinalState") {
    assertEquals(TurnTest.isFinalState(), false)
  }

  /**
   * Test to check if the state is TargetState.
   * The default implementation should return false.
   */
  test("isTargetState") {
    assertEquals(TurnTest.isTargetState(), false)
  }

  /**
   * Test to check if the state is WeaponState.
   * The default implementation should return false.
   */
  test("isWeaponState") {
    assertEquals(TurnTest.isWeaponState(), false)
  }

  /**
   * Test to check if the state is ActionMagicState.
   * The default implementation should return false.
   */
  test("isActionMagicState") {
    assertEquals(TurnTest.isActionMagicState(), false)
  }

  /**
   * Test to check if the state is FinalMagicState.
   * The default implementation should return false.
   */
  test("isFinalMagicState") {
    assertEquals(TurnTest.isFinalMagicState(), false)
  }

  /**
   * Test to check if the state is HealingState.
   * The default implementation should return false.
   */
  test("isHealingState") {
    assertEquals(TurnTest.isHealingState(), false)
  }

  /**
   * Test to check if the state is SpellState.
   * The default implementation should return false.
   */
  test("isSpellState") {
    assertEquals(TurnTest.isSpellState(), false)
  }

  /**
   * Test to check if the state is TargetMagicState.
   * The default implementation should return true.
   */
  test("isTargetMagicState") {
    assertEquals(TurnTest.isTargetMagicState(), true)
  }

  /**
   * Test to check if the state is WeaponMagicState.
   * The default implementation should return false.
   */
  test("isWeaponMagicState") {
    assertEquals(TurnTest.isWeaponMagicState(), false)
  }

  /**
   * Test to check if the state is AccionEnemyState.
   * The default implementation should return false.
   */
  test("isAccionEnemyState") {
    assertEquals(TurnTest.isAccionEnemyState(), false)
  }

  /**
   * Test to check if the state is BurnedState.
   * The default implementation should return false.
   */
  test("isBurnedState") {
    assertEquals(TurnTest.isBurnedState(), false)
  }

  /**
   * Test to check if the state is FinalEnemyState.
   * The default implementation should return false.
   */
  test("isFinalEnemyState") {
    assertEquals(TurnTest.isFinalEnemyState(), false)
  }

  /**
   * Test to check if the state is InitialEnemyState.
   * The default implementation should return false.
   */
  test("isInitialEnemyState") {
    assertEquals(TurnTest.isInitialEnemyState(), false)
  }

  /**
   * Test to check if the state is ParalyzedState.
   * The default implementation should return false.
   */
  test("isParalyzedState") {
    assertEquals(TurnTest.isParalyzedState(), false)
  }

  /**
   * Test to check if the state is PoisonedState.
   * The default implementation should return false.
   */
  test("isPoisonedState") {
    assertEquals(TurnTest.isPoisonedState(), false)
  }

  /**
   * Test to check if the state is TargetEnemyState.
   * The default implementation should return false.
   */
  test("isTargetEnemyState") {
    assertEquals(TurnTest.isTargetEnemyState(), false)
  }

  /**
   * Test to check if the state is UnitEnemyState.
   * The default implementation should return false.
   */
  test("isUnitEnemyState") {
    assertEquals(TurnTest.isUnitEnemyState(), false)
  }
}

