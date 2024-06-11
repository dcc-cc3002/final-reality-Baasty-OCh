package model.nonplayable

import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon

/**
 * Trait representing a non-playable entity in the game.
 * A NonPlayable entity is any character or object within the game that cannot be controlled directly by the player.
 * This trait extends the GameUnit trait, indicating that all non-playable entities are also game units.
 */
trait NonPlayable extends GameUnit{

  var arma: Option[Weapon] = None
  /**
   * Abstract method to get the name of the non-playable entity
   * @return The name of the non-playable entity as a String
   */
  def getName: String

  /**
   * Abstract method to get the weight of the non-playable entity
   * @return The weight of the non-playable entity as an integer
   */
  def getWeight: Int

  def setHp(newHp:Int) : Unit

  /**
   * Abstract method to get the attack points of the non-playable entity
   * @return The attack points of the non-playable entity as an integer
   */
  def getAttack: Int

  /**
   * Abstract method to checks if the non-playable entity can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return true if the spell can affect the non-playable entity, false otherwise.
   */
  def canSuffer(spell: Spell): Boolean
}

