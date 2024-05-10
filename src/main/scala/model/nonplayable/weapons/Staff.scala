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
class Staff(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int)
  extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {

  /**
   * Constructs a Staff with specified parameters and a specified owner.
   *
   * @param owner The playable entity that will own this staff
   */
  def this(owner: Playable) = {
    this("Baston", 70, 70, owner, 40)
  }

  /**
   * Constructs a Staff with default parameters and a default owner (BlackMagican).
   * This is a convenience constructor for testing purposes.
   */
  def this() = {
    this("Baston", 70, 70, new BlackMagican("Vidal"), 40)
  }
}
