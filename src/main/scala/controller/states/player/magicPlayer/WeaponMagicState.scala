package controller.states.player.magicPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

/**
 * State representing the selection of a weapon by a magic-capable player unit.
 *
 * @param ally The player unit selecting the weapon.
 * @param spell The spell being used (optional).
 * @param entities The turn schedule containing game entities.
 */
class WeaponMagicState(var ally: GameUnit, private var spell: Option[Spell], var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Secondary constructor to initialize the state without a specified spell.
   *
   * @param ally The player unit selecting the weapon.
   * @param entities The turn schedule containing game entities.
   */
  def this(ally: GameUnit, entities: TurnSchedule) = {
    this(ally, None, entities)
  }

  private var selected: Option[Weapon] = None

  /**
   * Notifies the game controller to display the available weapons for the player unit.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerUnitWeapons(pj)
  }

  /**
   * Handles player input during the weapon selection phase for a magic-capable player unit.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0 || choice == 6) {
        val w = controller.getWeapon(choice)
        pj.putWeapon(w)
        selected = Some(w)
      } else {
        val w = controller.getWeapon(choice - 1)
        pj.putWeapon(w)
        selected = Some(w)
        people.deletePlayer(pj)
        people.addPlayer(pj)
      }
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on player input during the weapon selection phase for a magic-capable player unit.
   *
   * @param controller The game controller handling the game logic.
   * @param input The player's input choice.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.arma.isEmpty) {
      controller.SetState(new WeaponMagicState(pj, spell, people))
      controller.notifyInvalidWeapon()
    }
    else if (spell.isDefined && spell.get.getName == "Healing") {
      input match {
        case 1 => controller.SetState(new WeaponMagicState(pj, spell, people)) //
        case 2 => controller.SetState(new WeaponMagicState(pj, spell, people)) // quizas estos 3 casos se puedan sacar
        case 3 => controller.SetState(new WeaponMagicState(pj, spell, people)) //
        case 4 => controller.SetState(new HealingState(pj, spell, people, selected))
        case 5 => controller.SetState(new HealingState(pj, spell, people, selected))
      }
    }
    else {
      input match {
        case 1 => controller.SetState(new TargetMagicState(pj, spell, people, selected)) // revisar test
        case 2 => controller.SetState(new TargetMagicState(pj, spell, people, selected))
        case 3 => controller.SetState(new WeaponMagicState(pj, spell, people))
        case 4 => controller.SetState(new TargetMagicState(pj, spell, people, selected))
        case 5 => controller.SetState(new TargetMagicState(pj, spell, people, selected))


      }
    }
  }

  /**
   * Checks if the state represents the weapon selection phase for a magic-capable player unit.
   *
   * @return `true` since this state represents the weapon selection phase for a magic-capable player unit.
   */
  override def isWeaponMagicState(): Boolean = true
}
