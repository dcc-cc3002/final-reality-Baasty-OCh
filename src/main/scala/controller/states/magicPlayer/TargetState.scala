package controller.states.magicPlayer

import model.general.GameUnit
import controller.states.AGameState
import controller.GameController
import model.spell.Spell


class TargetState(private val source: GameUnit, private val spell: Option[Spell]) extends AGameState {
  private var selected: Option[GameUnit] = None

  def this(source: GameUnit) = {
    this(source, None)
  }

  override def notify(controller: GameController) = {
    controller.notifyPlayerTarget()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      selected = Some(controller.getEnemy(choice - 1))
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined) {
      controller.state = new FinalState(source, selected.get, spell)
    }
  }
}
