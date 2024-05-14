package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

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
            attackPoints: Int, owner: Playable,
            magicAttackPoints: Int)
            extends AWeapon(name, weight, attackPoints,magicAttackPoints) {

  /**
   * Constructs a Staff with specified parameters and a specified owner.
   * @param owner The playable entity that will own this staff
   */
  def this(owner: Playable) = {
    this("Baston", 70, 70, owner, 40)
  }

  override def canBeEquippedBy(player: Playable): Boolean = p.canEquip(this)


  /**
   * Implementation of Method to get the magic attack points of the staff.
   * Since this is a magic staff, it returns magic attack points(MAP).
   * @return The magic attack points of the staff
   */
  override def getMAP: Int = magicAttackPoints

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
