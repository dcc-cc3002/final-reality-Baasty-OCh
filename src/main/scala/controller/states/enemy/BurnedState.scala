package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the state of an enemy unit that is burned and taking damage over multiple turns.
 *
 * @param enemy    The enemy unit affected by burning status.
 * @param entities The turn schedule containing all game units.
 */
class BurnedState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState {
  var cnt: Int = 0
  var pj: GameUnit = enemy
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Notifies the controller about the status of the enemy unit.
   *
   * @param controller The game controller handling the state transitions.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStatus(pj)
  }

  /**
   * Updates the game state for the burned enemy unit, reducing health over time.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (cnt < 4) {
      // Damage calculation based on the type of burn status
      if (pj.getStatus == "Burned with Staff") {
        pj.wasAttacked(30)
      } else {
        pj.wasAttacked(15)
      }
      cnt += 1
      // Transition to the next state
      controller.SetState(new TargetEnemyState(pj, people))
    } else {
      // Resetting the enemy's status after the burn effect ends
      pj.setStatus("Healthy")
      // Transition to the next state
      controller.SetState(new TargetEnemyState(pj, people))
    }
  }

  /**
   * Indicates whether this state represents an enemy unit that is burned.
   *
   * @return `true` since this state represents a burned enemy unit.
   */
  override def isBurnedState(): Boolean = true

}
