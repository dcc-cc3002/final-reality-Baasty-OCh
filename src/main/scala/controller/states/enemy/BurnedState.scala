package controller.states.enemy

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class BurnedState(enemy:GameUnit, people: TurnSchedule) extends  AGameState{
  private var cnt: Int = 0
  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStatus(enemy)
  }
  override def update(controller: GameController): Unit = {
    if (cnt < 4){ // no esta pescando el tema de los turnos
      if (enemy.getStatus == "Quemado con Baston"){
        enemy.wasAttacked(30)
        cnt +=1
        controller.SetState(new TargetEnemyState(enemy,people))
      } else {
        enemy.wasAttacked(15)
        cnt +=1
        controller.SetState(new TargetEnemyState(enemy,people))
      }
    }
    else {
      enemy.setStatus("Sano")
      controller.SetState(new TargetEnemyState(enemy,people))
    }
  }


}
