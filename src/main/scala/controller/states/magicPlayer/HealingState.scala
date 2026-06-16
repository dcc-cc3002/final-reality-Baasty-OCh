package controller.states.magicPlayer

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

class HealingState(src: GameUnit, spell: Option[Spell],
                   people: TurnSchedule, weapon: Option[Weapon]) extends AGameState{
  private var selected: Option[GameUnit] = None
  var choice: Int = 0

  override def notify(controller: GameController) = {
    controller.notifyHealingTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try{
      selected = Some(controller.getAlly(choice - 1))
      src.throwSpell(selected.get)
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if(selected.map(_.getHp).getOrElse(0) != 0) {
      choice match{
        case 0 => controller.state = new WeaponMagicState(src, spell, people)
        case 1 => controller.state = new TurnState(people)
        case 2 => controller.state = new TurnState(people)
        case 3 => controller.state = new TurnState(people)
      }
    } else controller.state = new HealingState(src,spell,people,weapon)
  }
}
