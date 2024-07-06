package controller.states.player.magicPlayer

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

class HealingState(var ally: GameUnit, spell: Option[Spell],
                   var entities: TurnSchedule, weapon: Option[Weapon]) extends AGameState{
  private var selected: Option[GameUnit] = None
  var pj : GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  override def notify(controller: GameController) = {
    controller.notifyHealingTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try{
      selected = Some(controller.getAlly(choice - 1))
      pj.throwSpell(selected.get)
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    if(selected.map(_.getHp).getOrElse(0) != 0) {
      input match{
        case 0 => controller.SetState(new WeaponMagicState(pj, spell, people))
        case 1 => controller.SetState(new TurnState(people))
        case 2 => controller.SetState(new TurnState(people))
        case 3 => controller.SetState(new TurnState(people))
      }
    } else controller.SetState(new HealingState(pj,spell,people,weapon))
  }

  override def isHealingState(): Boolean = true
}
