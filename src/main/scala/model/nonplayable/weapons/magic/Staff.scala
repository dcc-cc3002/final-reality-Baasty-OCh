package model.nonplayable.weapons.magic

import model.nonplayable.weapons.AWeapon
import model.playable.Playable

/**
 * Class representing a Staff, which is a type of non-playable weapon.
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

  override def canBeEquippedBy(player: Playable): Boolean = player.canEquipStaff(this)



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
