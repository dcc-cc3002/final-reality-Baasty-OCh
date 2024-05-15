package model.playable

import model.nonplayable.weapons.{AWeapon, Axe, Bow, Staff, Sword, Wand}
/**
 * "A paladin is thought of as a very balanced character,
 * not excelling excessively in any attribute but also
 * not possessing notable deficiencies compared to other characters."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
class Paladin(name:String, healthPoints:Int,
                      defensePoints:Int, weight:Int,
                      ) extends APlayable(name, healthPoints, defensePoints,weight,0) {

  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   * @return Playable
   */
  def this(name: String) = {
    this(name, 100, 75, 50) // stats by default: HP:100 , DP:75 , Weight:50
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
  override def canEquipBow(w: Bow): Boolean = false

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
  override def canEquipWand(w: Wand): Boolean = false


  /**
   * Re-Implementation of a method to set the mana points, to non-magic character just do 'nothing'
   * @param newMana represent the new mana points of the playable entity
   */
  override def setMana(newMana: Int): Unit = {}

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








