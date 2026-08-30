package model.playable

import model.nonplayable.weapons.AWeapon
import model.playable.APlayable

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
class Warrior(name:String, healthPoints:Int,
               defensePoints:Int, weight:Int,
               ) extends APlayable(name,healthPoints, defensePoints,weight,0){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,120,100,70)
  }

  /**
   * Re-Implementation of a method to set the mana points, to non-magic character just do 'nothing'
   * @param newMana represent the new mana points of the playable entity
   */
  override def setMana(newMana:Int) : Unit = {}

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
