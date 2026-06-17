package model.general

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
   * Abstract method to get the Health points of the entity
   */

  def getHp: Int

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

  /**
   * Abstract method to determine if a Playable entity can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return True if the Playable entity can suffer the spell's effects, false otherwise.
   */
  def canSuffer(spell : Spell): Boolean
}
