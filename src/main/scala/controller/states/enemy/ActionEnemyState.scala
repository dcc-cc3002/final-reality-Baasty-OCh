package controller.states.enemy

import controller.states.{AGameState, GameState}

import scala.util.Random
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule


class ActionEnemyState(var enemy: GameUnit, var entities : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0

  override def handleInput(controller: GameController): Unit = {
    selected = Some(new TargetEnemyState(pj,people))
  }

  override def update(controller: GameController): Unit = {
    controller.SetState(selected.get)
  }
}
