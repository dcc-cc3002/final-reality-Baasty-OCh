package controller.states.commonPlayer



import controller.states.{AGameState, TurnState, enemy}
import model.general.GameUnit
import model.spell.Spell
import controller.GameController
import model.general.schedule.TurnSchedule

class FinalState(var ally: GameUnit, private val target: GameUnit, var entities : TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0
  override def update(controller: GameController): Unit = {
    pj.attack(target)
    controller.SetState(new TurnState(people))
  }
}
