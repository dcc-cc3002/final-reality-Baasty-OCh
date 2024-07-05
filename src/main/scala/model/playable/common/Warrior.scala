package model.playable.common

import exceptions.weapons.{InvalidPutStaffException, InvalidPutWandException, InvalidPutWeaponException}
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

/**
 * "The warrior is a character designed
 * to be the main powerhouse of a team,
 * very resilient but somewhat slow;
 * this is often referred to as the game's 'tank'."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
class Warrior(name:String, healthPoints: Int,
              defensePoints: Int, weight: Int) extends ACommonPlayable(name, healthPoints, defensePoints, weight){
  private val InitialHp: Int = 200
  override def maxHp(): Int = InitialHp


  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,200,100,70)
  }

  /**
   * Implementation of Method to put a Weapon on a Playable Entity (Warrior)
   * @param weapon class of AWeapon (any sub-class of abstract class; Sword, Axe, Bow, Wand and Staff)
   * @return positive message if the Warrior Can equip the weapon,
   *         negative one in other cases, with his particular exception.
   */
  def putWeapon(weapon: Weapon): String = {
    try {
      this.dropWeapon()
      weapon.canBeEquippedBy(this)
      this.arma = Some(weapon)
      this.setWeight(this.getWeight + weapon.getWeight)
      weapon.setOwner(this)
      "The weapon was wear"
    } catch {
      case _:InvalidPutStaffException => s"The character: ${this.getName} can't wear a Staff"
      case _:InvalidPutWandException => s"The character: ${this.getName} can't wear a Wand"
      case _:InvalidPutWeaponException => s"The weapon: ${weapon.getName} already has owner"
    }
  }

  /**
   * Implementation of method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipAxe(w: Axe): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Sword'
   * @param w represent the Sword
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipSword(w: Sword): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Bow'
   * @param w represent the Bow
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipBow(w: Bow): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Staff'
   * @param w represent the Staff
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipStaff(w: Staff): Boolean = throw new InvalidPutStaffException

  /**
   * Implementation of method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipWand(w: Wand): Boolean = throw new InvalidPutWandException

  /**
   * Checks if this Warrior is equal to another Warrior .
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, Name, Weight, Hp and Dp, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Warrior]) {
      val otherCast = other.asInstanceOf[Warrior]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp )

    } else false
  }

}
