package controller.states.commonPlayer



import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell


class TargetState(private val source: GameUnit, val people : TurnSchedule) extends AGameState {
  private var selected: Option[GameUnit] = None
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

  override def update(controller: GameController): Unit = {
    if (selected.map(_.getHp).getOrElse(0) !=0){
    choice match {
      case 0 => controller.SetState(new WeaponState(source, people))
      case 1 => controller.SetState(new FinalState(source, selected.get, people))
      case 2 => controller.SetState(new FinalState(source, selected.get, people))
      case 3 => controller.SetState(new FinalState(source, selected.get, people))}
    } else controller.SetState(new TargetState(source, people))
  }


}
