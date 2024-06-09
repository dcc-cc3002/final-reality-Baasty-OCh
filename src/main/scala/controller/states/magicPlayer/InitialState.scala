package controller.states.magicPlayer
import controller.states.AGameState
import controller.GameController

class InitialState extends AGameState {
  override def update(controller: GameController) = {
    controller.state = new UnitState()
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart()
  }
}

