package controller.states.enemy
import controller.states.{AGameState, InitialPlayerState, TurnState, magicPlayer}
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.spell.Spell

class FinalEnemyState(var enemy: GameUnit, private val dest: GameUnit,var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = enemy
  var people : TurnSchedule = entities
  var choice: Int = 0
  override def update(controller: GameController, input:Int = choice): Unit = {
    pj.attack(dest)

    controller.SetState(new TurnState(people))
  }
}
