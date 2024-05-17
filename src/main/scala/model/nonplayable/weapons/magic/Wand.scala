package model.nonplayable.weapons.magic

import model.nonplayable.weapons.AWeapon
import model.playable.Playable

/**
 * Class representing a Wand, which is a type of  weapon.
 * @param name             The name of the wand
 * @param weight           The weight of the wand
 * @param attackPoints     The attack points of the wand
 * @param owner            The playable entity that owns this wand
 * @param magicAttackPoints The magic attack points of the wand
 */
class Wand(name: String, weight: Int,
           attackPoints: Int, magicAttackPoints: Int)
           extends AMagicWeapon(name, weight, attackPoints, magicAttackPoints) {

  /**
   * Constructs a Wand with specified parameters and a specified owner.
   * @param owner The playable entity that will own this wand
   */
  def this() = {
    this("Varita", 40, 50, 30)
  }

  /**
   * Implementation of method, to know if a weapon can be equipped by some type of playable entity
   * @param player The potencial owner of the weapon
   *  @return true if the weapon can be equipped by him , false in other case.
   */
  override def canBeEquippedBy(player: Playable): Boolean = player.canEquipWand(this)


  /**
   * Checks if this Wand is equal to another wand.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Wand]) {
      val otherCast = other.asInstanceOf[Wand]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getAttack == otherCast.getAttack &&
        getOwner == otherCast.getOwner &&
        getMAP == otherCast.getMAP)

    } else false
  }

}

