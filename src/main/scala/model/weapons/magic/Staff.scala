package model.weapons.magic

import model.playable.Playable
import model.weapons.AWeapon

/**
 * Class representing a Staff, which is a type of weapon.
 *
 * @param name             The name of the staff
 * @param weight           The weight of the staff
 * @param attackPoints     The attack points of the staff
 * @param owner            The playable entity that owns this staff
 * @param magicAttackPoints The magic attack points of the staff
 */
class Staff(name: String, weight: Int,
            attackPoints: Int, magicAttackPoints: Int)
            extends AMagicWeapon(name, weight, attackPoints,magicAttackPoints) {

  /**
   * Constructs a Staff with specified parameters and a specified owner.
   * @param owner The playable entity that will own this staff
   */
  def this() = {
    this("Baston", 70, 70, 40)
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
      player.canEquipStaff(this)
    }



  /**
   * Checks if this Staff is equal to another staff.
   *
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Staff]) {
      val otherCast = other.asInstanceOf[Staff]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getAttack == otherCast.getAttack &&
        getOwner == otherCast.getOwner &&
        getMAP == otherCast.getMAP)

    } else false
  }

}
