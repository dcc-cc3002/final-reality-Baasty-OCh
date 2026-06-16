package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class PoisonedState (enemy: GameUnit, people: TurnSchedule) extends AGameState{
  private var cnt: Int = 0
  override def notify(controller: GameController) = {
    controller.notifyEnemyStatus(enemy)
  }

  override def update(controller: GameController): Unit = {
    if (cnt < 4){ // no esta pescando el tema de los turnos
      if (enemy.getStatus == "Envenenado con Baston"){
        enemy.wasAttacked(20)
        cnt +=1
        controller.state = new TargetEnemyState(enemy,people)
      } else {
        enemy.wasAttacked(10)
        cnt +=1
        controller.state = new TargetEnemyState(enemy,people)
      }
    }
    else {
      enemy.setStatus("Sano")
      controller.state = new TargetEnemyState(enemy,people)
    }
  }

}
