package controller.states.enemy

import controller.states.{AGameState, GameState}

import scala.util.Random
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule


class ActionEnemyState(private val source: GameUnit,val people : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None

  override def handleInput(controller: GameController): Unit = {
    selected = Some(new TargetEnemyState(source,people))
  }

  override def update(controller: GameController): Unit = {
    controller.state = selected.get
  }
}
