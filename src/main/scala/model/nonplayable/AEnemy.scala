package model.nonplayable

import controller.observers.ObserverAttack
import exceptions.InvalidAttackAllyException
import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon

import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class representing an enemy entity in the game.
 * @param name The name of the enemy.
 * @param weight The weight of the enemy.
 * @param attackPoints The attack points of the enemy.
 * @param life The life points of the enemy.
 * @param defence The defence points of the enemy.
 */
protected abstract class AEnemy(val name: String, var life: Int,var defence: Int,
                                val weight: Int, val attackPoints: Int,
                                ) extends NonPlayable {

  require(weight >=0 && weight<=150, "Weight must be between 0 and 150.")
  require(attackPoints >=0 && attackPoints<=100, "Attack points must be between 0 and 100.")
  require(life >=0 && life <=250, "Life points must be between 0 and 250.")
  require(defence >=0 && defence<=500, "Defence points must be between 0 and 500.")

  private var attackObs = ArrayBuffer.empty[ObserverAttack]

  /**
   * Retrieves the name of the non-playable entity.
   * @return The name of the non-playable entity.
   */
  def getName: String = name

  /**
   * Retrieves the weight of the non-playable entity.
   * @return The weight of the non-playable entity.
   */
  def getWeight: Int = weight

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
    this.life = newLife
  }

  /**
   * Sets the life points of the non-playable entity.
   * @param newLife The new life points of the non-playable entity.
   */
  def setDp(newDp: Int): Unit = {
    this.defence = newDp
  }

  def Juega(entity: GameUnit): String = " "
  def magic(gameUnit: GameUnit): Int = {
    gameUnit.ComoSoyComun()
  }

  override def ComoSoyComun(): Int = 0

  override def ComoSoyMagico(): Int = 0


  def ComoJuego(): String = "enemy"
  /**
   * Abstract method to attack an entity.
   * @param entity The entity being attacked.
   * @return A message indicating if the attack was successful or not.
   */
  def attack(entity: GameUnit): String = {
    try {
      entity.wasAttackBy(this)
      val damage: Int = entity.getDp - this.attackPoints
      if (damage < 0) {
        entity.setDp(0)
        entity.wasAttacked(damage.abs)
        for (o <- attackObs) {
          o.notifySimpleEnemyAttack(this, entity, damage.abs)
        }
        "The target was attacked"
      } else  {entity.setDp(damage.abs)
        "The enemy was attacked, but the damage is not enough"}
    } catch {
      case _: InvalidAttackAllyException => s"The character: ${this.getName} can't attack an ally"
    }
  }

  /**
   * Checks if the enemy can attack playable units.
   * @return true, indicating that the enemy can attack playable units.
   */
  def CanAttackPlayable(): Boolean = true

  /**
   * Checks if the enemy can attack other enemies.
   * @return false, indicating that the enemy cannot attack other enemies (throws an exception).
   */
  def CanAttackEnemies(): Boolean = throw new InvalidAttackAllyException

  /**
   * Simulates the enemy being attacked.
   * @param damage The amount of damage inflicted on the enemy.
   */
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
   * @return true if the spell can affect the enemy, false otherwise.
   */
  def canSuffer(spell: Spell): Boolean = spell.actOnEnemy(this)

  override def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: Weapon): String = "nothing"

}

