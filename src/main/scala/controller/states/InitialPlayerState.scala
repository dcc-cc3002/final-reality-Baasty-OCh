package controller.states

import controller.GameController
import controller.states.enemy.UnitEnemyState

class InitialPlayerState extends AGameState {
  override def update(controller: GameController) = {
    controller.state = new UnitState()
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart()
  }


}
