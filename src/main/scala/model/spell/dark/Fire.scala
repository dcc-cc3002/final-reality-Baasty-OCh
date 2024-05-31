package model.spell.dark

import model.playable.magic.AMagicPlayable
import model.spell.ASpell
class Fire extends ASpell {
  val cost: Int = 15
  def detEffect: Unit = {}
  def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
