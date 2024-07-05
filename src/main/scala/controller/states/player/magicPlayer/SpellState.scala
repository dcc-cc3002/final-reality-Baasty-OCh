package controller.states.player.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell

class SpellState(var ally: GameUnit,var entities : TurnSchedule) extends AGameState {
  private var selected: Option[Spell] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0
  pj.dropSpell()

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitSpells(pj)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0){
        val s = pj.spells()(choice)
        pj.selectSpell(s)
        selected = Some(s)
      }
      else {
        val s = pj.spells()(choice - 1)
        pj.selectSpell(s)
        selected = Some(s)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    if (pj.spell.isEmpty) {
      controller.SetState(new SpellState(pj,people))
      controller.notifyInvalidSpell()
    } else {
      input match{
        case 0 => controller.SetState(new ActionMagicState(pj,people)) // sacar con vista
        case 1 => controller.SetState(new WeaponMagicState(pj,selected, people))
        case 2 => controller.SetState(new WeaponMagicState(pj,selected, people))
        case 3 => controller.SetState(new WeaponMagicState(pj,selected, people))
        case 4 => controller.SetState(new WeaponMagicState(pj,selected, people))
        case 5 => controller.SetState(new WeaponMagicState(pj,selected, people))
        case 6 => controller.SetState(new SpellState(pj,people))

      }
    }
  }

}
