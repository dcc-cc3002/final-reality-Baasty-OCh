package controller.states.enemy

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class UnitEnemyState(val people : TurnSchedule, val pj: GameUnit) extends AGameState {
  private var selected: GameUnit = pj

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart(selected)
  }

  override def handleInput(controller: GameController): Unit = {

  }

  override def update(controller: GameController): Unit = {
    controller.state = new ActionEnemyState(selected,people)
  }
} 
