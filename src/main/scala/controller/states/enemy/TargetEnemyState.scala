package controller.states.enemy

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell

class TargetEnemyState(var enemy: GameUnit, var entities : TurnSchedule) extends AGameState {
  var selected : Option[GameUnit] = None
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0



  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAITarget())
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
      controller.SetState(new FinalEnemyState(pj, selected.get, people))
  }

  override def isTargetEnemyState(): Boolean = true
}
