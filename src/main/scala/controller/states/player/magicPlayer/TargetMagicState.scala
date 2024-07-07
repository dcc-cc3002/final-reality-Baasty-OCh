package controller.states.player.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

/**
 * State representing the selection of a target for a magic spell by a magic-capable player unit.
 *
 * @param ally The player unit selecting the target for the spell.
 * @param spell The spell being used (optional).
 * @param entities The turn schedule containing game entities.
 * @param weapon The weapon being used (optional).
 */
class TargetMagicState(var ally: GameUnit, private val spell: Option[Spell],
                       var entities: TurnSchedule, var weapon: Option[Weapon]) extends AGameState {
  var selected: Option[GameUnit] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Secondary constructor to initialize the state with an optional weapon.
   *
   * @param ally The player unit selecting the target for the spell.
   * @param entities The turn schedule containing game entities.
   * @param w The weapon being used (optional).
   */
  def this(ally: GameUnit, entities: TurnSchedule, w: Option[Weapon]) = {
    this(ally, None, entities, w)
  }

  /**
   * Checks if the state represents the target selection phase of a magic spell.
   *
   * @return `true` since this state represents the target selection phase of a magic spell.
   */
  override def isTargetMagicState(): Boolean = true

  /**
   * Notifies the game controller to display the available targets for the magic spell.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerTarget()
  }

  /**
   * Handles player input during the target selection phase of a magic spell.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0) {
        selected = Some(controller.getEnemy(choice))
      } else if (choice == 4) {
        selected = Some(controller.getEnemy(choice - 2))
      } else {
        selected = Some(controller.getEnemy(choice - 1))
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on player input during the target selection phase of a magic spell.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (selected.map(_.getHp).getOrElse(0) == 0) {
      controller.SetState(new TargetMagicState(pj, spell, people, weapon))
      controller.notifyInvalidTarget()
    } else {
      input match {
        case 0 => controller.SetState(new WeaponMagicState(pj, spell, people))
        case 1 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 2 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 3 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 4 => controller.SetState(new SpellState(pj, people))
      }
    }
  }
}
