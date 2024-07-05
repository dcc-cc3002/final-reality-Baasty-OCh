package controller.states.commonPlayer


import controller.GameController
import controller.states.magicPlayer.SpellState
import controller.states.{AGameState, GameState, SurrenderState, UnitState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.playable.Playable

class ActionState(private val ally: GameUnit,val entities : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  override def isActionState(): Boolean = true
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()

  }

  override def update(controller: GameController, input: Int = choice): Unit = {
    if (!ally.arma.isEmpty) { // has a weapon
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new TargetState(pj, people))
        case 2 => controller.SetState(new WeaponState(pj, people))

      }
    } else { // has not a weapon
      input match {
        case 0 => controller.SetState(new SurrenderState(pj, people))
        case 1 => controller.SetState(new WeaponState(pj, people))
        case 2 => controller.SetState(new WeaponState(pj, people))
        case _ => controller.notifyErrorInvalidOption(choice)
      }
    }
  }
}
