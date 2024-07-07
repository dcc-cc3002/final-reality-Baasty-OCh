package model.spell.dark

import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.weapons.Weapon
import model.weapons.magic.MagicWeapon

import scala.util.Random

/**
 * Represents a Thunder spell, a type of dark spell.
 * Inherits properties and behaviors from ADarkSpell. */
class Thunder extends ADarkSpell {
  def probabilisticFunction(): Int = {
    val randomValue = Random.nextDouble() // Genera un número aleatorio entre 0 y 1
    if (randomValue <= 0.3) 1 else 0 // Devuelve 1 con probabilidad de 30%, 0 en caso contrario
  }
  override val probability: Int = probabilisticFunction()
  /** The cost of casting the Thunder spell. */
  val cost: Int = 20

  /** The name of casting the Thunder spell. */
  val name: String = "Thunder"



  override def Effect(gameUnit: GameUnit, chance: Int = probability) = {
    val damage: Int = this.magician.get.arma.get.getMAP
    gameUnit.wasAttacked(damage)
    if (chance == 1){
      gameUnit.setStatus("Paralyzed")
    } else {}
  }

  /**
   * Determines if the Thunder spell can be selected by a player.
   * @param player The player attempting to select the Thunder spell.
   * @return True if the Thunder spell can be selected by the player, false otherwise. */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectThunder()
}
