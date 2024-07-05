package controller.states.player

import controller.GameController
import controller.states.AGameState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class SurrenderState(src: GameUnit, entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0

  override def isSurrenderState(): Boolean = true

  override def notify(controller: GameController): Unit = {
    controller.notifySurrenderMessage(pj)

  }
  override def update(controller: GameController, input:Int = choice): Unit = {
    controller.PutWhiteFlag()

  }


}
