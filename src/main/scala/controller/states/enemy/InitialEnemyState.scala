package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the initial state for an enemy unit in the game.
 *
 * @param entities The turn schedule containing all game units.
 * @param src The specific enemy unit for which this state is initialized.
 */
class InitialEnemyState(val entities: TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Notifies the controller that the enemy's turn has started.
   *
   * @param controller The game controller handling the state transitions.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart(pj)
  }

  /**
   * Updates the game state based on the current status of the enemy unit.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input:Int = choice): Unit = {
    if (pj.getStatus == "Paralyzed") {controller.SetState(new ParalyzedState(pj, people))}

    else if (pj.getStatus == "Poisoned with Staff" || pj.getStatus == "Poisoned with Wand"){
               controller.SetState(new PoisonedState(pj, people))
    }
    else if (pj.getStatus == "Burned with Staff" || pj.getStatus == "Burned with Wand") {
             controller.SetState(new BurnedState(pj, people))
    }
    else {controller.SetState(new TargetEnemyState(pj, people))}
  }

  /**
   * Indicates whether this state is the initial state for an enemy unit.
   *
   * @return `true` since this is the initial state for an enemy unit.
   */
  override def isInitialEnemyState(): Boolean = true

}
