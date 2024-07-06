package controller.states.player.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon


class TargetMagicState(var ally: GameUnit, private val spell: Option[Spell],
                       var entities : TurnSchedule, var weapon: Option[Weapon]) extends AGameState {
  var selected: Option[GameUnit] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0

  override def isTargetMagicState(): Boolean = true
  def this(ally: GameUnit, entities :TurnSchedule, w :Option[Weapon]) = {
    this(ally, None, entities, w)
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

  override def update(controller: GameController, input:Int = choice): Unit = {
    if(selected.map(_.getHp).getOrElse(0) == 0){
      controller.SetState(new TargetMagicState(pj, spell, people, weapon))
      controller.notifyInvalidTarget()
    } else{
      input match{
        case 0 => controller.SetState(new WeaponMagicState(pj, spell,people))
        case 1 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 2 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 3 => controller.SetState(new FinalMagicState(pj, selected.get, spell, people, weapon))
        case 4 => controller.SetState(new SpellState(pj,people))
      }
    }
  }

}
