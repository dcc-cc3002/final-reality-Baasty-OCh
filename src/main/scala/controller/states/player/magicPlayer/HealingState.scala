package controller.states.player.magicPlayer

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

/**
 * State representing the healing phase for a magic-capable player unit.
 *
 * @param ally The player unit performing the healing action.
 * @param spell The spell being used for healing, if any.
 * @param entities The turn schedule containing game entities.
 * @param weapon The weapon being used for healing, if any.
 */
class HealingState(var ally: GameUnit, spell: Option[Spell],
                   var entities: TurnSchedule, weapon: Option[Weapon]) extends AGameState {
  var selected: Option[GameUnit] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Notifies the game controller to display the healing target selection message.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyHealingTarget()
  }

  /**
   * Handles player input during the healing action phase.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getAlly(choice - 1))
      pj.throwSpell(selected.get)
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on player input during the healing action phase.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (selected.map(_.getHp).getOrElse(0) != 0) {
      input match {
        case 1 => controller.SetState(new TurnState(people))
        case 2 => controller.SetState(new TurnState(people))
        case 3 => controller.SetState(new TurnState(people)) // revisar
      }
    } else controller.SetState(new HealingState(pj, spell, people, weapon))
  }

  /**
   * Checks if the state represents the healing action state.
   *
   * @return `true` since this state represents the healing action state.
   */
  override def isHealingState(): Boolean = true
}
