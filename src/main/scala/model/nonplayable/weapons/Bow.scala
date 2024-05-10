package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

/**
 * Class representing a Bow, which is a type of non-playable weapon.
 *
 * @param name             The name of the bow
 * @param weight           The weight of the bow
 * @param attackPoints     The attack points of the bow
 * @param owner            The playable entity that owns this bow
 * @param magicAttackPoints The magic attack points of the bow (if it's a magic weapon)
 */
class Bow(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int)
  extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {

  /**
   * Constructs a Bow with specified parameters and a specified owner.
   *
   * @param owner The playable entity that will own this bow
   */
  def this(owner: Playable) = {
    this("Arco", 30, 40, owner, 0)
  }

  /**
   * Constructs a Bow with default parameters and a default owner (Ninja).
   * This is a convenience constructor for testing purposes.
   */
  def this() = {
    this("Arco", 30, 40, new Ninja("Messi"), 0)
  }

  /**
   * Implementation of Method to get the magic attack points of the bow.
   * Since this is a non-magic bow, it always returns 0.
   *
   * @return The magic attack points of the bow (always 0 for this type of weapon)
   */
  override def getMAP: Int = 0
}
