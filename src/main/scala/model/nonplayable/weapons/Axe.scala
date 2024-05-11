package model.nonplayable.weapons

import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

/**
 * Class representing an Axe, which is a type of non-playable weapon.
 *
 * @param name             The name of the axe
 * @param weight           The weight of the axe
 * @param attackPoints     The attack points of the axe
 * @param owner            The playable entity that owns this axe
 * @param magicAttackPoints The magic attack points of the axe (if it's a magic weapon)
 */
class Axe(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int)
  extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {

  /**
   * Constructs an Axe with default parameters and a specified owner.
   *
   * @param owner The playable entity that will own this axe
   */
  def this(owner: Playable) = {
    this("Hacha", 50, 50, owner, 0)
  }
  /**
   * Checks if this Axe is equal to another axe.
   *
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Axe]) {
      val otherCast = other.asInstanceOf[Axe]
      getClass() == otherCast.getClass()
    } else false
  }


}
