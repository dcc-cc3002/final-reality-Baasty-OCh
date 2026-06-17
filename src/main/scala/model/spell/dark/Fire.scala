package model.spell.dark
import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.spell.ASpell
import scala.util.Random

/**
 * Represents a Fire spell, a type of dark spell.
 * Inherits properties and behaviors from ASpell.
 */
class Fire extends ASpell {

  /**
   * Generates a random value to determine the probability of the spell's effect occurring.
   * @return 1 with a 20% probability, 0 otherwise.
   */
  def probabilisticFunction(): Int = {
    val randomValue = Random.nextDouble() // Generates a random number between 0 and 1
    if (randomValue <= 0.2) 1 else 0 // Returns 1 with a 20% probability, 0 otherwise
  }

  /** The probability of the spell's effect occurring. */
  override val probability: Int = probabilisticFunction()

  /** The cost of casting the Fire spell. */
  val cost: Int = 15

  /** The name of the Fire spell. */
  val name: String = "Fire"

  /**
   * Applies the effect of the Fire spell to the target GameUnit.
   * @param gameUnit The target of the spell.
   * @param chance The probability of the spell's effect occurring.
   */
  override def Effect(gameUnit: GameUnit, chance: Int = probability): Unit = {
    val damage: Int = this.magician.get.arma.get.getMAP
    gameUnit.wasAttacked(damage)
    if (chance == 1) {
      if (damage == 60) {
        gameUnit.setStatus("Burned with Staff")
      } else {
        gameUnit.setStatus("Burned with Wand")

      }
    }
  }

  /**
   * Determines if the Fire spell can be selected by a player.
   * @param player The player attempting to select the Fire spell.
   * @return True if the Fire spell can be selected by the player, false otherwise.
   */
  def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
