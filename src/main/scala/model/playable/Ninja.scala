package model.playable
import model.nonplayable.weapons.AWeapon
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
