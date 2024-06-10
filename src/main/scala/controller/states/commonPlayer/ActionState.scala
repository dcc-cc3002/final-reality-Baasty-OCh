package controller.states.commonPlayer


import controller.GameController
import controller.states.magicPlayer.SpellState
import controller.states.{AGameState, GameState, UnitState}
import model.general.GameUnit
import model.playable.Playable

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
      case _ => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = selected.get
  }
}
