package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

/**
 * Class representing a Wand, which is a type of non-playable weapon.
 *
 * @param name             The name of the wand
 * @param weight           The weight of the wand
 * @param attackPoints     The attack points of the wand
 * @param owner            The playable entity that owns this wand
 * @param magicAttackPoints The magic attack points of the wand
 */
class Wand(name: String, weight: Int, attackPoints: Int, owner: Playable, magicAttackPoints: Int)
  extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {

  /**
   * Constructs a Wand with specified parameters and a specified owner.
   *
   * @param owner The playable entity that will own this wand
   */
  def this(owner: Playable) = {
    this("Varita", 40, 50, owner, 30)
  }

  /**
   * Implementation of Method to get the magic attack points of the wand.
   * Since this is a magic wand, it returns magic attack points(MAP).
   *
   * @return The magic attack points of the wand
   */
  override def getMAP: Int = magicAttackPoints

}

