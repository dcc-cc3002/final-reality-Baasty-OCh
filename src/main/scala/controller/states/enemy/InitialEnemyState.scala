package controller.states.enemy

import controller.GameController
import controller.states.{AGameState, UnitState}

class InitialEnemyState extends AGameState {
  override def update(controller: GameController) = {
    controller.state = new UnitEnemyState()
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart()
  }
}

