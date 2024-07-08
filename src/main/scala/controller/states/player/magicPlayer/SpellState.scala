package controller.states.player.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell

/**
 * State representing the selection and use of a spell by a magic-capable player unit.
 *
 * @param ally The player unit selecting and using the spell.
 * @param entities The turn schedule containing game entities.
 */
class SpellState(var ally: GameUnit, var entities: TurnSchedule) extends AGameState {
  private var selected: Option[Spell] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0
  pj.dropSpell()

  /**
   * Notifies the game controller to display the spells available to the player unit.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnitSpells(pj)
  }

  /**
   * Handles player input during the spell selection phase.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0) {
        val s = pj.spells()(choice)
        pj.selectSpell(s)
        selected = Some(s)
      } else {
        val s = pj.spells()(choice - 1)
        pj.selectSpell(s)
        selected = Some(s)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on player input during the spell selection phase.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.spell.isEmpty) {
      controller.SetState(new SpellState(pj, people))
      controller.notifyInvalidSpell()
    } else if (selected.isDefined ){
      if((pj.getMana < selected.get.getCost)) {
        controller.SetState(new ActionMagicState(pj,people))
        controller.notifyNoMana()
      } else{}
    }
    else {
      input match {
        case 1 => controller.SetState(new WeaponMagicState(pj, selected, people))
        case 2 => controller.SetState(new WeaponMagicState(pj, selected, people))
        case 3 => controller.SetState(new WeaponMagicState(pj, selected, people))
        case 4 => controller.SetState(new WeaponMagicState(pj, selected, people))
        case 5 => controller.SetState(new WeaponMagicState(pj, selected, people))
      }
    }
  }

  /**
   * Checks if the state represents the spell selection state.
   *
   * @return `true` since this state represents the spell selection state.
   */
  override def isSpellState(): Boolean = true
}
