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
 * @param name The name of the enemy.
 * @param life The life points of the enemy.
 * @param defence The defence points of the enemy.
 * @param weight The weight of the enemy.
 * @param attackPoints The attack points of the enemy.
 */
protected abstract class AEnemy(val name: String, var life: Int, var defence: Int,
                                val weight: Int, val attackPoints: Int) extends NonPlayable {

  require(weight >= 0 && weight <= 150, "Weight must be between 0 and 150.")
  require(attackPoints >= 0 && attackPoints <= 100, "Attack points must be between 0 and 100.")
  require(life >= 0 && life <= 500, "Life points must be between 0 and 500.")
  require(defence >= 0 && defence <= 500, "Defence points must be between 0 and 500.")

  private val attackObs = ArrayBuffer.empty[ObserverAttack]

  /**
   * Retrieves the name of the non-playable entity.
   * @return The name of the non-playable entity. */
  def getName: String = name

  /**
   * Retrieves the weight of the non-playable entity.
   * @return The weight of the non-playable entity. */
  def getWeight: Int = weight

  /**
   * Retrieves the defence points of the non-playable entity.
   * @return The defence points of the non-playable entity. */
  def getDp: Int = defence

  /**
   * Retrieves the attack points of the non-playable entity.
   * @return The attack points of the non-playable entity. */
  def getAttack: Int = attackPoints

  /**
   * Retrieves the life points of the non-playable entity.
   * @return The life points of the non-playable entity. */
  def getHp: Int = life

  /**
   * Sets the life points of the non-playable entity.
   * @param newLife The new life points of the non-playable entity. */
  def setHp(newLife: Int): Unit = {
    this.life = newLife
  }

  /**
   * Sets the defence points of the non-playable entity.
   * @param newDp The new defence points of the non-playable entity. */
  def setDp(newDp: Int): Unit = {
    this.defence = newDp
  }

  /**
   * Retrieves the style of the non-playable entity.
   * @param entity The entity whose style is being retrieved.
   * @return The style of the non-playable entity. */
  def Style(entity: GameUnit): String = entity.HowIPlay()

  /**
   * Auxiliary method to retrieves the style of the non-playable entity.
   * @return The style of the non-playable entity. */
  def HowIPlay(): String = "enemy"

  /**
   * Retrieves the type of the non-playable entity.
   * @param gameUnit The game unit whose magic type is being retrieved.
   * @return The answer of the non-playable entity. */
  def IsMagic(gameUnit: GameUnit): Int = gameUnit.IAmCommon()

  /**
   * Abstract method to attack an entity.
   * @param entity The entity being attacked.
   * @return A message indicating if the attack was successful or not. */
  def attack(entity: GameUnit): String = {
    try {
      entity.wasAttackBy(this)
      val damage: Int = this.attackPoints - entity.getDp
      if (damage >= 0) {
        entity.setDp(0)
        entity.wasAttacked(damage)
        for (o <- attackObs) {
          o.notifySimpleEnemyAttack(this, entity, damage)
        }
        "The target was attacked"
      } else {
        entity.setDp(damage.abs)
        "The enemy was attacked, but the damage is not enough"
      }
    } catch {
      case _: InvalidAttackAllyException => s"The character: ${this.getName} can't attack an ally"
    }
  }

  /**
   * Checks if the enemy can attack playable units.
   * @return true, indicating that the enemy can attack playable units. */
  def CanAttackPlayable(): Boolean = true

  /**
   * Checks if the enemy can attack other enemies.
   * @return false, indicating that the enemy cannot attack other enemies (throws an exception). */
  def CanAttackEnemies(): Boolean = throw new InvalidAttackAllyException

  /**
   * Simulates the enemy being attacked.
   * @param damage The amount of damage inflicted on the enemy. */
  def wasAttacked(damage: Int): Unit = {
    if (this.life >= damage) {
      this.setHp(this.life - damage)
    } else {
      this.setHp(0)
    }
  }

  /**
   * Checks if the enemy can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return true if the spell can affect the enemy, false otherwise. */
  def canSuffer(spell: Spell): Boolean = spell.actOnEnemy(this)

  /**
   * Registers an observer to receive notifications about attacks.
   * @param obs The observer to register. */
  override def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }

  /**
   * Method to equip a Weapon on a Non-Playable Entity.
   * @param weapon The weapon to be equipped.
   * @return A message indicating the success or failure of equipping the weapon. */
  def putWeapon(weapon: Weapon): String = throw new InvalidPutWeaponException

}
