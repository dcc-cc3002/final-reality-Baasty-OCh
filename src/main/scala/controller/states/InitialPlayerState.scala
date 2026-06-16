package controller.states

import controller.GameController
import controller.states.enemy.UnitEnemyState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class InitialPlayerState(val people : TurnSchedule, val pj: GameUnit) extends AGameState {
  override def update(controller: GameController) = {
    controller.state = new UnitState(people,pj)
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart(pj)
  }


}
