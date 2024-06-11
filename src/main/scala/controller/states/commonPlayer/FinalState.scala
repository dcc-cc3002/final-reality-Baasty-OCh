package controller.states.commonPlayer



import controller.states.{AGameState, TurnState, enemy}
import model.general.GameUnit
import model.spell.Spell
import controller.GameController

class FinalState(private val source: GameUnit, private val target: GameUnit) extends AGameState {

  override def update(controller: GameController): Unit = {
    source.attack(target)
    controller.state = new TurnState()
  }
}
