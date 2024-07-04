package controller.states.enemy
import controller.states.{AGameState, InitialPlayerState, TurnState, magicPlayer}
import controller.GameController
import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.spell.Spell

class FinalEnemyState(private val src: GameUnit, private val dest: GameUnit,val people : TurnSchedule) extends AGameState {

  override def update(controller: GameController): Unit = {
    src.attack(dest)

    controller.SetState(new TurnState(people))
  }
}
