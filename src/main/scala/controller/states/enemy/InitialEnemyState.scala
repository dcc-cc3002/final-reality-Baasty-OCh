package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, UnitState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class InitialEnemyState(val entities: TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart(pj)
  }

  override def update(controller: GameController) = {
    if (pj.getStatus == "Paralizado"){
      controller.SetState(new ParalyzedState(pj,people))
    }
    else if (pj.getStatus == "Envenenado con Baston" || pj.getStatus == "Envenenado con Varita" ){
      controller.SetState(new PoisonedState(pj,people))
    }
    else if(pj.getStatus == "Quemado con Baston" || pj.getStatus == "Quemado con Varita"){
      controller.SetState(new BurnedState(pj,people))
    }
    else
    controller.SetState(new TargetEnemyState(pj, people))
  }

  override def isInitialEnemyState(): Boolean = true

}

