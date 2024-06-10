package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.spell.Spell


class TargetMagicState(private val source: GameUnit, private val spell: Option[Spell]) extends AGameState {
  private var selected: Option[GameUnit] = None
  var choice : Int = 0

  def this(source: GameUnit) = {
    this(source, None)
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
    choice match{
      case 0 =>controller.state = new WeaponMagicState(source, spell)
      case 1 =>controller.state = new FinalMagicState(source, selected.get, spell)
      case 2 =>controller.state = new FinalMagicState(source, selected.get, spell)
      case 3 =>controller.state = new FinalMagicState(source, selected.get, spell)
    }
  }

}
