package model.playable

import controller.observers.ObserverAttack
import exceptions.weapons.InvalidPutWeaponException
import exceptions.InvalidAttackAllyException
import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

import scala.collection.mutable.ArrayBuffer

/**
 * An abstract class representing a Playable entity in the game.
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
protected abstract class APlayable(val name: String, var healthPoints: Int,
                                   var defensePoints: Int, val weight: Int) extends Playable {
  require(healthPoints >= 0, "Health points must be non-negative.")
  require(defensePoints >= 0, "Defense points must be non-negative.")
  require(weight >= 0, "Weight must be non-negative.")

  protected var attackObs = ArrayBuffer.empty[ObserverAttack]

  private val _weapons = ArrayBuffer.empty[Weapon]

  /**
   * Retrieves a clone of the weapons currently equipped by the playable entity.
   * @return A clone of the ArrayBuffer containing the playable entity's weapons. */
  override def weapons(): ArrayBuffer[Weapon] = _weapons.clone()

  /**
   * Auxiliary method to add default weapons to the playable entity's arsenal. */
  private def addWeapon(weapon: Option[Weapon]): Unit = _weapons += weapon.get

  addWeapon(Some(new Bow))
  addWeapon(Some(new Sword))
  addWeapon(Some(new Axe))
  addWeapon(Some(new Staff))
  addWeapon(Some(new Wand))

  /**
   * Retrieves the name of the playable entity.
   * @return The name of the playable entity. */
  def getName: String = name

  /**
   * Retrieves the health points of the playable entity.
   * @return The health points of the playable entity. */
  def getHp: Int = healthPoints

  /**
   * Sets the health points of the playable entity.
   * @param newHp The new health points of the playable entity. */
  def setHp(newHp: Int): Unit = {
    this.healthPoints = newHp
  }

  /**
   * Sets the defense points of the playable entity.
   * @param newDp The new defense points of the playable entity. */
  def setDp(newDp: Int): Unit = {
    this.defensePoints = newDp
  }

  /**
   * Retrieves the defense points of the playable entity.
   * @return The defense points of the playable entity. */
  def getDp: Int = defensePoints

  /**
   * Retrieves the weight of the playable entity.
   * @return The weight of the playable entity. */
  def getWeight: Int = weight

  /**
   * Checks if the playable entity has a weapon equipped.
   * @return Some(Weapon) if the playable entity has a weapon, None otherwise. */
  def hasWeapon: Option[Weapon] = arma

  /**
   * Abstract method to equip a Weapon on a Playable Entity.
   * @param weapon Any class of Weapon.
   * @return A message indicating the success or failure of equipping the weapon. */
  def putWeapon(weapon: Weapon): String

  /**
   * Drops the weapon currently equipped by the playable entity. */
  def dropWeapon(): Unit = {
    if (this.hasWeapon.nonEmpty) {
      this.arma = None
    } else {}
  }

  /**
   * Throws an exception indicating that the playable entity cannot use a foreign weapon.
   * @return An InvalidPutWeaponException. */
  def foreignWeapon(): Boolean = throw new InvalidPutWeaponException

  /**
   * Attacks a GameUnit entity.
   * @param entity The target of the attack.
   * @return A message indicating if the attack was successful or not. */
  def attack(entity: GameUnit): String = {
    try {
      entity.wasAttackBy(this)
      val damage = arma.map(_.getAttack - entity.getDp).getOrElse(0)
      if (damage >= 0) {
        entity.setDp(0)
        entity.wasAttacked(damage)
        for (o <- attackObs) {
          o.notifySimpleAttack(this, entity, damage)
        }
        "The enemy was attacked"
      } else {
        entity.setDp(entity.getDp - damage.abs)
        "The enemy was attacked, but the damage is not enough"
      }
    } catch {
      case _: InvalidAttackAllyException => s"The character: ${this.getName} can't attack an ally"
    }
  }

  /**
   * Retrieves the playing style of the playable entity.
   * @param entity The entity whose style is being queried.
   * @return The playing style of the entity. */
  def Style(entity: GameUnit): String = {
    entity.HowIPlay()
  }

  /**
   * Retrieves the playing style identifier of the playable entity.
   * @return A string identifying the playing style of the entity. */
  def HowIPlay(): String = "playable"

  /**
   * Determines if the playable entity can be attacked by another specific GameUnit.
   * @param entity The possible attacker.
   * @return true if the GameUnit is an enemy of our playable entity, false otherwise. */
  def wasAttackBy(entity: GameUnit): Boolean = entity.CanAttackPlayable()

  /**
   * Retrieves the identifier indicating whether the playable entity is magical or not.
   * @param gameUnit The entity being queried.
   * @return 1, indicating the playable entity is not magical. */
  def IsMagic(gameUnit: GameUnit): Int = {
    gameUnit.IAmCommon()
  }

  /**
   * Method to simulate the playable entity being attacked.
   * @param pain The amount of damage inflicted on the playable entity. */
  def wasAttacked(pain: Int): Unit = {
    if (this.healthPoints >= pain) {
      this.setHp(this.healthPoints - pain)
    } else {
      this.setHp(0)
    }
  }

  /**
   * Determines if the playable entity can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return True if the playable entity can suffer the spell's effects, false otherwise. */
  def canSuffer(spell: Spell): Boolean = spell.actOnPlayable(this)

  /**
   * Registers an attack observer for the playable entity.
   * @param obs The observer to be registered. */
  def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }

  /**
   * Retrieves the attack points of the playable entity.
   * @return The attack points of the playable entity. */
  def getAttack: Int = arma.map(_.getAttack).getOrElse(0)
}
