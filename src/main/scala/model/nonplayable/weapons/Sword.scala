package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

/**
 * Class representing a Sword, which is a type of non-playable weapon.
 *
 * @param name             The name of the sword
 * @param weight           The weight of the sword
 * @param attackPoints     The attack points of the sword
 * @param owner            The playable entity that owns this sword
 * @param magicAttackPoints The magic attack points of the sword (if it's a magic weapon)
 */
class Sword(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int)
  extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {

  /**
   * Constructs a Sword with specified parameters and a specified owner.
   *
   * @param owner The playable entity that will own this sword
   */
  def this(owner: Playable) = {
    this("Espada", 70, 70, owner, 0)
  }


}


