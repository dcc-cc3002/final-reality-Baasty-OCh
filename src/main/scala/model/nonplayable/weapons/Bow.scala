package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

/**
 * Class representing a Bow, which is a type of non-playable weapon.
 * @param name             The name of the bow
 * @param weight           The weight of the bow
 * @param attackPoints     The attack points of the bow
 * @param owner            The playable entity that owns this bow
 * @param magicAttackPoints The magic attack points of the bow (if it's a magic weapon)
 */
class Bow(name: String, weight: Int,
          attackPoints: Int, magicAttackPoints: Int)
          extends AWeapon(name, weight, attackPoints,magicAttackPoints) {

  /**
   * Constructs a Bow with specified parameters and a specified owner.
   * @param owner The playable entity that will own this bow
   */
  def this() = {
    this("Arco", 30, 40, 0)
  }

  override def canBeEquippedBy(player: Playable): Boolean = player.canEquipBow(this)


  /**
   * Checks if this Bow is equal to another bow.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Bow]) {
      val otherCast = other.asInstanceOf[Bow]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getAttack == otherCast.getAttack &&
        getOwner == otherCast.getOwner &&
        getMAP == otherCast.getMAP)

    } else false
  }



}
