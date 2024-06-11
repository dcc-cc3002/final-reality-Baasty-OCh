package controller.states

import controller.GameController
import controller.states.enemy.InitialEnemyState
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class TurnState(val people:TurnSchedule) extends AGameState {

  var choice: Int = 0

  def calcTurns(t:TurnSchedule): GameUnit ={
    while(t.turns.isEmpty){
      t.fillActionBar(30)
    }
    val src: GameUnit = t.turns.head
    t.turns.enqueue(src)
    src
  }

  override def notify(controller: GameController) = {
   // controller.notifyInitMessage()
  }

  override def handleInput(controller: GameController): Unit = {
    val pj: GameUnit = calcTurns(people)
    choice  = controller.TurnoDe(pj)

  }

  override def update(controller: GameController): Unit = {
    choice match{
      case 1 => controller.state = new InitialEnemyState()
      case 2 => controller.state = new InitialPlayerState()
    }
  }

}
