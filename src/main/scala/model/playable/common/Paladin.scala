package model.playable.common

import exceptions.weapons.{InvalidPutBowException, InvalidPutStaffException, InvalidPutWandException, InvalidPutWeaponException}
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

/**
 * "A paladin is thought of as a very balanced character,
 * not excelling excessively in any attribute but also
 * not possessing notable deficiencies compared to other characters."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
class Paladin(name:String, healthPoints: Int,
              defensePoints: Int, weight: Int) extends ACommonPlayable(name, healthPoints, defensePoints, weight) {
  private val InitialHp: Int = 150
  override def maxHp(): Int = InitialHp



  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   * @return Playable
   */
  def this(name: String) = {
    this(name, 150, 75, 50) // stats by default: HP:100 , DP:75 , Weight:50
  }

  /**
   * Implementation of Method to put a Weapon on a Playable Entity (Paladin)
   * @param weapon class of AWeapon (any sub-class of abstract class; Sword, Axe, Bow, Wand and Staff)
   * @return positive message if the Paladin Can equip the weapon,
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
      case _:InvalidPutBowException => s"The character: ${this.getName} can't wear a Bow"
      case _:InvalidPutStaffException => s"The character: ${this.getName} can't wear a Staff"
      case _:InvalidPutWandException => s"The character: ${this.getName} can't wear a Wand"
      case _:InvalidPutWeaponException => s"The weapon: ${weapon.getName} already has an owner"
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
  override def canEquipBow(w: Bow): Boolean = throw new InvalidPutBowException

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
   * Checks if this Paladin is equal to another Paladin.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, Name, Weight, Hp and Dp, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Paladin]) {
      val otherCast = other.asInstanceOf[Paladin]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp )

    } else false
  }

}








