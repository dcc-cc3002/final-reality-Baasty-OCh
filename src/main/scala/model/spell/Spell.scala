package model.spell

import model.general.GameUnit
import model.playable.magic.AMagicPlayable

trait Spell {

  def getCost: Int
  def Effect(target: GameUnit): Unit
  def canBeSelectedBy(player:AMagicPlayable): Boolean

  def actOnPlayable(): Boolean
  def actOnEnemy(): Boolean
  def setMagican(mago : AMagicPlayable)

}
