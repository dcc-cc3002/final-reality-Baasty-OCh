package controller.states

import controller.GameController
import controller.states.commonPlayer.ActionState
import controller.states.magicPlayer.ActionMagicState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class UnitState(val people : TurnSchedule, val pj: GameUnit) extends AGameState {
  private val selected: GameUnit = pj
  private var choice: Int = 2

  override def handleInput(controller: GameController): Unit = {
    choice = selected.IsMagic(selected)
  }

  override def update(controller: GameController): Unit = {
    if (selected.getHp != 0) {
      choice match{
        case 0 => controller.state = new ActionState(selected,people)
        case 1 => controller.state = new ActionMagicState(selected,people)
      }
    } else controller.state = new UnitState(people,pj)
  }

}
