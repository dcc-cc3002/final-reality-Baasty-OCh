package model.general

import model.nonplayable.Enemy
import model.playable.Playable
import model.spell.Spell

trait GameUnit {
  /**
   * Abstract Method to get the weight of a entity (characters or enemies) in the game.
   */
  def getWeight: Int

  /**
   * Abstract Method to get the Defense Points of Game Unit
   */
  def getDp:Int

  /**
   * Abstract Method to attack entity
   * @param entity the target of attack
   */
  def attack(entity: GameUnit): String

  /**
   * Abtract method to know if a Game Unit can attack a Playable entity
   * @param entity the candidate to be the target of attack
   */
  def CanAttackPlayable(): Boolean


  /**
   * Abtract method to know if a Game Unit can attack a Enemy entity
   * @param entity the candidate to be the target of attack
   */
  def CanAttackEnemies(): Boolean

  /**
   * Abstract method to know if a Game Unit can be attacked by another Game Unit
   * @param entity represents the possible attacker
   */
  def wasAttackBy(entity:GameUnit): Boolean

  /**
   * Abstract method to down the health points of a Game Unit who was attack by another Game Unit
   * @param pain the amount of damage Game Unit receive
   */
  def wasAttacked(pain:Int) : Unit

  def canSuffer(spell : Spell): Boolean
}
