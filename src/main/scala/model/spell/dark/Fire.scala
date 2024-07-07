package model.spell.dark

import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.spell.ASpell
import scala.util.Random


/**
 * Represents a Fire spell, a type of dark spell.
 * Inherits properties and behaviors from ASpell. */
class Fire extends ASpell {
  def probabilisticFunction(): Int = {
    val randomValue = Random.nextDouble() // Genera un número aleatorio entre 0 y 1
    if (randomValue <= 0.2) 1 else 0 // Devuelve 1 con probabilidad de 20%, 0 en caso contrario
  }
  override val probability: Int = probabilisticFunction()
  /** The cost of casting the Fire spell. */
  val cost: Int = 15

  /** The name of casting the Fire spell. */
  val name: String = "Fire"


  override def Effect(gameUnit: GameUnit, chance: Int = probability): Unit = {
    val damage: Int = this.magician.get.arma.get.getMAP
    gameUnit.wasAttacked(damage)
    if (chance == 1){
      if (damage == 60){gameUnit.setStatus("Quemado con Baston")}
      else {gameUnit.setStatus("Quemado con Varita")}
    } else {}
  }

  /**
   * Determines if the Fire spell can be selected by a player.
   * @param player The player attempting to select the Fire spell.
   * @return True if the Fire spell can be selected by the player, false otherwise. */
  def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectFire()
}
