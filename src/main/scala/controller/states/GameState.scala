package controller.states

import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule


/**
 * Trait representing the various states that can occur within the game.
 * Defines methods for handling notifications, inputs, updates, and checking specific states.
 */
trait GameState {


  def calcTurns(t:TurnSchedule): GameUnit

  /**
   * Notify the controller of the current state.
   * @param controller the GameController instance to notify
   */
  def notify(controller: GameController): Unit

  /**
   * Handle input in the current state.
   * @param controller the GameController instance to handle input for
   */
  def handleInput(controller: GameController): Unit

  /**
   * Update the current state.
   * @param controller the GameController instance to update
   */
  def update(controller: GameController): Unit

  // General States

  /**
   * Check if the current state is the initial player state.
   * @return true if it is the initial player state, false otherwise
   */
  def isInitialPlayerState(): Boolean

  /**
   * Check if the current state is the surrender state.
   * @return true if it is the surrender state, false otherwise
   */
  def isSurrenderState(): Boolean

  /**
   * Check if the current state is a turn state.
   * @return true if it is a turn state, false otherwise
   */
  def isTurnState(): Boolean

  /**
   * Check if the current state is a unit state.
   * @return true if it is a unit state, false otherwise
   */
  def isUnitState(): Boolean

  // Common States

  /**
   * Check if the current state is an action state.
   * @return true if it is an action state, false otherwise
   */
  def isActionState(): Boolean

  /**
   * Check if the current state is the final state.
   * @return true if it is the final state, false otherwise
   */
  def isFinalState(): Boolean

  /**
   * Check if the current state is a target state.
   * @return true if it is a target state, false otherwise
   */
  def isTargetState(): Boolean

  /**
   * Check if the current state is a weapon state.
   * @return true if it is a weapon state, false otherwise
   */
  def isWeaponState(): Boolean

  // Magic States

  /**
   * Check if the current state is an action magic state.
   * @return true if it is an action magic state, false otherwise
   */
  def isActionMagicState(): Boolean

  /**
   * Check if the current state is the final magic state.
   * @return true if it is the final magic state, false otherwise
   */
  def isFinalMagicState(): Boolean

  /**
   * Check if the current state is a healing state.
   * @return true if it is a healing state, false otherwise
   */
  def isHealingState(): Boolean

  /**
   * Check if the current state is a spell state.
   * @return true if it is a spell state, false otherwise
   */
  def isSpellState(): Boolean

  /**
   * Check if the current state is a target magic state.
   * @return true if it is a target magic state, false otherwise
   */
  def isTargetMagicState(): Boolean

  /**
   * Check if the current state is a weapon magic state.
   * @return true if it is a weapon magic state, false otherwise
   */
  def isWeaponMagicState(): Boolean

  // Enemy States

  /**
   * Check if the current state is an enemy action state.
   * @return true if it is an enemy action state, false otherwise
   */
  def isAccionEnemyState(): Boolean

  /**
   * Check if the current state is a burned state.
   * @return true if it is a burned state, false otherwise
   */
  def isBurnedState(): Boolean

  /**
   * Check if the current state is the final enemy state.
   * @return true if it is the final enemy state, false otherwise
   */
  def isFinalEnemyState(): Boolean

  /**
   * Check if the current state is the initial enemy state.
   * @return true if it is the initial enemy state, false otherwise
   */
  def isInitialEnemyState(): Boolean

  /**
   * Check if the current state is a paralyzed state.
   * @return true if it is a paralyzed state, false otherwise
   */
  def isParalyzedState(): Boolean

  /**
   * Check if the current state is a poisoned state.
   * @return true if it is a poisoned state, false otherwise
   */
  def isPoisonedState(): Boolean

  /**
   * Check if the current state is a target enemy state.
   * @return true if it is a target enemy state, false otherwise
   */
  def isTargetEnemyState(): Boolean

  /**
   * Check if the current state is a unit enemy state.
   * @return true if it is a unit enemy state, false otherwise
   */
  def isUnitEnemyState(): Boolean

}
