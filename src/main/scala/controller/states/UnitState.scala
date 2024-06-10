package controller.states

import controller.GameController
import controller.states.commonPlayer.ActionState
import controller.states.magicPlayer.ActionMagicState
import model.general.GameUnit

class UnitState extends AGameState {
  private var selected: Option[GameUnit] = None
  private var choice: Int = 0

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnits()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getAlly(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.get.getHp != 0) {
      choice match{
        case 1 => controller.state = new ActionState(selected.get)
        case 2 => controller.state = new ActionState(selected.get)
        case 3 => controller.state = new ActionMagicState(selected.get)
      }
    } else controller.state = new UnitState()
  }

}
