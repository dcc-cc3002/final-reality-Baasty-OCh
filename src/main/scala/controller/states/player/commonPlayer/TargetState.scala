package controller.states.player.commonPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell


class TargetState(var ally: GameUnit, var entities : TurnSchedule) extends AGameState {
  private var selected: Option[GameUnit] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0


  override def notify(controller: GameController) = {
    controller.notifyPlayerTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0){
        selected = Some(controller.getEnemy(choice))
      } else selected = Some(controller.getEnemy(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    if (selected.map(_.getHp).getOrElse(0) ==0){
      controller.SetState(new TargetState(pj, people))
      controller.notifyInvalidTarget()
    } else {
      input match {
        case 0 => controller.SetState(new WeaponState(pj, people))
        case 1 => controller.SetState(new FinalState(pj, selected.get, people))
        case 2 => controller.SetState(new FinalState(pj, selected.get, people))
        case 3 => controller.SetState(new FinalState(pj, selected.get, people))}
    }
  }

}
