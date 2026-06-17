package model.playable

import exceptions.InvalidAttackAllyException
import model.general.GameUnit
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

/**
 * Trait representing a playable entity in the game.
 * This trait defines methods and properties common to all playable entities.
 */
trait Playable extends GameUnit {

  /**
   * Abstract method to check if the playable entity has a weapon.
   * @return An Option containing the equipped weapon, or None if no weapon is equipped.
   */
  def hasWeapon: Option[Weapon]

  /**
   * Abstract method to equip a weapon on the playable entity.
   * @param weapon The weapon to equip.
   * @return A message indicating the success or failure of equipping the weapon.
   */
  def putWeapon(weapon: Weapon): String

  /**
   * Abstract method to check if the playable entity is attempting to use a weapon owned by another character.
   * @return Always returns false for playable entities.
   */
  def foreignWeapon(): Boolean

  /**
   * Abstract method to drop the equipped weapon from the playable entity.
   */
  def dropWeapon(): Unit

  /**
   * Abstract method to check if the playable entity can equip an Axe.
   * @param w The Axe to be equipped.
   * @return true if the playable entity can equip the Axe, false otherwise.
   */
  def canEquipAxe(w: Axe): Boolean

  /**
   * Abstract method to check if the playable entity can equip a Sword.
   * @param w The Sword to be equipped.
   * @return true if the playable entity can equip the Sword, false otherwise.
   */
  def canEquipSword(w: Sword): Boolean

  /**
   * Abstract method to check if the playable entity can equip a Bow.
   * @param w The Bow to be equipped.
   * @return true if the playable entity can equip the Bow, false otherwise.
   */
  def canEquipBow(w: Bow): Boolean

  /**
   * Abstract method to check if the playable entity can equip a Staff.
   * @param w The Staff to be equipped.
   * @return true if the playable entity can equip the Staff, false otherwise.
   */
  def canEquipStaff(w: Staff): Boolean

  /**
   * Abstract method to check if the playable entity can equip a Wand.
   * @param w The Wand to be equipped.
   * @return true if the playable entity can equip the Wand, false otherwise.
   */
  def canEquipWand(w: Wand): Boolean

  /**
   * Method to determine if the playable entity can attack another playable entity.
   * @return Always throws an InvalidAttackAllyException, indicating that playable entities cannot attack each other.
   */
  def CanAttackPlayable(): Boolean = throw new InvalidAttackAllyException

  /**
   * Method to determine if the playable entity can attack an enemy entity.
   * @return Always returns true, indicating that playable entities can attack enemy entities.
   */
  def CanAttackEnemies(): Boolean = true

  /**
   * Abstract method to retrieve the Bow weapon.
   * @return The Bow weapon.
   */
  def Bow: Weapon

  /**
   * Abstract method to retrieve the Sword weapon.
   * @return The Sword weapon.
   */
  def Sword: Weapon

  /**
   * Abstract method to retrieve the Axe weapon.
   * @return The Axe weapon.
   */
  def Axe: Weapon

  /**
   * Abstract method to retrieve the Staff weapon.
   * @return The Staff weapon.
   */
  def Staff: Weapon

  /**
   * Abstract method to retrieve the Wand weapon.
   * @return The Wand weapon.
   */
  def Wand: Weapon
}
