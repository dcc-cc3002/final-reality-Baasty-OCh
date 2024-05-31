package model.spell.light

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

class Healing extends ALightSpell {
  val cost: Int  = 15
  override def actOnPlayable(): Boolean = true
  override def actOnEnemy(): Boolean = throw new InvalidspellTarget

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectHealing()

}
