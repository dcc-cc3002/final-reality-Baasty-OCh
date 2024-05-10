package model.nonplayable.weapons

import model.nonplayable.NonPlayable
import model.playable.Playable

/**
 * Abstract class representing a weapon that is non-playable.
 *
 * @param name             The name of the weapon
 * @param weight           The weight of the weapon
 * @param attackPoints     The attack points of the weapon
 * @param owner            The playable entity that owns this weapon
 * @param magicAttackPoints The magic attack points of the weapon (if it's a magic weapon)
 */
abstract class AWeapon(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int) extends NonPlayable {
  /**
   * Implementation of Method to get the name of the non-playable entity.
   *
   * @return The name of the weapon
   */
  def getName: String = name

  /**
   * Implementation of Method to get the weight of the non-playable entity.
   *
   * @return The weight of the weapon
   */
  def getWeight: Int = weight

  /**
   * Implementation of Method to get the attack points of the non-playable entity.
   *
   * @return The attack points of the weapon
   */
  def getAttack: Int = attackPoints

  /**
   * Implementation of Method to get the owner of the non-playable entity.
   *
   * @return The owner (a playable entity) of the weapon
   */
  def getOwner: Playable = owner

  /**
   * Implementation of Method to get the defense points of the non-playable entity.
   *
   * @return The defense points of the weapon (always returns 0 for a weapon)
   */
  override def getDF: Int = 0

  /**
   * Implementation of Method to get the life points of the non-playable entity.
   *
   * @return The life points of the weapon (always returns 0 for a weapon)
   */
  def getLife: Int = 0

  /**
   * Implementation for method to get the magic attack points of a magic weapon entity.
   *
   * @return The magic attack points of the weapon (if it's a magic weapon)
   */
  def getMAP: Int = magicAttackPoints

  /**
   * Checks if this weapon is equal to another object.
   *
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[NonPlayable]) {
      val otherCast = other.asInstanceOf[NonPlayable]
      getClass() == otherCast.getClass()
    } else false
  }
}







