package controller.states.commonPlayer



import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.spell.Spell


class TargetState(private val source: GameUnit) extends AGameState {
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
    choice match {
      case 0 => controller.state = new WeaponState(source)
      case 1 => controller.state = new FinalState(source, selected.get)
      case 2 => controller.state = new FinalState(source, selected.get)
    }

  }
}
