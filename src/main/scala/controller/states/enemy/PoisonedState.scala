package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class PoisonedState (var enemy: GameUnit, var entities: TurnSchedule) extends AGameState{
  private var cnt: Int = 0
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0
  override def notify(controller: GameController) = {
    controller.notifyEnemyStatus(pj)
  }

  override def update(controller: GameController): Unit = {
    if (cnt < 4){ // no esta pescando el tema de los turnos, hay que implementarlo diff
      if (pj.getStatus == "Envenenado con Baston"){
        pj.wasAttacked(20)
        cnt +=1
        controller.SetState(new TargetEnemyState(pj,people))
      } else {
        pj.wasAttacked(10)
        cnt +=1
        controller.SetState(new TargetEnemyState(pj,people))
      }
    }
    else {
      pj.setStatus("Sano")
      controller.SetState(new TargetEnemyState(pj,people))
    }
  }

}
