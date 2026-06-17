package model.weapons

import exceptions.InvalidputAxeException
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
abstract class AWeapon(name: String, weight: Int,
                       attackPoints: Int) extends Weapon {

  require(weight >=0 && weight<=100)
  require(attackPoints >=0 && attackPoints<=100)

  var owner : Option[Playable] = None
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
   * Implementation of Method to get the owner of the non-playable entity (a weapon).
   * @param newOwner the new owner of the weapon
   */
  def setOwner(newOwner:Playable) : Unit = {
    this.owner = Some(newOwner)
  }





}







