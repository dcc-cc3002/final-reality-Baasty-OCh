package controller.states.enemy

import controller.states.{AGameState, GameState}
import scala.util.Random
import model.general.GameUnit
import controller.GameController


class ActionEnemyState(private val source: GameUnit) extends AGameState {
  private var selected: Option[GameState] = None

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIChoice(source))
  }

  override def update(controller: GameController): Unit = {
    controller.state = selected.get
  }
}
