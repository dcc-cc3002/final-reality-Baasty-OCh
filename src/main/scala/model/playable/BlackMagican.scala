package model.playable

import model.nonplayable.weapons.{AWeapon, Axe, Bow, Staff, Sword, Wand}

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
                mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,90,60,50,50)
  }

  /**
   * Implementation of method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquip(w: Axe): Boolean = false

  /**
   * Implementation of method to check if a Playable entity can equip 'Sword'
   * @param w represent the Sword
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquip(w: Sword): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Bow'
   * @param w represent the Bow
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquip(w: Bow): Boolean = false

  /**
   * Implementation of method to check if a Playable entity can equip 'Staff'
   * @param w represent the Staff
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquip(w: Staff): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquip(w: Wand): Boolean = true

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

