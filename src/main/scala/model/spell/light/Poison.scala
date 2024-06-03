package model.spell.light

import model.playable.magic.AMagicPlayable

/**
 * Represents a Poison spell, a type of light spell.
 * Inherits properties and behaviors from ALightSpell.
 */
class Poison extends ALightSpell {
  /** The cost of casting the Poison spell. */
  val cost: Int = 30

  /**
   * Determines if the Poison spell can be selected by a player.
   *
   * @param player The player attempting to select the Poison spell.
   * @return True if the Poison spell can be selected by the player, false otherwise.
   */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectPoison()
}
