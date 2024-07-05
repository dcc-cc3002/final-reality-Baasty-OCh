package controller.states

import controller.GameController
import controller.states.commonPlayer.ActionState
import controller.states.magicPlayer.ActionMagicState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class UnitState(val entities : TurnSchedule, val src: GameUnit) extends AGameState {
  var pj: GameUnit = src
  var people : TurnSchedule = entities
  var choice: Int = 0

  override def handleInput(controller: GameController): Unit = {
    choice = pj.IsMagic(pj)
  }

  override def update(controller: GameController): Unit = {
      choice match{
        case 0 => controller.SetState(new ActionState(pj,people))
        case 1 => controller.SetState(new ActionMagicState(pj,people))
      }
  }


}
