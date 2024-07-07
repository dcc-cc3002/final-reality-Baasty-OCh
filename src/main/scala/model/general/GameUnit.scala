package model.general

import controller.observers.ObserverAttack
import model.spell.Spell
import model.weapons.Weapon

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a unit in the game, which can be a character or an enemy.
 */
trait GameUnit {

  /** Optionally holds a weapon for the game unit. */
  var arma: Option[Weapon] = None
  var spell: Option[Spell] = None

  /**
   * Gets the name of the game unit.
   * @return The name of the game unit.
   */
  def getName: String

  /**
   * Gets the weight of the game unit.
   * @return The weight of the game unit.
   */
  def getWeight: Int

  /**
   * Sets the weight of the game unit.
   * @param newWeight The new weight of the game unit.
   */
  def setWeight(newWeight: Int): Unit

  /**
   * Gets the defense points of the game unit.
   * @return The defense points of the game unit.
   */
  def getDp: Int

  /**
   * Sets the defense points of the game unit.
   * @param newDp The new defense points of the game unit.
   */
  def setDp(newDp: Int): Unit

  /**
   * Gets the attack points of the game unit.
   * @return The attack points of the game unit.
   */
  def getAttack: Int

  /**
   * Gets the status of the game unit.
   * @return The status of the game unit.
   */
  def getStatus: String

  /**
   * Sets the status of the game unit.
   * @param newStatus The new status of the game unit.
   */
  def setStatus(newStatus: String): Unit

  /**
   * Gets the health points of the game unit.
   * @return The health points of the game unit.
   */
  def getHp: Int

  /**
   * Sets the health points of the game unit.
   * @param newHp The new health points of the game unit.
   */
  def setHp(newHp: Int): Unit

  /**
   * Determines if the game unit has a weapon.
   * @return An option containing the weapon if present, None otherwise.
   */
  def hasWeapon: Option[Weapon]

  /**
   * Retrieves the maximum health points of the game unit.
   * @return The maximum health points of the game unit.
   */
  def maxHp(): Int

  /**
   * Attacks another game unit.
   * @param entity The target of the attack.
   * @return A message indicating the result of the attack.
   */
  def attack(entity: GameUnit): String

  /**
   * Determines if the game unit can attack a playable entity.
   * @return True if the game unit can attack a playable entity, false otherwise.
   */
  def CanAttackPlayable(): Boolean

  /**
   * Determines if the game unit can attack an enemy entity.
   * @return True if the game unit can attack an enemy entity, false otherwise.
   */
  def CanAttackEnemies(): Boolean

  /**
   * Determines if the game unit was attacked by another game unit.
   * @param entity The potential attacker.
   * @return True if the game unit was attacked, false otherwise.
   */
  def wasAttackBy(entity: GameUnit): Boolean

  /**
   * Reduces the health points of the game unit by the specified amount.
   * @param pain The amount of damage the game unit receives.
   */
  def wasAttacked(pain: Int): Unit

  /**
   * Determines if the game unit can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return True if the game unit can suffer the spell's effects, false otherwise.
   */
  def canSuffer(spell: Spell): Boolean

  /**
   * Gets the mana points of the game unit.
   * @return The mana points of the game unit.
   */
  def getMana: Int

  /**
   * Equips a weapon on the game unit.
   * @param weapon The weapon to equip.
   * @return A message indicating the success of equipping the weapon.
   */
  def putWeapon(weapon: Weapon): String

  /**
   * Retrieves the style of gameplay for the game unit.
   * @param entity The game unit requesting its gameplay style.
   * @return A message indicating the style of gameplay.
   */
  def Style(entity: GameUnit): String

  /**
   * Retrieves a description of how the game unit plays.
   * @return A string describing the gameplay behavior.
   */
  def HowIPlay(): String

  /**
   * Determines if the game unit is of type magic.
   * @param gameUnit The game unit being queried.
   * @return An integer indicating whether the game unit is magic or not.
   */
  def IsMagic(gameUnit: GameUnit): Int

  /**
   * Retrieves information about common attributes of the game unit.
   * @return An integer representing the common attributes.
   */
  def IAmCommon(): Int

  /**
   * Retrieves information about magic attributes of the game unit.
   * @return An integer representing the magic attributes.
   */
  def IAmMagic(): Int

  /**
   * Determines if the game unit has a spell.
   * @return An option containing the spell if present, None otherwise.
   */
  def hasSpell(): Option[Spell]

  /**
   * Throws a spell at a target game unit.
   * @param target The game unit at which the spell is aimed.
   * @return A message indicating the success of casting the spell.
   */
  def throwSpell(target: GameUnit): String

  /**
   * Allows the character to select a spell for casting.
   * @param spell The spell to be selected by the character.
   * @return A message indicating the success of the spell selection.
   */
  def selectSpell(spell: Spell): String

  /**
   * Gets the list of spells usable by the game unit.
   * @return An ArrayBuffer containing the spells usable by the game unit.
   */
  def spells(): ArrayBuffer[Spell]

  /**
   * Gets the list of weapons usable by the game unit.
   * @return An ArrayBuffer containing the weapons usable by the game unit.
   */
  def weapons(): ArrayBuffer[Weapon]

  /**
   * Registers an observer for attacks made by the game unit.
   * @param obs The observer to be registered.
   */
  def registerAttackObserver(obs: ObserverAttack): Unit

  /**
   * Drops the currently equipped weapon.
   */
  def dropWeapon(): Unit

  /**
   * Drops the currently equipped spell.
   */
  def dropSpell(): Unit
}
