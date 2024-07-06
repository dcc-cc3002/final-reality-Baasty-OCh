package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class BurnedState(var enemy:GameUnit, var entities: TurnSchedule) extends  AGameState{
  var cnt: Int = 0
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStatus(pj)
  }
  override def update(controller: GameController, input:Int = choice): Unit = {
    if (cnt < 4){ // no esta pescando el tema de los turnos
      if (pj.getStatus == "Quemado con Baston"){
        pj.wasAttacked(30)
        cnt +=1
        controller.SetState(new TargetEnemyState(pj,people))
      } else {
        pj.wasAttacked(15)
        cnt +=1
        controller.SetState(new TargetEnemyState(pj,people))
      }
    }
    else {
      pj.setStatus("Sano")
      controller.SetState(new TargetEnemyState(pj,people))
    }
  }

  override def isBurnedState(): Boolean = true


}
