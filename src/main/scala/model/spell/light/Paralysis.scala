package model.spell.light

import model.playable.magic.AMagicPlayable

class Paralysis extends ALightSpell {
  val cost: Int = 25
  def detEffect: Unit = {}
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectParalysis()
}
