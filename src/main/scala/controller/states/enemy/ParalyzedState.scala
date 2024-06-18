package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class ParalyzedState(enemy: GameUnit, people: TurnSchedule) extends AGameState{
  override def notify(controller: GameController) = {
    controller.notifyEnemyStatus(enemy)
  }

  override def update(controller: GameController): Unit = {
    enemy.setStatus("Sano")
    controller.state = new TurnState(people)

  }



}
