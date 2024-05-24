package model.nonplayable.weapons.common

import model.nonplayable.weapons.AWeapon
import model.playable.Playable

/**
 * Class representing an Axe, which is a type of common weapon.
 * @param name             The name of the axe
 * @param weight           The weight of the axe
 * @param attackPoints     The attack points of the axe
 * @param owner            The playable entity that owns this axe
 * @param magicAttackPoints The magic attack points of the axe (if it's a magic weapon)
 */
class Axe(name: String, weight: Int,
          attackPoints: Int) extends ACommonWeapon(name, weight, attackPoints) {

  /**
   * Constructs an Axe with default parameters and a specified owner.
   * @param owner The playable entity that will own this axe
   */
  def this() = {
    this("Hacha", 50, 50)
  }

  /**
   * Implementation of method, to know if a weapon can be equipped by some type of playable entity
   * @param player The potencial owner of the weapon
   *  @return true if the weapon can be equipped by him , false in other case.
   */
  override def canBeEquippedBy(player: Playable): Boolean =
    if(this.owner != None){
      player.foreignWeapon()
    } else{
      player.canEquipAxe(this)
    }



  /**
   * Checks if this Axe is equal to another axe.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Axe]) {
      val otherCast = other.asInstanceOf[Axe]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getAttack == otherCast.getAttack &&
        getOwner == otherCast.getOwner )

    } else false
  }

}
