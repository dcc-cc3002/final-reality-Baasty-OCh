package model.nonplayable.weapons.magic

import model.nonplayable.weapons.AWeapon

private abstract class AMagicWeapon(name: String, weight: Int,
                            attackPoints: Int, magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints) {

  private var MAP : Int = magicAttackPoints

  /**
   * Implementation for method to get the magic attack points of a magic weapon entity.
   * @return The magic attack points of the weapon (if it's a magic weapon)
   */
  def getMAP: Int = MAP


}
