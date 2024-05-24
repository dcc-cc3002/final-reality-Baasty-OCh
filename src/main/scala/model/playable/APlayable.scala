package model.playable

import exceptions.{InvalidattackAllieException, InvalidputAxeException, InvalidputWeaponException}
import model.controller.GameUnit
import model.nonplayable.{Enemy, NonPlayable}
import model.playable.Playable
import model.weapons.{AWeapon, Weapon}
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

/**
 * An abstract class representing a Playable entity in the game.
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana The mana of the character.
 */
protected abstract class APlayable(val name: String, var healthPoints: Int,
                                   val defensePoints: Int, val weight: Int,
                                   ) extends Playable {
  require(healthPoints >=0)
  require(defensePoints >=0)
  require(weight >=0)


  /**
   * variable to represent a weapon in an APlayable Entity
   * Base State: None (without weapon)
   */
  protected var arma: Option[Weapon] = None

  /**
   * Implementation of Method to get the name of the playable entity
   * @return : The name of playable entity
    */
  def getName: String = name

  /**
   * Implementation of Method to get the health points of the playable entity
    * @return The health points of playable entity
   */
  def getHp: Int = healthPoints

  /**
   * Implementation of Method to set the health points of the playable entity
   * @param newHp represent the new health points of the playable entity
   */
  def setHp(newHp: Int): Unit = {
    this.healthPoints = newHp
  }

  /**
   * Implementation of Method to get the defense points of the playable entity
   * @return The defense points of playable entity
   */
  def getDp: Int = defensePoints

  /**
   * Implementation of Method to get the weight of the playable entity
   * @return The weight of playable entity
   */
  def getWeight: Int = weight

  /**
   * Implementation of Method to know if a Playable Entity has or not a weapon
   * @return The Weapon of the Character or None in case he/she does not has
   */
  def hasWeapon = arma

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: Weapon): String

  /**
   * Implementation method to 'reset' the state of 'arma' parameter in a playable entity
   */
  def dropWeapon() : Unit ={
    if (this.hasWeapon != None){
    this.arma = None
    } else {}
  }

  /**
   * Implementation method to attack Game Unit entity
   * @param entity the target of attack
   * @return affirmative message in case the target was correct attack and "exception" message in other case
   */
  def attack(entity:GameUnit): String ={
    try{
    entity.wasAttackBy(this)
    val damage = arma.map(_.getAttack - entity.getDp).getOrElse(0)
    if (damage >= 0) {
      entity.wasAttacked(damage)
      damage
      "The enemy was Attack"
    } else
    "The enemy was Attack, but the damage is not enough"}
    catch {
      case _: InvalidattackAllieException => s"The character: ${this.getName} can't attack an Allie"
    }
  }

  /**
   * Implementation method to know if Playable can be attacked by other particular Game Unit
   * @param entity represents the possible attacker
   * @return true in case Game Unit was enemy of our playable entity
   */
  def wasAttackBy(entity:GameUnit): Boolean = entity.CanAttackPlayable(this)

  /**
   * Method to simulate the playable entity being attacked.
   * @param pain The amount of damage inflicted on the playable entity.
   *             delegar el if a set hp
   */
  def wasAttacked(pain: Int): Unit = {
    if (this.healthPoints >= pain){
      this.setHp(this.healthPoints-pain)
    }
    else {
      this.setHp(0)
    }
  }

}

