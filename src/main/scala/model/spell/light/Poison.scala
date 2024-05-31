package model.spell.light

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

class Poison extends ALightSpell {
  val cost: Int = 30

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectPoison()

}
