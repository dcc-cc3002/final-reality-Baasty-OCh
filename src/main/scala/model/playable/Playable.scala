package model.playable

import model.controller.GameUnit
import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}
import model.nonplayable.{Enemy, NonPlayable}
import model.nonplayable.weapons.AWeapon

trait Playable extends GameUnit{
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
   * Abstract Method to know if Playable have a weapon or not
   */
  def hasWeapon: Option[AWeapon]

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: AWeapon): String

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


  /**
   * Abstract method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  def canEquipAxe(w:Axe): Boolean

  /**
   * Abstract method to check if a Playable entity can equip 'Sword'
   * @param w represent the Sword
   * @return true if the playable can equip the weapon, false in other case
   */
  def canEquipSword(w:Sword): Boolean

  /**
   * Abstract method to check if a Playable entity can equip 'Bow'
   * @param w represent the Bow
   * @return true if the playable can equip the weapon, false in other case
   */
  def canEquipBow(w:Bow): Boolean

  /**
   * Abstract method to check if a Playable entity can equip 'Staff'
   * @param w represent the Staff
   * @return true if the playable can equip the weapon, false in other case
   */
  def canEquipStaff(w:Staff): Boolean

  /**
   * Abstract method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  def canEquipWand(w:Wand): Boolean

}
