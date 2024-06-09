package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.spell.Spell

class SpellState(private val src: GameUnit) extends AGameState {
  private var selected: Option[Spell] = None

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitSpells(src)
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      val s = src.spells()(choice - 1)
      src.selectSpell(s)
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(src, selected)
  }
}
