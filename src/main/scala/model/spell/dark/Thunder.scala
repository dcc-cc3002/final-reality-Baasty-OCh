package model.spell.dark

import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.weapons.Weapon
import model.weapons.magic.MagicWeapon

import scala.util.Random

/**
 * Represents a Thunder spell, a type of dark spell.
 * Inherits properties and behaviors from ADarkSpell.
 */
class Thunder extends ADarkSpell {

  /**
   * Generates a random value to determine the probability of the spell's effect occurring.
   * @return 1 with a 30% probability, 0 otherwise.
   */
  def probabilisticFunction(): Int = {
    val randomValue = Random.nextDouble() // Generates a random number between 0 and 1
    if (randomValue <= 0.3) 1 else 0 // Returns 1 with a 30% probability, 0 otherwise
  }

  /** The probability of the spell's effect occurring. */
  override val probability: Int = probabilisticFunction()

  /** The cost of casting the Thunder spell. */
  val cost: Int = 20

  /** The name of the Thunder spell. */
  val name: String = "Thunder"

  /**
   * Applies the effect of the Thunder spell to the target GameUnit.
   * @param gameUnit The target of the spell.
   * @param chance The probability of the spell's effect occurring.
   */
  override def Effect(gameUnit: GameUnit, chance: Int = probability): Unit = {
    val damage: Int = this.magician.get.arma.get.getMAP
    gameUnit.wasAttacked(damage)
    if (chance == 1) {
      gameUnit.setStatus("Paralyzed")
    }
  }

  /**
   * Determines if the Thunder spell can be selected by a player.
   * @param player The player attempting to select the Thunder spell.
   * @return True if the Thunder spell can be selected by the player, false otherwise. */
   def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectThunder() // revisar
}
