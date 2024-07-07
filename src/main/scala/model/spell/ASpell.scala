package model.spell

import exceptions.spells.InvalidSpellTarget
import model.general.GameUnit
import model.playable.magic.{AMagicPlayable, MagicPlayable}

/**
 * Abstract class representing a spell in the game.
 * This class provides basic implementations for some methods in the Spell trait. */
abstract class ASpell extends Spell {

  /** The cost of the spell. */
  val cost: Int
  val name: String

  /** The magician associated with this spell. */
  protected var magician: Option[MagicPlayable] = None
  val probability: Int = 1

  /**
   * Determines if the spell can act on enemy units.
   * @return Always returns true, as by default spells can act on enemies. */
  def actOnEnemy(enemy: GameUnit): Boolean = {
    if (enemy.getHp > 0){
      true
    } else false
  }

  /**
   * Throws an InvalidSpellTarget exception as the default implementation.
   * @throws InvalidSpellTarget Always thrown to indicate that the spell cannot act on playable units. */
  def actOnPlayable(player: GameUnit): Boolean = throw new InvalidSpellTarget

  /**
   * Applies the spell's effect to the target game unit.
   * @param gameUnit The game unit that the spell will affect. */
  def Effect(gameUnit: GameUnit, chance: Int): Unit = {}

  /**
   * Retrieves the cost of the spell.
   * @return The cost of the spell. */
  def getCost: Int = cost
  def getName: String = name

  /**
   * Sets the magician associated with this spell.
   * @param mago The magician to be associated with the spell. */
  def setMagician(mago: MagicPlayable): Unit = {
    this.magician = Some(mago)
  }

}
