package controller.states.enemy

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell

class TargetEnemyState(private val source: GameUnit,val people : TurnSchedule) extends AGameState {
  private var selected : GameUnit = source



  override def handleInput(controller: GameController): Unit = {
    selected = controller.getAITarget()
  }

  override def update(controller: GameController): Unit = {
      controller.SetState(new FinalEnemyState(source, selected, people))
  }
}
