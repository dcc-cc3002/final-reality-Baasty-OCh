package controller.states

import controller.GameController
import controller.states.enemy.InitialEnemyState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class TurnState(var entities:TurnSchedule) extends AGameState {
  var people: TurnSchedule = entities
  var pj : GameUnit = calcTurns(people)
  var choice: Int = 0


  override def isTurnState(): Boolean = true
  private def calcTurns(t:TurnSchedule): GameUnit ={
    while(t.turns.isEmpty){
      t.fillActionBar(5)
    }
    val src: GameUnit = t.turns.head
    t.CanPlay(t.turns)
  }

  override def notify(controller: GameController) = {
    if (pj.Style(pj) == "playable"){
      controller.notifyReportMessage()
    } else controller.notifyMagicReportMessage()
  }

  override def handleInput(controller: GameController): Unit = {
    choice  = controller.TurnoDe(pj)
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    input match{
      case 1 => controller.SetState(new InitialEnemyState(people,pj))
      case 2 => controller.SetState(new InitialPlayerState(people,pj))
    }
  }

}
