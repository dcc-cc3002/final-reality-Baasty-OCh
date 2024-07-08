package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the state of an enemy unit that is poisoned and taking damage over time.
 *
 * @param enemy    The enemy unit that is poisoned.
 * @param entities The turn schedule containing all game units.
 */
class PoisonedState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = enemy
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Notifies the game controller about the status of the poisoned enemy unit.
   *
   * @param controller The game controller responsible for managing game states.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStatus(pj)
  }

  /**
   * Updates the game state when the poisoned enemy unit's turn ends.
   * Applies damage to the enemy unit over multiple turns, based on the poison type.
   * Resets the enemy unit's status to "Healthy" if the poison effect expires.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.cnt < 4) {
      // Damage calculation based on the type of burn status
      if (pj.getStatus == "Poisoned with Staff") {
        pj.wasAttacked(30)
      } else {
        pj.wasAttacked(15)
      }
      pj.cnt += 1
      // Transition to the next state
      if(pj.getHp == 0){
        controller.SetState(new TurnState(people))
      } else {
        controller.SetState(new TargetEnemyState(pj, people))}
    } else {
      // Resetting the enemy's status after the burn effect ends
      pj.setStatus("Healthy")
      // Transition to the next state
      controller.SetState(new TargetEnemyState(pj, people))
    }
  }

  /**
   * Indicates whether this state represents the poisoned state of an enemy unit.
   *
   * @return `true` since this state represents the poisoned state of an enemy unit.
   */
  override def isPoisonedState(): Boolean = true

}
