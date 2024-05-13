package model.playable

import model.nonplayable.Enemy
import model.nonplayable.weapons.AWeapon

trait Playable {
  /**
   * Abstract method to get the name of the playable entity
  */
  def getName: String

  /**
   * Abstract method to get the Health points of the playable entity
   */

  def getHp: Int

  /**
   * Abstract method to set the Health points of the playable entity
   * @param x represent the new amount of health
   */
  def setHp(x:Int): Unit

  /**
   * Abstract method to get the Defense points of the playable entity
   */
  def getDp: Int

  /**
   * Abstract method to get the Weight of the playable entity
   */
  def getWeight: Int

  /**
   * Abstract Method to get the mana points of the playable entity
   */
  def getMana: Int

  /**
   * Abstract Method to set the mana points of the playable entity
   * @param x represent the amount of new mana
   */
  def setMana(x:Int): Unit

  /**
   * Abstract Method to know if Playable have a weapon or not
   */
  def hasWeapon: Option[AWeapon]

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: AWeapon): Unit

  /**
   * Abstract Method to attack an Enemy entity
   * @param target
   * @return damage
   */
  def attackEnemy(target: Enemy): Int

  /**
   * Abstract Method to hurt an Playable Entity
   * @param pain
   * @return a new Playable
   */
  def wasAttacked(pain:Int) : Unit
}
