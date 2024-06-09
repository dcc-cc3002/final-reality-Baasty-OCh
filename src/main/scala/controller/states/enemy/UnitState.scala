package controller.states.enemy

import controller.states.AGameState
import controller.GameController
import model.general.GameUnit

class UnitState extends AGameState {
  private var selected: Option[GameUnit] = None

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart()
  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIUnit())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new ActionState(selected.get)
  }
} 
