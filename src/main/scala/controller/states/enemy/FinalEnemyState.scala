package controller.states.enemy
import controller.states.{AGameState, InitialPlayerState, magicPlayer}
import controller.GameController
import model.general.GameUnit
import model.spell.Spell

class FinalEnemyState(private val src: GameUnit, private val dest: GameUnit) extends AGameState {

  override def update(controller: GameController): Unit = {
    src.attack(dest)

    controller.state = new InitialPlayerState()
  }
}
