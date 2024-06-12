package controller.states

import controller.GameController

class SurrenderState extends AGameState {
  override def update(controller: GameController): Unit = {
    controller.lose(true)
  }

}
