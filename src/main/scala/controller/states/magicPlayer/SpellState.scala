package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.spell.Spell

class SpellState(private val src: GameUnit) extends AGameState {
  private var selected: Option[Spell] = None
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
    choice match{
      case 0 => controller.state = new ActionMagicState(src)
      case 1 => controller.state = new WeaponMagicState(src,selected)
      case 2 => controller.state = new WeaponMagicState(src,selected)
      case 3 => controller.state = new WeaponMagicState(src,selected)

    }
  }
}
