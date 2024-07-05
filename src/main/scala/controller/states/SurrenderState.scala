package controller.states

import controller.GameController
import exceptions.InvalidSurrenderException
import exceptions.weapons.InvalidPutWeaponException
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class SurrenderState(src: GameUnit, entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = src
  var people: TurnSchedule = entities
  var choice: Int = 0


  override def notify(controller: GameController): Unit = {
    controller.notifySurrenderMessage(pj)

  }
  override def update(controller: GameController): Unit = {
    controller.PutWhiteFlag()

  }


}
