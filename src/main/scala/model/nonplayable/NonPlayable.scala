package model.nonplayable

import model.general.GameUnit
import model.spell.Spell
import model.weapons.Weapon

import scala.collection.mutable.ArrayBuffer

/**
 * Trait representing a non-playable entity in the game.
 * A NonPlayable entity is any character or object within the game that cannot be controlled directly by the player.
 * This trait extends the GameUnit trait, indicating that all non-playable entities are also game units.
 */
trait NonPlayable extends GameUnit{

}

