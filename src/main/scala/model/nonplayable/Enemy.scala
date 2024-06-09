package model.nonplayable

import controller.observers.ObserverAttack
import model.general.GameUnit
import model.spell.Spell

import scala.collection.mutable.ArrayBuffer

/**
 * "An enemy is a type of non-playable character that represents the adversary
 *  or adversaries to be defeated by the group of players."
 * @param name
 * @param weight
 * @param attack
 * @param life
 * @param defence
 */
class Enemy(name: String, weight: Int,
            attackPoints: Int, life: Int,
            defence: Int) extends AEnemy(name, weight, attackPoints, life, defence) {
  private var _spells = ArrayBuffer.empty[Spell]

  /**
   * "The auxiliary builder receives the name that the user chooses for their non-playable entity
   * and sets the other statistics according to the enemy class."
   * @param name
   * @return Playable
   */

  def this(name:String) ={
    this(name,50,80,250,50)
  }

  /**
   * Implementation method to know if Enemy can be attacked by other particular Game Unit
   * @param entity represents the possible attacker
   * @return true in case Game Unit was enemy of our non-playable entity
   */
  def wasAttackBy(entity:GameUnit): Boolean = entity.CanAttackEnemies()

  /**
   * Checks if this Enemy is equal to another Enemy.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, Name, Weight, Life and DF, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Enemy]) {
      val otherCast = other.asInstanceOf[Enemy]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp )

    } else false
  }



  /**
   * Abstract of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int = 0


  /**
   * Abstract Method Throws a spell at a target game unit.
   * @param target The game unit at which the spell is aimed.
   * @return A message indicating the success of casting the spell.
   */
  def throwSpell(target: GameUnit): String = "nothing"

  /**
   * Array to represent usable spells
   */
  def spells(): ArrayBuffer[Spell] = ArrayBuffer.empty[Spell]

  /**
   * Allows the character to choose a spell for casting.
   * @param spell The spell to be chosen by the character.
   * @return A message indicating the success of the spell selection.
   */
  def selectSpell(spell: Spell): String = "nothing"

  def registerAttackObserver(obs: ObserverAttack): Unit = {}
}


