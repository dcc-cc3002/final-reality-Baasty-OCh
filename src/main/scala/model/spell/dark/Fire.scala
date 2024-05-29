package model.spell.dark

import model.playable.magic.AMagicPlayable

class Fire extends ADarkSpell {
  var cost = 15

  def detEffect: Unit = {}
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
