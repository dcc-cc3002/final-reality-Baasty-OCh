package model.weapons.magic

import model.weapons.AWeapon

protected abstract class AMagicWeapon(name: String, weight: Int,
                            attackPoints: Int, magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints) {

  private var MAP : Int = magicAttackPoints

  /**
   * Implementation for method to get the magic attack points of a magic weapon entity.
   * @return The magic attack points of the weapon (if it's a magic weapon)
   */
  def getMAP: Int = MAP

  override def iAmMagic: Boolean = true


}
