package model.playable

import model.nonplayable.weapons.AWeapon

/**
 * "A Black Mage will primarily be a magical attack character, though without excessively neglecting defense."
 *
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
  override def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }



  /**
   * Checks if this BlackMagican is equal to another BlackMagican.
   *
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

