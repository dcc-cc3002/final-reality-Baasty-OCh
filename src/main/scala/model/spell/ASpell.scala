package model.spell

import model.playable.magic.AMagicPlayable

abstract class ASpell extends Spell {

  val cost: Int
  def getCost: Int = cost

}
