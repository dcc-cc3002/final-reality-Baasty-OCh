package model.playable
import exceptions.{InvalidputAxeException, InvalidputBowException, InvalidputStaffException}
import model.nonplayable.weapons.{AWeapon, Axe, Bow, Staff, Sword, Wand}
import model.playable.APlayable
/**
 *"A ninja is a key character in any game; they may not excel
 * in defensive arts but can be decisive due to their high attack speed."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
class Ninja(name:String, healthPoints: Int,
            defensePoints: Int, weight: Int,
            ) extends APlayable(name, healthPoints, defensePoints, weight,0){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   * @return Playable
   */
  def this(name:String) = {
    this(name,80,70,30)
  }


  /**
   * Implementation of Method to put a Weapon on a Playable Entity (Ninja)
   * @param weapon class of AWeapon (any sub-class of abstract class; Sword, Axe, Bow, Wand and Staff)
   * @return positive message if the Ninja Can equip the weapon,
   *         negative one in other cases, with his particular exception.
   */
  def putWeapon(weapon: AWeapon): String = {
    try {
      if (weapon.canBeEquippedBy(this)) {
        this.arma = Some(weapon)
        weapon.setOwner(this)
        "The weapon was wear"
      } else{ "Problem detected"}
    } catch {
      case _:InvalidputAxeException => s"The character: ${this.getName} (${this.getClass}) can't wear an ${weapon}"
      case _:InvalidputStaffException => s"The character: ${this.getName} (${this.getClass}) can't wear an ${weapon}"
    }
  }


  /**
   * Implementation of method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipAxe(w: Axe): Boolean = {
    throw new InvalidputAxeException

  }

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
  override def canEquipStaff(w: Staff): Boolean = false

  /**
   * Implementation of method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipWand(w: Wand): Boolean = true


  /**
   * Re-Implementation of a method to set the mana points, to non-magic character just do 'nothing'
   * @param newMana represent the new mana points of the playable entity
   */
  override def setMana(m:Int) : Unit = {}

  /**
   * Checks if this Ninja is equal to another Ninja.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, Name, Weight, Hp and Dp, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Ninja]) {
      val otherCast = other.asInstanceOf[Ninja]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }

}
