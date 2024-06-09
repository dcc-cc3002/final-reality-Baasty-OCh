package controller.states.enemy

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.spell.Spell

class TargetState(private val source: GameUnit,private val spell: Option[Spell]) extends AGameState {
  private var selected: Option[GameUnit] = None

  def this(source: GameUnit) = {
    this(source,None)
  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAITarget())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new FinalState(source, selected.get)
  }
}
