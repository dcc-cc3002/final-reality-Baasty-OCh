package controller.states.player.commonPlayer

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule

/**
 * State representing the selection of a target by a common player unit.
 *
 * @param ally The player unit selecting the target.
 * @param entities The turn schedule containing game entities.
 */
class TargetState(var ally: GameUnit, var entities: TurnSchedule) extends AGameState {
  private var selected: Option[GameUnit] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Checks if the state represents the target selection state.
   *
   * @return `true` since this state represents the target selection state.
   */
  override def isTargetState(): Boolean = true

  /**
   * Notifies the controller to display the player's target options.
   *
   * @param controller The game controller handling the game logic.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerTarget()
  }

  /**
   * Handles the player's input to select a target.
   *
   * @param controller The game controller handling the game logic.
   */
  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0) {
        selected = Some(controller.getEnemy(choice))
      } else {
        selected = Some(controller.getEnemy(choice - 1))
      }
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the game state based on the player's input and selected target.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (selected.map(_.getHp).getOrElse(10) == 0 || selected.isEmpty) {
      controller.SetState(new TargetState(pj, people))
      controller.notifyInvalidTarget()
    } else {
      input match {
        case 0 => controller.SetState(new WeaponState(pj, people))
        case 1 => controller.SetState(new FinalState(pj, selected.get, people))
        case 2 => controller.SetState(new FinalState(pj, selected.get, people))
        case 3 => controller.SetState(new FinalState(pj, selected.get, people))
      }
    }
  }

}
