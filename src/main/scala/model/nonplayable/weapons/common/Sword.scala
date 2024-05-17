package model.nonplayable.weapons.common

import model.nonplayable.weapons.AWeapon
import model.playable.Playable

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
            attackPoints: Int) extends ACommonWeapon(name, weight, attackPoints) {

  /**
   * Constructs a Sword with specified parameters and a specified owner.
   * @param owner The playable entity that will own this sword
   */
  def this() = {
    this("Espada", 70, 70)
  }

  /**
   * Implementation of method, to know if a weapon can be equipped by some type of playable entity
   * @param player The potencial owner of the weapon
   *  @return true if the weapon can be equipped by him , false in other case.
   */
  override def canBeEquippedBy(player: Playable): Boolean = player.canEquipSword(this)


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
        getOwner == otherCast.getOwner )

    } else false
  }


}


