package model.nonplayable

// Trait to represent non-playable entities
trait NonPlayable {
  // Abstract method to get the name of the non-playable entity
  def sayName(): String

  // Abstract method to get the weight of the non-playable entity
  def sayWeight(): Int

  // Abstract method to get the attack power of the non-playable entity
  def sayAttack(): Int
}

