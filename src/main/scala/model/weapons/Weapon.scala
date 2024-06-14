package model.weapons

import model.playable.Playable


trait Weapon{
  /**
   * Abstract method to get the name of the Weapon entity
   *
   * @return The name of the Weapon entity as a String
   */
  def getName: String

  /**
   * Abstract method to get the weight of the Weapon entity
   *
   * @return The weight of the Weapon entity as an integer
   */
  def getWeight: Int


  /**
   * Abstract method to get the attack points of the Weapon entity
   *
   * @return The attack points of the Weapon entity as an integer
   */
  def getAttack: Int

  /**
   * Abstract Method to get the owner of the Weapon .
   * @param newOwner the new owner of the weapon
   */
  def setOwner(newOwner:Playable) : Unit

  def getOwner(): Option[Playable]

  /**
   * Abstract method to check if a Weapon entity (weapon) can be equipped by some particular playable entity
   * @param player The possible owner of the weapon
   * @return true if the weapon can be equipped by him , false in other case.
   */
  def canBeEquippedBy(player:Playable): Boolean

  /**
   * Abstract method to indicates whether the weapon is magical or not.
   * @return true if the weapon is magical, false otherwise.
   */
  def iAmMagic: Boolean

}
