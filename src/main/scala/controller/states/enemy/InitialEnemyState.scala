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
    controller.state = new TargetEnemyState(pj, people)
  }


}

