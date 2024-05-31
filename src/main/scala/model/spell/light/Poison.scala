package model.spell.light

import model.playable.magic.AMagicPlayable

class Poison extends ALightSpell {
  val cost: Int = 30

  def detEffect: Unit = {}
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectPoison()

}
