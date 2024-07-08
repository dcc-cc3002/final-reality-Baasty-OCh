package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import controller.states.TurnState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the final state of an enemy unit performing an attack on a target unit.
 *
 * @param enemy    The enemy unit initiating the attack.
 * @param dest     The target unit being attacked.
 * @param entities The turn schedule containing all game units.
 */
class FinalEnemyState(var enemy: GameUnit, private val dest: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = enemy
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Updates the game state for the enemy unit performing an attack on the target unit.
   * Initiates the attack and transitions to the next turn state.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    // Perform attack action by the enemy unit
    pj.attack(dest)
    // Transition to the next turn state
    controller.SetState(new TurnState(people))
  }

  /**
   * Indicates whether this state represents the final state of an enemy unit performing an attack.
   *
   * @return `true` since this state represents the final attack state of an enemy unit.
   */
  override def isFinalEnemyState(): Boolean = true

}
