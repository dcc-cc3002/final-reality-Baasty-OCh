package model.party

import model.playable.{Playable}

import scala.collection.mutable.Map


/**
 * Represents a party of playable characters.
 */
class Party  {

  /**
   * A mutable map to store the allies in the party, keyed by their class (type) for efficient retrieval.
   */
  val allies: Map[Class[ _<: Playable], Playable] = Map()

  /**
   * Adds a playable character to the party.
   * @param pj The playable character to be added.
   */
  def addPlayable(pj: Playable): Unit = {
    allies.put(pj.getClass, pj) // Adds the playable character to the allies map with their kind as the key
  }

  /**
   * Checks if the party is defeated.
   * A party is considered defeated if:
   *   - The party is empty (no allies)
   *   - All allies have 0 health points (HP)
   * @return True if the party is defeated, False otherwise.
   */
  def isDefeated(): Boolean = {
    if (allies.isEmpty) {
      // Print a message if the party is empty
      true // The party is considered defeated if it's empty
    } else {
      // The party is considered defeated if all allies have 0 life points
      allies.values.forall(_.getHp == 0)
    }
  }
}
