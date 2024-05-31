package model.spell.light

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

class Paralysis extends ALightSpell {
  val cost: Int = 25

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectParalysis()
}
