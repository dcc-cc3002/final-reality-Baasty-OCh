package model.weapons.magic

import model.weapons.Weapon

trait MagicWeapon extends Weapon {

  /**
   * Abstract method, retrieves the magic attack points of the magic weapon.
   * @return The magic attack points of the weapon.
   */


  /**
   * Abstract method to indicates whether the weapon is magical or not.
   * @return true if the weapon is magical, false otherwise.
   */
  def iAmMagic: Boolean

}
