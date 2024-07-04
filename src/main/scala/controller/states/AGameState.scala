package controller.states

import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.playable.common.Paladin

/**
 * Abstract class representing a base game state.
 * Provides default implementations for the methods defined in the GameState trait.
 */
abstract class AGameState extends GameState {


  /**
   * Handle input in the current state.
   * Default implementation does nothing.
   * @param controller the GameController instance to handle input for
   */
  override def handleInput(controller: GameController): Unit = {}

  /**
   * Update the current state.
   * Default implementation does nothing.
   * @param controller the GameController instance to update
   */
  override def update(controller: GameController): Unit = {}

  /**
   * Notify the controller of the current state.
   * Default implementation does nothing.
   * @param controller the GameController instance to notify
   */
  override def notify(controller: GameController): Unit = {}

  // General States

  /**
   * Check if the current state is the initial player state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isInitialPlayerState(): Boolean = false

  /**
   * Check if the current state is the surrender state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isSurrenderState(): Boolean = false

  /**
   * Check if the current state is a turn state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isTurnState(): Boolean = false

  /**
   * Check if the current state is a unit state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isUnitState(): Boolean = false

  // Common States

  /**
   * Check if the current state is an action state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isActionState(): Boolean = false

  /**
   * Check if the current state is the final state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isFinalState(): Boolean = false

  /**
   * Check if the current state is a target state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isTargetState(): Boolean = false

  /**
   * Check if the current state is a weapon state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isWeaponState(): Boolean = false

  // Magic States

  /**
   * Check if the current state is an action magic state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isActionMagicState(): Boolean = false

  /**
   * Check if the current state is the final magic state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isFinalMagicState(): Boolean = false

  /**
   * Check if the current state is a healing state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isHealingState(): Boolean = false

  /**
   * Check if the current state is a spell state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isSpellState(): Boolean = false

  /**
   * Check if the current state is a target magic state.
   * Default implementation returns true.
   * @return true by default
   */
  override def isTargetMagicState(): Boolean = true

  /**
   * Check if the current state is a weapon magic state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isWeaponMagicState(): Boolean = false

  // Enemy States

  /**
   * Check if the current state is an enemy action state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isAccionEnemyState(): Boolean = false

  /**
   * Check if the current state is a burned state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isBurnedState(): Boolean = false

  /**
   * Check if the current state is the final enemy state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isFinalEnemyState(): Boolean = false

  /**
   * Check if the current state is the initial enemy state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isInitialEnemyState(): Boolean = false

  /**
   * Check if the current state is a paralyzed state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isParalyzedState(): Boolean = false

  /**
   * Check if the current state is a poisoned state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isPoisonedState(): Boolean = false

  /**
   * Check if the current state is a target enemy state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isTargetEnemyState(): Boolean = false

  /**
   * Check if the current state is a unit enemy state.
   * Default implementation returns false.
   * @return false by default
   */
  override def isUnitEnemyState(): Boolean = false

}
