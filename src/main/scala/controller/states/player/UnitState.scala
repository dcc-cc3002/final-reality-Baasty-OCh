package controller.states.player

import controller.GameController
import controller.states.AGameState
import controller.states.player.commonPlayer.ActionState
import controller.states.player.magicPlayer.ActionMagicState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * State representing the unit's turn within the game.
 *
 * @param entities The turn schedule containing game entities.
 * @param src The game unit whose turn it is.
 */
class UnitState(val entities: TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents a unit state.
   *
   * @return `true` since this state represents a unit state.
   */
  override def isUnitState(): Boolean = true

  /**
   * Handles player input during the unit's turn.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = pj.IsMagic(pj)
  }

  /**
   * Updates the game state based on player input during the unit's turn.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    input match {
      case 0 => controller.SetState(new ActionState(pj, people))
      case 1 => controller.SetState(new ActionMagicState(pj, people))
    }
  }
}
