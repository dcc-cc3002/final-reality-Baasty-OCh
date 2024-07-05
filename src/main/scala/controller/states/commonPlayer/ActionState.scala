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

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    if (!ally.arma.isEmpty){ // has a weapon
      choice match {
        case 0 => selected = Some(new SurrenderState(pj,people))
        case 1 => selected = Some(new TargetState(pj,people))
        case 2 => selected = Some(new WeaponState(pj,people))

      }
    } else { // has not a weapon
    choice match {
      case 0 => selected = Some(new SurrenderState(pj,people))
      case 1 => selected = Some(new WeaponState(pj,people))
      case 2 => selected = Some(new WeaponState(pj,people))
      case _ => controller.notifyErrorInvalidOption(choice)
    }
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.SetState(selected.get)
  }
}
