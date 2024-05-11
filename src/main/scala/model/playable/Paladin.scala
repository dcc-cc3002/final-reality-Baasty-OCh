package model.playable

import model.nonplayable.weapons.AWeapon
/**
 * "A paladin is thought of as a very balanced character,
 * not excelling excessively in any attribute but also
 * not possessing notable deficiencies compared to other characters."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana is zero for no magic characters
 */
class Paladin(name:String, healthPoints:Int,
              defensePoints:Int, weight:Int,
              mana:Int) extends APlayable(name, healthPoints, defensePoints,weight,mana) {

  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   *
   * @param name
   * @return Playable
   */
  def this(name: String) = {
    this(name, 100, 75, 50, 0) // stats by default: HP:100 , DP:75 , Weight:50 and Mana:0 (is not a magic Character)
  }

  /**
   * Equip a weapon on the playable entity.
   * This method sets the specified weapon as the equipped weapon for the playable entity.
   *
   * @param weapon The weapon to be equipped.
   */
  override def putWeapon(weapon: AWeapon): Unit = {
    // Set the `arma` variable to `Some(weapon)`, indicating that the playable entity is now equipped with this weapon.
    arma = Some(weapon)
  }

  /**
   * Implementation of abstract method from 'APlayable' class.
   * Simulate the playable entity being attacked.
   * This method simulates the playable entity receiving damage from an attack.
   * @param pain The amount of damage inflicted on the playable entity.
   * @return A new `Playable` instance representing the playable entity after being attacked.
   */
  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain) {
      // If the current health points are greater than or equal to the inflicted damage (`pain`), create a new `Playable` instance with reduced health.
      new Paladin(this.name, this.healthPoints - pain, this.defensePoints, this.weight, this.mana)
    } else {
      // If the inflicted damage (`pain`) exceeds the current health points, create a new `Playable` instance with 0 health.
      new Paladin(this.name, 0, this.defensePoints, this.weight, this.mana)
    }
  }

  /**
   * Get the mana points of the playable entity.
   * This method always returns 0 mana points for the `Paladin` Character.
   * @return The mana points of the Paladin Character (always 0).
   */
  override def getMana: Int = 0
  /**
   * Checks if this Paladin is equal to another Paladin.
   *
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Paladin]) {
      val otherCast = other.asInstanceOf[Paladin]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }
}








