package model.playable.magic

import exceptions.{InvalidputAxeException, InvalidputBowException}
import model.nonplayable.weapons._
import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}

/**
 * "A Black Mage will primarily be a magical attack character,
 * though without excessively neglecting defense."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class BlackMagican(name:String, healthPoints:Int,
                defensePoints:Int, weight:Int,
                mana:Int) extends AMagicPlayable(name,healthPoints, defensePoints,weight,mana) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,90,60,50,50)
  }


  /**
   * Implementation of Method to put a Weapon on a Playable Entity (BlackMagican)
   * @param weapon class of AWeapon (any sub-class of abstract class; Sword, Axe, Bow, Wand and Staff)
   * @return positive message if the BlackMAgican Can equip the weapon,
   *         negative one in other cases, with his particular exception.
   */
  def putWeapon(weapon: AWeapon): String = {
    try {
      weapon.canBeEquippedBy(this)
      this.arma = Some(weapon)
      weapon.setOwner(this)
      "The weapon was wear"
    } catch {
      case _:InvalidputAxeException => s"The character: ${this.getName} can't wear an Axe"
      case _:InvalidputBowException => s"The character: ${this.getName} can't wear a Bow"
    }
  }


  /**
   * Implementation of method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipAxe(w: Axe): Boolean = throw new InvalidputAxeException

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
  override def canEquipBow(w: Bow): Boolean = throw new InvalidputBowException

  /**
   * Implementation of method to check if a Playable entity can equip 'Staff'
   * @param w represent the Staff
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipStaff(w: Staff): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipWand(w: Wand): Boolean = true

  /**
   * Checks if this BlackMagican is equal to another BlackMagican.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[BlackMagican]) {
      val otherCast = other.asInstanceOf[BlackMagican]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }
}

