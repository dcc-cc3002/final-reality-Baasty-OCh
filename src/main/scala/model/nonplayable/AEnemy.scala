package model.nonplayable

import controller.observers.ObserverAttack
import exceptions.InvalidAttackAllyException
import exceptions.weapons.InvalidPutWeaponException
import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon

import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class representing an enemy entity in the game.
 * This class represents a non-playable enemy entity in the game. It defines common properties
 * and behavior for all enemy types.
 *
 * @param name         The name of the enemy.
 * @param life         The life points of the enemy.
 * @param defence      The defence points of the enemy.
 * @param weight       The weight of the enemy.
 * @param attackPoints The attack points of the enemy.
 * @param status       The current status of the enemy (e.g., Healthy, Poisoned).
 */
protected abstract class AEnemy(val name: String, var life: Int, var defence: Int,
                                var weight: Int, val attackPoints: Int, var status: String) extends NonPlayable {

  require(weight >= 0 && weight <= 150, "Weight must be between 0 and 150.")
  require(attackPoints >= 0 && attackPoints <= 100, "Attack points must be between 0 and 100.")
  require(life >= 0 && life <= 500, "Life points must be between 0 and 500.")
  require(defence >= 0 && defence <= 500, "Defence points must be between 0 and 500.")

  private val attackObs = ArrayBuffer.empty[ObserverAttack]
  private val _weapons = ArrayBuffer.empty[Weapon]

  var arma: Option[Weapon] = None
  var spell: Option[Spell] = None

  /**
   * Retrieves a clone of the weapons currently equipped by the enemy.
   * @return A clone of the ArrayBuffer containing the enemy's weapons.
   */
  override def weapons(): ArrayBuffer[Weapon] = _weapons

  /**
   * Retrieves the name of the non-playable entity.
   * @return The name of the non-playable entity.
   */
  def getName: String = name

  /**
   * Retrieves the current status of the enemy.
   * @return The current status of the enemy.
   */
  def getStatus: String = status

  /**
   * Sets the current status of the enemy.
   * @param newStatus The new status of the enemy.
   */
  def setStatus(newStatus: String): Unit = {
    this.status = newStatus
  }

  /**
   * Retrieves the weight of the non-playable entity.
   * @return The weight of the non-playable entity.
   */
  def getWeight: Int = weight

  /**
   * Sets the weight of the non-playable entity.
   * @param newWeight The new weight of the non-playable entity.
   */
  def setWeight(newWeight: Int): Unit = {
    this.weight = newWeight
  }

  /**
   * Retrieves the defence points of the non-playable entity.
   * @return The defence points of the non-playable entity.
   */
  def getDp: Int = defence

  /**
   * Retrieves the attack points of the non-playable entity.
   * @return The attack points of the non-playable entity.
   */
  def getAttack: Int = attackPoints

  /**
   * Retrieves the life points of the non-playable entity.
   * @return The life points of the non-playable entity.
   */
  def getHp: Int = life

  /**
   * Sets the life points of the non-playable entity.
   * @param newLife The new life points of the non-playable entity.
   */
  def setHp(newLife: Int): Unit = {
    if (newLife == 0) {
      this.setStatus("Dead")
    } else {}
    this.life = newLife
  }

  /**
   * Sets the defence points of the non-playable entity.
   * @param newDp The new defence points of the non-playable entity.
   */
  def setDp(newDp: Int): Unit = {
    this.defence = newDp
  }

  /**
   * Checks if the non-playable entity has a weapon equipped.
   * @return None, indicating that non-playable entities do not equip weapons.
   */
  override def hasWeapon: Option[Weapon] = None

  /**
   * Retrieves the common attributes identifier.
   * @return Always returns 0 for non-playable entities.
   */
  def IAmCommon(): Int = 0

  /**
   * Retrieves the magic attributes identifier.
   * @return Always returns 0 for non-playable entities.
   */
  def IAmMagic(): Int = 0

  /**
   * Checks if the non-playable entity has a spell.
   * @return None, indicating that non-playable entities do not have spells.
   */
  override def hasSpell(): Option[Spell] = None

  /**
   * Retrieves the mana points of the non-playable entity.
   * @return Always returns 0 for non-playable entities.
   */
  def getMana: Int = 0

  /**
   * Throws a spell at a target game unit (dummy implementation for non-playable entities).
   * @param target The game unit at which the spell is aimed.
   * @return Always returns "nothing" for non-playable entities.
   */
  def throwSpell(target: GameUnit): String = "nothing"

  /**
   * Allows the non-playable entity to choose a spell (dummy implementation for non-playable entities).
   * @param spell The spell to be chosen.
   * @return Always returns "nothing" for non-playable entities.
   */
  def selectSpell(spell: Spell): String = "nothing"

  /**
   * Retrieves the list of spells usable by the non-playable entity.
   * @return Always returns an empty ArrayBuffer for non-playable entities.
   */
  def spells(): ArrayBuffer[Spell] = ArrayBuffer.empty[Spell]

  /**
   * Retrieves the style of the non-playable entity based on the entity being queried.
   * @param entity The entity whose style is being queried.
   * @return The style of the non-playable entity (always returns the style of the queried entity).
   */
  def Style(entity: GameUnit): String = entity.HowIPlay()

  /**
   * Retrieves the general style of the non-playable entity.
   * @return The general style of the non-playable entity.
   */
  def HowIPlay(): String = "enemy"

  /**
   * Retrieves the magic type identifier for the non-playable entity.
   * @param gameUnit The game unit whose magic type is being retrieved.
   * @return Always returns 0 for non-playable entities.
   */
  def IsMagic(gameUnit: GameUnit): Int = gameUnit.IAmCommon()

  /**
   * Attacks another game unit (dummy implementation for non-playable entities).
   * @param entity The game unit being attacked.
   * @return Always returns a message indicating the result of the attack for non-playable entities.
   */
  def attack(entity: GameUnit): String = {
    try {
      entity.wasAttackBy(this)
      val damage: Int = this.attackPoints - entity.getDp
      if (damage >= 0) {
        entity.wasAttacked(damage)
        for (o <- attackObs) {
          o.notifySimpleEnemyAttack(this, entity, damage)
        }
        "The target was attacked"
      } else {
        entity.setDp(damage.abs)
        for (o <- attackObs) {
          o.notifySimpleEnemyAttack(this, entity, 0)
        }
        "The enemy was attacked, but the damage is not enough"
      }
    } catch {
      case _: InvalidAttackAllyException => s"The character: ${this.getName} can't attack an ally"
    }
  }

  /**
   * Checks if the enemy can attack playable units.
   * @return Always returns true, indicating that the enemy can attack playable units.
   */
  def CanAttackPlayable(): Boolean = true

  /**
   * Checks if the enemy can attack other enemies.
   * @return Always throws an InvalidAttackAllyException, indicating that enemies cannot attack other enemies.
   */
  def CanAttackEnemies(): Boolean = throw new InvalidAttackAllyException

  /**
   * Determines if the enemy can be attacked by another specific game unit.
   * @param entity The game unit representing the potential attacker.
   * @return Always returns true, indicating that the enemy can be attacked by the specified game unit.
   */
  def wasAttackBy(entity: GameUnit): Boolean = entity.CanAttackEnemies()

  /**
   * Simulates the enemy being attacked.
   * @param damage The amount of damage inflicted on the enemy. */
  def wasAttacked(damage: Int): Unit = {
    this.setDp(0)
    if (this.life >= damage) {
      this.setHp(this.life - damage)
    } else {
      this.setHp(0)
    }
  }

  /**
   * Checks if the enemy can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return Always returns true, indicating that the enemy can suffer the effects of any spell.
   */
  def canSuffer(spell: Spell): Boolean = spell.actOnEnemy(this)

  /**
   * Registers an observer to receive notifications about attacks.
   * @param obs The observer to register.
   */
  override def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }

  /**
   * Attempts to equip a weapon on the enemy (dummy implementation for non-playable entities).
   * @param weapon The weapon to be equipped.
   * @return Always returns "Invalid", indicating that non-playable entities cannot equip weapons.
   */
  def putWeapon(weapon: Weapon): String =
    try {
      throw new InvalidPutWeaponException
    } catch {
      case e: InvalidPutWeaponException => "Invalid"
    }

  /**
   * Dummy method for dropping a weapon (dummy implementation for non-playable entities).
   */
  def dropWeapon(): Unit = {}

  /**
   * Dummy method for dropping a spell (dummy implementation for non-playable entities).
   */
  def dropSpell(): Unit = {}
}
