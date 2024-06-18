package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, UnitState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class InitialEnemyState(val people: TurnSchedule, val pj: GameUnit) extends AGameState {

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart(pj)
  }

  override def update(controller: GameController) = {
    if (pj.getStatus == "Paralizado"){
      controller.state = new ParalyzedState(pj,people)
    } else if (pj.getStatus == "Envenenado con Baston" || pj.getStatus == "Envenenado con Varita" ){
      controller.state = new PoisonedState(pj,people)
    } else if(pj.getStatus == "Quemado con Baston" || pj.getStatus == "Quemado con Varita"){
      controller.state = new BurnedState(pj,people)
    }
    else
    controller.state = new TargetEnemyState(pj, people)
  }


}

