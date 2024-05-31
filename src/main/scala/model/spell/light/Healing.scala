package model.spell.light

import model.playable.magic.AMagicPlayable

class Healing extends ALightSpell {
  val cost: Int  = 15
  def detEffect: Unit = {}

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectHealing()

}
