package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell


class TargetMagicState(private val source: GameUnit, private val spell: Option[Spell], val people : TurnSchedule) extends AGameState {
  private var selected: Option[GameUnit] = None
  var choice : Int = 0

  def this(source: GameUnit, t :TurnSchedule) = {
    this(source, None,t)
  }

  override def notify(controller: GameController) = {
    controller.notifyPlayerTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0) {
        selected = Some(controller.getEnemy(choice))
      }
      else {
        selected = Some(controller.getEnemy(choice - 1))
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if(selected.map(_.getHp).getOrElse(0) != 0)
    choice match{
      case 0 =>controller.state = new WeaponMagicState(source, spell,people)
      case 1 =>controller.state = new FinalMagicState(source, selected.get, spell, people)
      case 2 =>controller.state = new FinalMagicState(source, selected.get, spell, people)
      case 3 =>controller.state = new FinalMagicState(source, selected.get, spell, people)
    } else controller.state = new TargetMagicState(source, spell, people)
  }

}
