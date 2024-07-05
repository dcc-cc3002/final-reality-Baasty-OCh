package controller.states.player

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class InitialPlayerState(val entities : TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0
  override def isInitialPlayerState(): Boolean = true

  override def update(controller: GameController, input: Int = choice) = {
    controller.SetState(new UnitState(people,pj))
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart(pj)
  }





}
