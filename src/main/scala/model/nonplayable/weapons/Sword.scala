package model.nonplayable.weapons
import model.nonplayable.NonPlayable
import model.nonplayable.weapons.AWeapon
import model.playable.{BlackMagican, Ninja, Paladin, Playable, Warrior, WhiteMagican}

/**
 * Class representing a Sword, which is a type of non-playable weapon.
 *
 * @param name             The name of the sword
 * @param weight           The weight of the sword
 * @param attackPoints     The attack points of the sword
 * @param owner            The playable entity that owns this sword
 * @param magicAttackPoints The magic attack points of the sword (if it's a magic weapon)
 */
class Sword(name: String, weight: Int,
            attackPoints: Int, magicAttackPoints: Int)
            extends AWeapon(name, weight, attackPoints, magicAttackPoints) {

  /**
   * Constructs a Sword with specified parameters and a specified owner.
   * @param owner The playable entity that will own this sword
   */
  def this() = {
    this("Espada", 70, 70, 0)
  }

  /**
   * Checks if this sword is equal to another sword.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Sword]) {
      val otherCast = other.asInstanceOf[Sword]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getAttack == otherCast.getAttack &&
        getOwner == otherCast.getOwner &&
        getMAP == otherCast.getMAP)

    } else false
  }


}


