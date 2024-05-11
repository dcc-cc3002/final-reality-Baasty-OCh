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
   * Implementation of Method to get the magic attack points of the axe.
   * Since this is a non-magic axe, it always returns 0.
   *
   * @return The magic attack points of the axe (always 0 for this type of weapon)
   */
  override def getMAP: Int = 0
}
