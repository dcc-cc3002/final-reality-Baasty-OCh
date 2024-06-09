package controller.states.magicPlayer

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit

class UnitState extends AGameState {
  private var selected: Option[GameUnit] = None

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnits()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getAlly(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new ActionState(selected.get)
  }
}
