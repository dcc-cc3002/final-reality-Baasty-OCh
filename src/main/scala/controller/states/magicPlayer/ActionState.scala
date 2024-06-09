package controller.states.magicPlayer

import controller.GameController
import controller.states.{AGameState, GameState}
import model.general.GameUnit

class ActionState(private val ally: GameUnit) extends AGameState {
  private var selected: Option[GameState] = None

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    choice match {
      case 0 => selected = Some(new UnitState())
      case 1 => selected = Some(new WeaponState(ally))
      case 2 => selected = Some(new SpellState(ally))
      case _ => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = selected.get
  }
}
