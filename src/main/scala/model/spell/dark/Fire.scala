package model.spell.dark

import model.playable.magic.AMagicPlayable
import model.spell.ASpell

/**
 * Represents a Fire spell, a type of dark spell.
 * Inherits properties and behaviors from ASpell.
 */
class Fire extends ASpell {
  /** The cost of casting the Fire spell. */
  val cost: Int = 15

  /** The name of casting the Fire spell. */
  def name: String = "Fire"

  /**
   * Determines if the Fire spell can be selected by a player.
   *
   * @param player The player attempting to select the Fire spell.
   * @return True if the Fire spell can be selected by the player, false otherwise.
   */
  def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
