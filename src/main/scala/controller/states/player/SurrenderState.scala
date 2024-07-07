package controller.states.player

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * State representing the surrender action of a player unit.
 *
 * @param src The game unit that is surrendering.
 * @param entities The turn schedule containing game entities.
 */
class SurrenderState(src: GameUnit, entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents a surrender state.
   *
   * @return `true` since this state represents a surrender state.
   */
  override def isSurrenderState(): Boolean = true

  /**
   * Notifies the game controller to display a surrender message for the player unit.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifySurrenderMessage(pj)
  }

  /**
   * Updates the game state to trigger a white flag scenario.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    controller.PutWhiteFlag()
  }
}
