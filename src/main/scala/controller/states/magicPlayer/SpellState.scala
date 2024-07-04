package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell

class SpellState(private val src: GameUnit,val people : TurnSchedule) extends AGameState {
  private var selected: Option[Spell] = None
  src.dropSpell()
  var choice : Int = 0

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitSpells(src)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0){
        val s = src.spells()(choice)
        src.selectSpell(s)
        selected = Some(s)
      }
      else {
        val s = src.spells()(choice - 1)
        src.selectSpell(s)
        selected = Some(s)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (src.spell.isEmpty) {
      controller.SetState(new SpellState(src,people))
    } else {
      choice match{
        case 0 => controller.SetState(new ActionMagicState(src,people))
        case 1 => controller.SetState(new WeaponMagicState(src,selected, people))
        case 2 => controller.SetState(new WeaponMagicState(src,selected, people))
        case 3 => controller.SetState(new WeaponMagicState(src,selected, people))
        case 4 => controller.SetState(new WeaponMagicState(src,selected, people))
        case 5 => controller.SetState(new WeaponMagicState(src,selected, people))
        case 6 => controller.SetState(new SpellState(src,people))

      }
    }
  }

}
