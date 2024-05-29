package model.spell

abstract class ASpell extends Spell {
  var cost: Int

  def getCost: Int = cost
  def detEffect: Unit


}
