package controller.states.player.magicPlayer

import controller.states.{AGameState, TurnState, enemy}
import model.general.GameUnit
import model.spell.Spell
import controller.GameController
import model.general.schedule.TurnSchedule
import model.weapons.Weapon

class FinalMagicState(var ally: GameUnit, private val target: GameUnit,
                      var spell: Option[Spell], var entities : TurnSchedule,
                      var weapon: Option[Weapon]) extends AGameState {
  var pj: GameUnit = ally
  var people : TurnSchedule = entities
  var choice: Int = 0

  override def update(controller: GameController, input:Int = choice): Unit = {
    if (spell.isDefined) {
      pj.throwSpell(target) // revisar
    } else {
      pj.attack(target)
    }
    controller.SetState(new TurnState(people))
  }

  override def isFinalMagicState(): Boolean = true
}
