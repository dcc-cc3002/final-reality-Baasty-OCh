package controller.states.player

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * Initial state for the player's turn.
 *
 * @param entities The turn schedule containing game entities.
 * @param src The game unit representing the player.
 */
class InitialPlayerState(val entities: TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents the initial player state.
   *
   * @return `true` since this state represents the initial player state.
   */
  override def isInitialPlayerState(): Boolean = true

  /**
   * Updates the game state to transition to the unit state.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    controller.SetState(new UnitState(people, pj))
  }

  /**
   * Notifies the game controller to display a message indicating the start of the player's turn.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart(pj)
  }
}
