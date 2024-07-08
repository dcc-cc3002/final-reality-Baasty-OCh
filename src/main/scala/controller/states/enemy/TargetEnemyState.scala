package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Represents the state where an enemy unit selects its target to attack.
 *
 * @param enemy    The enemy unit that is selecting a target.
 * @param entities The turn schedule containing all game units.
 */
class TargetEnemyState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState {
  var selected: Option[GameUnit] = None
  var pj: GameUnit = enemy
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Handles input for selecting a target to attack.
   *
   * @param controller The game controller responsible for managing game states.
   */
  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAITarget())
  }

  /**
   * Updates the game state after selecting a target.
   *
   * @param controller The game controller handling the state transitions.
   * @param input      Optional input parameter (not used in this state).
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    controller.SetState(new FinalEnemyState(pj, selected.get, people))
  }

  /**
   * Indicates whether this state represents the targeting phase of an enemy unit.
   *
   * @return `true` since this state represents the targeting phase of an enemy unit.
   */
  override def isTargetEnemyState(): Boolean = true

}
