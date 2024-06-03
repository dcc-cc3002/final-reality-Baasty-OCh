package model.playable

import exceptions.weapons.InvalidputWeaponException
import exceptions.InvalidattackAllieException
import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon

/**
 * An abstract class representing a Playable entity in the game.
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
protected abstract class APlayable(val name: String, var healthPoints: Int,
                                   val defensePoints: Int, val weight: Int) extends Playable {
  require(healthPoints >= 0)
  require(defensePoints >= 0)
  require(weight >= 0)

  /**
   * Variable to represent a weapon in an APlayable Entity.
   * Base State: None (without weapon).
   */
  protected var arma: Option[Weapon] = None

  /**
   * Implementation of Method to get the name of the playable entity.
   * @return The name of the playable entity.
   */
  def getName: String = name

  /**
   * Implementation of Method to get the health points of the playable entity.
   * @return The health points of the playable entity.
   */
  def getHp: Int = healthPoints

  /**
   * Implementation of Method to set the health points of the playable entity.
   * @param newHp The new health points of the playable entity.
   */
  def setHp(newHp: Int): Unit = {
    this.healthPoints = newHp
  }

  /**
   * Implementation of Method to get the defense points of the playable entity.
   * @return The defense points of the playable entity.
   */
  def getDp: Int = defensePoints

  /**
   * Implementation of Method to get the weight of the playable entity.
   * @return The weight of the playable entity.
   */
  def getWeight: Int = weight

  /**
   * Implementation of Method to know if a Playable Entity has or not a weapon.
   * @return The Weapon of the Character or None in case he/she does not have one.
   */
  def hasWeapon: Option[Weapon] = arma

  /**
   * Abstract Method to equip a Weapon on a Playable Entity.
   * @param weapon Any class of Weapon.
   */
  def putWeapon(weapon: Weapon): String

  /**
   * Implementation method to 'reset' the state of the 'arma' parameter in a playable entity.
   */
  def dropWeapon(): Unit = {
    if (this.hasWeapon.nonEmpty) {
      this.arma = None
    } else {}
  }

  /**
   * Implementation of method to alert if the player is attempting to use a weapon owned by another character.
   * @return an Exception.
   */
  def foreignWeapon(): Boolean = throw new InvalidputWeaponException

  /**
   * Implementation method to attack a GameUnit entity.
   * @param entity The target of attack.
   * @return An affirmative message in case the target was correctly attacked and an "exception" message in other cases.
   */
  def attack(entity: GameUnit): String = {
    try {
      entity.wasAttackBy(this)
      val damage = arma.map(_.getAttack - entity.getDp).getOrElse(0)
      if (damage >= 0) {
        entity.wasAttacked(damage)
        damage
        "The enemy was attacked"
      } else
        "The enemy was attacked, but the damage is not enough"
    } catch {
      case _: InvalidattackAllieException => s"The character: ${this.getName} can't attack an ally"
    }
  }

  /**
   * Implementation method to know if Playable can be attacked by another particular GameUnit.
   * @param entity Represents the possible attacker.
   * @return True if GameUnit is an enemy of our playable entity.
   */
  def wasAttackBy(entity: GameUnit): Boolean = entity.CanAttackPlayable()

  /**
   * Method to simulate the playable entity being attacked.
   * @param pain The amount of damage inflicted on the playable entity.
   */
  def wasAttacked(pain: Int): Unit = {
    if (this.healthPoints >= pain) {
      this.setHp(this.healthPoints - pain)
    } else {
      this.setHp(0)
    }
  }

  /**
   * Method to determine if a Playable entity can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return True if the Playable entity can suffer the spell's effects, false otherwise.
   */
  def canSuffer(spell: Spell): Boolean = spell.actOnPlayable(this)
}
