package model.playable

import exceptions.InvalidAttackAllyException
import model.general.GameUnit
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

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
   * Abstract Method to know if Playable have a weapon or not
   */
  def hasWeapon: Option[Weapon]

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: Weapon): String

  /**
   * Abstract method to alert if the player is attempting to use a weapon owned by another character."
   * @return an Exception
   */
  def foreignWeapon():Boolean

  /**
   * Abstract Method to remove a weapon in playable entity
   */
  def dropWeapon(): Unit

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

  /**
   * Implementation method to know if a Game Unit can attack a Playable entity
   * @param entity the candidate to be the target of attack
   * @return false , we can not attack another playable entities
   */
  def CanAttackPlayable(): Boolean = throw new InvalidAttackAllyException

  /**
   * Implementation method to know if a Game Unit can attack an Enemy entity
   * @param entity the candidate to be the target of attack
   * @return true, we have to attack enemy entities
   */
  def CanAttackEnemies(): Boolean = true


}
