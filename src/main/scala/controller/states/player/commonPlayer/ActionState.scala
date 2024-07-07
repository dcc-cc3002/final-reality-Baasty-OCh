package controller.states.player.commonPlayer

import controller.GameController
import controller.states.player.SurrenderState
import controller.states.{AGameState, GameState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * State representing actions available to a common player unit.
 *
 * @param ally The player unit performing actions.
 * @param entities The turn schedule containing game entities.
 */
class ActionState(private val ally: GameUnit, val entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents an action state for a common player unit.
   *
   * @return `true` since this state represents an action state for a common player unit.
   */
  override def isActionState(): Boolean = true

  /**
   * Notifies the game controller to display player action.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  /**
   * Handles player input during the action phase for a common player unit.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
  }

  /**
   * Updates the game state based on player input during the action phase for a common player unit.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (!ally.arma.isEmpty) { // has a weapon
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new TargetState(pj, people))
        case 2 => controller.SetState(new WeaponState(pj, people))
      }
    } else { // does not have a weapon
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new WeaponState(pj, people))
        case 2 => controller.SetState(new WeaponState(pj, people))
      }
    }
  }
}
