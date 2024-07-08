package controller.states.player.magicPlayer

import controller.GameController
import controller.states.player.{SurrenderState}
import controller.states.{AGameState, GameState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * State representing the action phase for a magic-capable player unit.
 *
 * @param ally The player unit performing the action.
 * @param entities The turn schedule containing game entities.
 */
class ActionMagicState(var ally: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents an action magic state.
   *
   * @return `true` since this state represents an action magic state.
   */
  override def isActionMagicState(): Boolean = true

  /**
   * Notifies the game controller to display a message indicating the start of the player's magic action.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerAction()
  }

  /**
   * Handles player input during the magic action phase.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
  }

  /**
   * Updates the game state based on player input during the magic action phase.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.arma.isDefined || pj.spell.isDefined) { // has Weapon or Spell
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new TargetMagicState(pj, people, pj.arma))
        case 2 => controller.SetState(new SpellState(pj, people))
        case 3 => controller.SetState(new WeaponMagicState(pj, people))
        case 4 => controller.SetState(new SpellState(pj, people))
      }
    } else {
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new WeaponMagicState(pj, people))
        case 2 => controller.SetState(new SpellState(pj, people))
        case 3 => controller.SetState(new WeaponMagicState(pj, people))
        case 4 => controller.SetState(new SpellState(pj, people))
        case _ => controller.notifyErrorInvalidOption(choice)
      }
    }
  }
}
