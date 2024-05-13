package model.playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.Enemy
import model.playable.APlayable
import model.nonplayable.weapons.{Bow,Staff,Sword,Axe,Wand}

/**
 * "A White Mage will predominantly have defensive qualities but with certain magical attributes."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class WhiteMagican(name:String, healthPoints:Int,
                 defensePoints:Int, weight:Int,
                 mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,100,80,60,40)
  }

  /**
   * Checks if this WhiteMagican is equal to another WhiteMagican.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[WhiteMagican]) {
      val otherCast = other.asInstanceOf[WhiteMagican]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }
}
