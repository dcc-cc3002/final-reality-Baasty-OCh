package model.weapons.magic

trait MagicWeapon {

  /**
   * Abstract method, retrieves the magic attack points of the magic weapon.
   * @return The magic attack points of the weapon.
   */
  def getMAP: Int

  /**
   * Abstract method to indicates whether the weapon is magical or not.
   * @return true if the weapon is magical, false otherwise.
   */
  def iAmMagic: Boolean

}
