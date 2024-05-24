package model.playable

import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}
import model.nonplayable.weapons.AWeapon
import model.nonplayable.{Enemy, NonPlayable}
import model.playable.Playable

/**
 * An abstract class representing a Playable entity in the game.
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
   */
  protected var arma: Option[AWeapon] = None

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
   * @return The Weapon of the Character or None
   */
  def hasWeapon = arma

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: AWeapon): String

  /**
   * Method to 'reset' the state of arma parameter in a playable entity
   */

  def dropWeapon() : Unit ={
    if (this.hasWeapon != None){
    this.arma = None
    } else {}
  }

  /**
   * Implementation of Method to attack an Enemy entity
   * @param target represent an object of Enemy class and is our objective
   * @return damage represent the amount of damage inflicted on the target
   */
  def attackEnemy(target: Enemy): Int = {
    val damage = arma.map(_.getAttack - target.getDF).getOrElse(0)
    if (damage >= 0) {
      target.wasInjure(damage)
      damage
    }
    else damage
  }

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

