package model.general.party

import exceptions.InvalidAdditionPartyException
import model.general.GameUnit
import model.nonplayable.NonPlayable
import model.playable.Playable

import scala.collection.mutable.{ArrayBuffer, Map}

/**
 * Represents a party of playable characters.
 * This class manages a group of playable characters (allies) that work together as a unit.
 * The party can contain up to three unique playable characters. Each character is stored
 * in a map keyed by their class type, allowing for efficient retrieval and management.
 */
class Party  {

  /**
   * A mutable map to store the allies in the party, keyed by their class (type) for efficient retrieval.
   */
  val buff = ArrayBuffer.empty[GameUnit]

  /**
   * Adds a game unit character to the party.
   * @param pj The game unit to be added.
   */
  def addGameUnit(pj: GameUnit): String = {
    try{
      if (buff.size < 3){
        buff += pj // Adds the playable character to the allies map with their kind as the key
        "The unit was add successfully"
      }
      else throw new InvalidAdditionPartyException
    } catch {
      case _: InvalidAdditionPartyException => "The Party cant add more than 3 players, is full"
    }
  }


  /**
   * Checks if the party is defeated.
   * A party is considered defeated if:
   *   - The party is empty (no allies)
   *   - All allies have 0 health points (HP)
   * @return True if the party is defeated, False otherwise.
   */
  def isDefeated(): Boolean = {
    if (buff.isEmpty) {
      // Print a message if the party is empty
      true // The party is considered defeated if it's empty
    } else {
      // The party is considered defeated if all allies have 0 life points
      buff.forall(u => u.getHp <= 0)
    }
  }
  
}
