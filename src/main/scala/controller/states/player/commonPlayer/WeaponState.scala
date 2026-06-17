package controller.states.player.commonPlayer

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.weapons.Weapon

/**
 * State representing the selection of weapons by a common player unit.
 *
 * @param ally The player unit selecting weapons.
 * @param entities The turn schedule containing game entities.
 */
class WeaponState(var ally: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0
  pj.dropWeapon()
  private var selected: Option[Weapon] = None

  /**
   * Checks if the state represents the weapon selection state.
   *
   * @return `true` since this state represents the weapon selection state.
   */
  override def isWeaponState(): Boolean = true

  /**
   * Notifies the controller to display the player's weapon options.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnitWeapons(pj)
  }

  /**
   * Handles the player's input to select a weapon.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0) {
        val w = controller.getWeapon(choice)
        pj.putWeapon(w)
        selected = Some(w)
      } else {
        val w = controller.getWeapon(choice - 1)
        if (w.getOwner().isEmpty) {
          pj.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(pj)
          people.addPlayer(pj)
        } else pj.dropWeapon()
      }
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on the player's input and selected weapon.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.arma.isEmpty) {
      controller.SetState(new WeaponState(pj, people))
      controller.notifyInvalidWeapon()
    } else {
      input match {
        case 1 => controller.SetState(new TargetState(pj, people))
        case 2 => controller.SetState(new TargetState(pj, people))
        case 3 => controller.SetState(new TargetState(pj, people))
        case 4 => controller.SetState(new WeaponState(pj, people))
        case 5 => controller.SetState(new WeaponState(pj, people))
      }
    }
  }

}
