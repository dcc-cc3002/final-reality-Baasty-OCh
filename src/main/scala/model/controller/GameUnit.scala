package model.controller

import model.nonplayable.Enemy
import model.playable.Playable

trait GameUnit {
  /**
   * Abstract Method to get the weight of a entity (characters or enemies) in the game.
   * @return weight of players (characters or enemies)
   */
  def getWeight: Int

  def attack(entity: GameUnit): Int
  def CanAttackPlayables(entity: Playable): Boolean
  def CanAttackEnemies(entity: Enemy): Boolean
  def wasAttackBy(entity:GameUnit): Boolean
  def getDp:Int
  def wasAttacked(pain:Int) : Unit
}
