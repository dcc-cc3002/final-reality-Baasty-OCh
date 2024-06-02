package model.spell.dark

import model.playable.magic.AMagicPlayable

/**
 * Represents a Thunder spell, a type of dark spell.
 * Inherits properties and behaviors from ADarkSpell.
 */
class Thunder extends ADarkSpell {
  /** The cost of casting the Thunder spell. */
  val cost: Int = 20

  /**
   * Determines if the Thunder spell can be selected by a player.
   *
   * @param player The player attempting to select the Thunder spell.
   * @return True if the Thunder spell can be selected by the player, false otherwise.
   */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectThunder()
}
