package controller.states

import model.view.GameView
import controller.GameController
import scala.collection.mutable.ArrayBuffer

abstract class AGameState extends GameState {
  override def handleInput(controller: GameController): Unit = {}
  override def update(controller: GameController): Unit = {}
  override def notify(controller: GameController): Unit = {}
}
