package model.weapons

import controller.observers.ObserverAttack
import exceptions.weapons.InvalidKindOfWeapon
import model.playable.Playable

import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class representing a weapon that is non-playable.
 *
 * @param name             The name of the weapon
 * @param weight           The weight of the weapon
 * @param attackPoints     The attack points of the weapon
 * @param owner            The playable entity that owns this weapon
 * @param magicAttackPoints The magic attack points of the weapon (if it's a magic weapon)
 */
abstract class AWeapon(name: String, weight: Int,
                       attackPoints: Int) extends Weapon {

  protected var attackObs = ArrayBuffer.empty[ObserverAttack]

  /**
   * Validates that the weight of the weapon is within the valid range.
   * The weight must be between 0 and 100 inclusive.
   * @param weight The weight of the weapon.
   * @throws IllegalArgumentException if the weight is not within the valid range.
   */
  require(weight >= 0 && weight <= 100, "weight must be between 0 and 100 inclusive")

  /**
   * Validates that the attack points of the weapon are within the valid range.
   * The attack points must be between 0 and 100 inclusive.
   * @param attackPoints The attack points of the weapon.
   * @throws IllegalArgumentException if the attack points are not within the valid range.
   */
  require(attackPoints >= 0 && attackPoints <= 100, "attackPoints must be between 0 and 100 inclusive")

  /**
   * The owner of the weapon, which is an optional value of type Playable.
   * This variable is initialized to None, indicating that the weapon has no owner by default.
   */
  var owner: Option[Playable] = None

  /**
   * Implementation of Method to get the name of the non-playable entity.
   * @return The name of the weapon
   */
  def getName: String = name

  /**
   * Implementation of Method to get the weight of the non-playable entity.
   * @return The weight of the weapon
   */
  def getWeight: Int = weight

  /**
   * Implementation of Method to get the attack points of the non-playable entity.
   * @return The attack points of the weapon
   */
  def getAttack: Int = attackPoints

  /**
   * Implementation of Method to get the owner of the non-playable entity.
   * @return The owner (a playable entity) of the weapon
   */
  def getOwner: Option[Playable] = owner

  /**
   * Sets the owner of the non-playable entity (a weapon).
   *
   * @param newOwner The new owner of the weapon, which must be of type Playable.
   * @throws IllegalArgumentException if the newOwner is null.
   */
  def setOwner(newOwner: Playable): Unit = {
    require(newOwner != null, "newOwner cannot be null")
    this.owner = Some(newOwner)
  }
  def resetOwner(): Unit ={
    this.owner = None
  }

  /**
   * Indicates whether the weapon is magical.
 *
   * @return This method always throws an InvalidKindOfWeapon exception.
   * @throws InvalidKindOfWeapon This exception is always thrown as this weapon cannot be magical.
   */
  def iAmMagic: Boolean = throw new InvalidKindOfWeapon

  def getMAP: Int = 0

  /**
   * Registers an attack observer for the playable entity.
   * @param obs The observer to be registered. */
  def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }
}







