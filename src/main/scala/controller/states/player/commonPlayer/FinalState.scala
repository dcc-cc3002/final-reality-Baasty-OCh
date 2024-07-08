package controller.states.player.commonPlayer

import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule

/**
 * Final state representing the last action of a common player unit.
 *
 * @param ally The player unit performing the final action.
 * @param target The target unit being attacked.
 * @param entities The turn schedule containing game entities.
 */
class FinalState(var ally: GameUnit, private val target: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents the final action state of a common player unit.
   *
   * @return `true` since this state represents the final action state.
   */
  override def isFinalState(): Boolean = true

  /**
   * Updates the game state by performing the attack action and transitioning to the next turn state.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    pj.attack(target)
    controller.SetState(new TurnState(people))
  }
}
