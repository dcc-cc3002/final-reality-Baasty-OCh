package model.general.party

import exceptions.InvalidAdditionPartyException
import model.general.GameUnit

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a party of playable characters.
 * This class manages a group of playable characters (allies) that work together as a unit.
 * The party can contain up to three unique playable characters. Each character is stored
 * in an ArrayBuffer, allowing for efficient retrieval and management.
 */
class Party {

  /**
   * ArrayBuffer to store the allies in the party. */
  val buff: ArrayBuffer[GameUnit] = ArrayBuffer.empty[GameUnit]

  /**
   * Adds a game unit character to the party.
   * @param pj The game unit to be added.
   * @return A message indicating the success or failure of adding the unit. */
  def addGameUnit(pj: GameUnit): String = {
    try {
      if (buff.size < 3) {
        buff += pj
        "The unit was added successfully."
      } else {
        throw new InvalidAdditionPartyException
      }
    } catch {
      case _: InvalidAdditionPartyException => "The party cannot add more than 3 players; it is full."
    }
  }

  /**
   * Sets the health points (HP) of all game units in the party to 0.
   */
  def setAllHpToZero(): Unit = {
    buff.foreach(_.setHp(0))
  }

  /**
   * Checks if the party is defeated.
   * A party is considered defeated if:
   *   - The party is empty (no allies)
   *   - All allies have 0 health points (HP)
   * @return True if the party is defeated, False otherwise. */
  def isDefeated(): Boolean = {
    if (buff.isEmpty) {
      // The party is considered defeated if it's empty
      true
    } else {
      // The party is considered defeated if all allies have 0 or less life points
      buff.forall(u => u.getHp <= 0)
    }
  }
}
