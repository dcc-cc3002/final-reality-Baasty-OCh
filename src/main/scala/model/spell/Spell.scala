package model.spell

import model.playable.magic.AMagicPlayable

trait Spell {

  def getCost: Int
  def detEffect: Unit
  def canBeSelectedBy(player:AMagicPlayable): Boolean

}
