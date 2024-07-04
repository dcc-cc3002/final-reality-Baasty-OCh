package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon


class TargetMagicState(private val source: GameUnit, private val spell: Option[Spell], val people : TurnSchedule, var weapon: Option[Weapon]) extends AGameState {
  private var selected: Option[GameUnit] = None
  var choice : Int = 0

  def this(source: GameUnit, t :TurnSchedule, w :Option[Weapon]) = {
    this(source, None,t, w)
  }

  override def notify(controller: GameController) = {
    controller.notifyMagicPlayerTarget()
  }


  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0 ) {
        selected = Some(controller.getEnemy(choice))
      }
      else if (choice == 4){
        selected = Some(controller.getEnemy(choice-2))
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
      case 0 => controller.SetState(new WeaponMagicState(source, spell,people))
      case 1 => controller.SetState(new FinalMagicState(source, selected.get, spell, people, weapon))
      case 2 => controller.SetState(new FinalMagicState(source, selected.get, spell, people, weapon))
      case 3 => controller.SetState(new FinalMagicState(source, selected.get, spell, people, weapon))
      case 4 => controller.SetState(new SpellState(source,people))
    } else controller.SetState(new TargetMagicState(source, spell, people, weapon))
  }

}
