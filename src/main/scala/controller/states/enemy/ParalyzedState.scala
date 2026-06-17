package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import controller.states.TurnState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the state of an enemy unit that is paralyzed and unable to act.
 *
 * @param enemy    The enemy unit that is paralyzed.
 * @param entities The turn schedule containing all game units.
 */
class ParalyzedState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = enemy
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Notifies the game controller about the status of the paralyzed enemy unit.
   *
   * @param controller The game controller responsible for managing game states.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStatus(enemy)
  }

  /**
   * Updates the game state when the paralyzed enemy unit's turn ends.
   * Sets the enemy unit's status to "Healthy" and transitions to the next turn state.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    // Reset the enemy unit's status to "Healthy"
    enemy.setStatus("Healthy")
    // Transition to the next turn state
    controller.SetState(new TurnState(people))
  }

  /**
   * Indicates whether this state represents the paralyzed state of an enemy unit.
   *
   * @return `true` since this state represents the paralyzed state of an enemy unit.
   */
  override def isParalyzedState(): Boolean = true

}
