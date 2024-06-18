package model.spell.light

import exceptions.spells.InvalidSpellTarget
import model.general.GameUnit
import model.playable.magic.AMagicPlayable

/**
 * Represents a Healing spell, a type of light spell.
 * Inherits properties and behaviors from ALightSpell.
 */
class Healing extends ALightSpell {
  /** The cost of casting the Healing spell. */
  val cost: Int = 15

  /** The name of casting the Healing spell. */
  val name: String = "Healing"

  override def Effect(gameUnit: GameUnit): Unit = {
    gameUnit.setHp(gameUnit.getHp + gameUnit.maxHp()/3)
  }

  /**
   * Determines if the Healing spell can act on playable units.
   * @return Always returns true, as the Healing spell can act on playable units. */
  override def actOnPlayable(player: GameUnit): Boolean = {
    if (player.getHp > 0){
      true
    } else false
  }

  /**
   * Throws an InvalidspellTarget exception as the Healing spell cannot act on enemy units.
   * @throws InvalidSpellTarget Always thrown to indicate that the Healing spell cannot act on enemy units. */
  override def actOnEnemy(enemy: GameUnit): Boolean = throw new InvalidSpellTarget

  /**
   * Determines if the Healing spell can be selected by a player.
   * @param player The player attempting to select the Healing spell.
   * @return True if the Healing spell can be selected by the player, false otherwise. */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectHealing()
}

