package model.nonplayable.weapons.common

import model.nonplayable.weapons.AWeapon

/**
 * Abstract class to made a group for common (non-magic) weapons
 * @param name             The name of the weapon
 * @param weight           The weight of the weapon
 * @param attackPoints     The attack points of the weapon
 */
protected abstract class ACommonWeapon(name: String, weight: Int,
                             attackPoints: Int) extends AWeapon(name, weight, attackPoints) {

}
