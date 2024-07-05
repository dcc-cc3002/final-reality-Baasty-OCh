package controller.states.enemy

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class UnitEnemyState(var enemy: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart(pj)
  }

  override def handleInput(controller: GameController): Unit = {}

  override def update(controller: GameController, input:Int = choice): Unit = {
    controller.SetState(new ActionEnemyState(pj,people))
  }
} 
