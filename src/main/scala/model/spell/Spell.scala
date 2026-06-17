package model.spell

import model.general.GameUnit
import model.playable.magic.{AMagicPlayable, MagicPlayable}
trait Spell {

  /**
   * The probability of the spell's effect occurring.
   * Represented as an integer.
   */
  val probability: Int

  /**
   * The name of the spell.
   * Represented as a string.
   */
  def name: String

  /**
   * Abstract method to get the cost of the spell.
   * @return The cost of the spell as an integer. */
  def getCost: Int

  /**
   * Gets the name of the spell.
   * @return The name of the spell as a string. */
  def getName: String


/**
 * Abstract method to applies the effect of the spell to the target.
 * @param target The game unit that the spell will affect. */
def Effect(target: GameUnit, chance: Int): Unit

/**
 * Abstract method to determines if the spell can be selected by a given player.
 * @param player The player attempting to select the spell.
 * @return True if the spell can be selected by the player, false otherwise. */
def canBeSelectedBy(player: AMagicPlayable): Boolean

/**
 * Abstract method to checks if the spell can act on playable units.
 * @return True if the spell can act on playables, false otherwise. */
def actOnPlayable(player: GameUnit): Boolean

/**
 * Abstract method checks if the spell can act on enemy units.
 * @return True if the spell can act on enemies, false otherwise. */
def actOnEnemy(enemy: GameUnit): Boolean

/**
 * Abstract method to sets the magician associated with this spell.
 * @param mago The magician to be associated with the spell. */
def setMagician(mago: MagicPlayable): Unit


}
