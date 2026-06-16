package model.weapons.magic

import model.weapons.AWeapon

/**
 * Abstract class representing a magical weapon in the game.
 * @param name The name of the magical weapon.
 * @param weight The weight of the magical weapon.
 * @param attackPoints The regular attack points of the magical weapon.
 * @param magicAttackPoints The magic attack points of the magical weapon.
 */
protected abstract class AMagicWeapon(name: String, weight: Int,
                                      attackPoints: Int, magicAttackPoints: Int)
                                      extends AWeapon(name, weight, attackPoints) with MagicWeapon {

  private var MAP: Int = magicAttackPoints

  /**
   * Retrieves the magic attack points of the magical weapon.
   * @return The magic attack points of the weapon.
   */
  override def getMAP: Int = MAP

  /**
   * Indicates whether the weapon is magical or not.
   * @return true if the weapon is magical, false otherwise.
   */
  override def iAmMagic: Boolean = true
}

