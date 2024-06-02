package model.spell

import exceptions.spells.InvalidspellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

/**
 * Abstract class representing a spell in the game.
 * This class provides basic implementations for some methods in the Spell trait.
 */
abstract class ASpell extends Spell {

  /** The cost of the spell. */
  val cost: Int

  /** The magician associated with this spell. */
  var magican: Option[AMagicPlayable] = None

  /**
   * Determines if the spell can act on enemy units.
   * @return Always returns true, as by default spells can act on enemies.
   */
  def actOnEnemy(): Boolean = true

  /**
   * Throws an InvalidSpellTarget exception as the default implementation.
   * @throws InvalidspellTarget Always thrown to indicate that the spell cannot act on playable units.
   */
  def actOnPlayable(): Boolean = throw new InvalidspellTarget

  /**
   * Applies the spell's effect to the target game unit.
   * @param gameUnit The game unit that the spell will affect.
   */
  def Effect(gameUnit: GameUnit): Unit = {}

  /**
   * Retrieves the cost of the spell.
   * @return The cost of the spell.
   */
  def getCost: Int = cost

  /**
   * Sets the magician associated with this spell.
   * @param mago The magician to be associated with the spell.
   */
  def setMagican(mago: AMagicPlayable): Unit = {
    this.magican = Some(mago)
  }

}
