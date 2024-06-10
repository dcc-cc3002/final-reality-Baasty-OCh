package controller.states.enemy

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.spell.Spell

class TargetEnemyState(private val source: GameUnit) extends AGameState {
  private var selected: Option[GameUnit] = None



  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAITarget())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new FinalEnemyState(source, selected.get)
  }
}
