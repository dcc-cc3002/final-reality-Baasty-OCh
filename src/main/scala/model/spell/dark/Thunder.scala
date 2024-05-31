package model.spell.dark

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

class Thunder extends ADarkSpell {
  val cost: Int = 20

  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectThunder()
}
