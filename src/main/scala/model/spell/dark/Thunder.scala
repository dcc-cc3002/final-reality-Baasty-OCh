package model.spell.dark

import model.playable.magic.AMagicPlayable

class Thunder extends ADarkSpell {
  var cost = 20
  def detEffect: Unit = {}

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectThunder()
}
