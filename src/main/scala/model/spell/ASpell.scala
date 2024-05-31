package model.spell

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

abstract class ASpell extends Spell {

  val cost: Int
  var magican: Option[AMagicPlayable] = None

  def actOnEnemy(): Boolean = true
  def actOnPlayable() : Boolean = throw new InvalidspellTarget
  def Effect(gameUnit: GameUnit): Unit = {}
  def getCost: Int = cost
  def setMagican(mago : AMagicPlayable): Unit = {
    this.magican = Some(mago)
  }

}
