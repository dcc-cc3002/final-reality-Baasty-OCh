package model.spell.dark

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.spell.ASpell
class Fire extends ASpell {
  val cost: Int = 15
  def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
