package model.general

import controller.observers.ObserverAttack
import model.spell.Spell
import model.weapons.Weapon

import scala.collection.mutable.ArrayBuffer

trait GameUnit {

  /**
   * Abstract method to get the name of the playable entity
   */
  def getName: String

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

  def setHp(newHp : Int): Unit

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

  /**
   * Abstract of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int

  /**
   * Abstract Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon( weapon: Weapon): String


  /**
   * Abstract Method Throws a spell at a target game unit.
   * @param target The game unit at which the spell is aimed.
   * @return A message indicating the success of casting the spell.
   */
  def throwSpell(target: GameUnit): String

  /**
   * Array to represent usable spells
   */
  def spells(): ArrayBuffer[Spell]

  def weapons(): ArrayBuffer[Weapon]

  /**
   * Allows the character to choose a spell for casting.
   * @param spell The spell to be chosen by the character.
   * @return A message indicating the success of the spell selection.
   */
  def selectSpell(spell: Spell): String

  def registerAttackObserver(obs: ObserverAttack): Unit
}
