package controller.states.magicPlayer
import controller.states.{AGameState, UnitState}
import controller.GameController

class InitialMagicState extends AGameState {
  override def update(controller: GameController) = {
    controller.state = new UnitState()
  }

  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerStart()
  }
}

