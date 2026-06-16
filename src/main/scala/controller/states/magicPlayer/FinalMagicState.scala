package controller.states.magicPlayer

import controller.states.{AGameState, TurnState, enemy}
import model.general.GameUnit
import model.spell.Spell
import controller.GameController
import model.general.schedule.TurnSchedule
import model.weapons.Weapon

class FinalMagicState(private val source: GameUnit, private val target: GameUnit,
                      private val spell: Option[Spell], val people : TurnSchedule, var weapon: Option[Weapon]) extends AGameState {


  override def update(controller: GameController): Unit = {
    if (spell.isDefined) {
      source.throwSpell(target)
    } else {
      source.attack(target)
    }
    controller.state = new TurnState(people)
  }
}
