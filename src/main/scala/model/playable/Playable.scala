package model.playable

trait Playable {
  // Abstract method to get the name of the playable entity
  def sayName(): String

  // Abstract method to get the life points of the playable entity
  def sayLife(): Int

  // Abstract method to get the defense points of the playable entity
  def sayDefence(): Int

  // Abstract method to get the weight of the playable entity
  def sayWeight(): Int

  // Abstract method to get the kind/type of the playable entity
  def sayKind(): String

  // Abstract method to check if the playable entity has a weapon
  def havWeapon(): Boolean

}
