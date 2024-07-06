package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class ParalyzedState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState{
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0
  override def notify(controller: GameController) = {
    controller.notifyEnemyStatus(enemy)
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    enemy.setStatus("Sano")
    controller.SetState(new TurnState(people))

  }

  override def isParalyzedState(): Boolean = true



}
