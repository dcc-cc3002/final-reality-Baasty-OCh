package model.playable

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
                                   var mana: Int = 0) extends Playable {
  /**
   * variable to represent a weapon in an APlayable Entity
   */
  private var arma: Option[AWeapon] = None

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
   * Implementation of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int = mana

  /**
   * Implementation of Method to set the mana points of the playable entity
   * @param newMana represent the new mana points of the playable entity
   */
  def setMana(newMana:Int): Unit = {
    this.mana = newMana
  }

  /**
   * Implementation of Method to know if a Playable Entity has or not a weapon
   * @return The Weapon of the Character or None
   */
  def hasWeapon = arma

  /**
   * Implementation of Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }

  /**
   * Implementation of Method to attack an Enemy entity
   * @param target
   * @return damage
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
   *  @return A new `Playable` instance representing the entity after being hurt.
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

