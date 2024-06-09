package model.spell.light

import model.playable.magic.AMagicPlayable

/**
 * Represents a Paralysis spell, a type of light spell.
 * Inherits properties and behaviors from ALightSpell.
 */
class Paralysis extends ALightSpell {
  /** The cost of casting the Paralysis spell. */
  val cost: Int = 25

  /** The name of casting the Paralysis spell. */
  def name: String = "Paralysis"

  /**
   * Determines if the Paralysis spell can be selected by a player.
   *
   * @param player The player attempting to select the Paralysis spell.
   * @return True if the Paralysis spell can be selected by the player, false otherwise.
   */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectParalysis()
}
