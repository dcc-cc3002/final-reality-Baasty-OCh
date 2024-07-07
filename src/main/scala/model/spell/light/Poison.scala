package model.spell.light

import model.general.GameUnit
import model.playable.magic.AMagicPlayable
import model.weapons.Weapon
import model.weapons.magic.MagicWeapon

/**
 * Represents a Poison spell, a type of light spell.
 * Inherits properties and behaviors from ALightSpell. */
class Poison extends ALightSpell {
  /** The cost of casting the Poison spell. */
  val cost: Int = 30

  /** The name of casting the Poison spell. */
  val name: String = "Poison"

  override def Effect(gameUnit: GameUnit, chance:Int): Unit = {
    val MagicWeapon: Weapon = this.magician.get.arma.get
    if (MagicWeapon.getName == "Baston"){
      gameUnit.setStatus("Envenenado con Baston")
    } else gameUnit.setStatus("Envenenado con Varita")

  }

  /**
   * Determines if the Poison spell can be selected by a player.
   *
   * @param player The player attempting to select the Poison spell.
   * @return True if the Poison spell can be selected by the player, false otherwise. */
  override def canBeSelectedBy(player: AMagicPlayable): Boolean = player.canSelectPoison()
}
