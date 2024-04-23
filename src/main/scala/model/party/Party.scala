package model.party

import model.playable.{APlayable, MagicCharacter, Playable}

import scala.collection.mutable.Map

// Party class to manage a group of playable characters
class Party {
  // Map to store the allies in the party, keyed by their kind/type
  val allies: Map[String, Playable] = Map()

  // Method to add a playable character to the party
  def addPlayable(pj: Playable): Unit = {
    allies.put(pj.sayKind(), pj) // Adds the playable character to the allies map with their kind as the key
  }

  // Method to check if the party is defeated
  def isDefeated: Boolean = {
    if (allies.isEmpty) {
      // Print a message if the party is empty
      true // The party is considered defeated if it's empty
    } else {
      // The party is considered defeated if all allies have 0 life points
      allies.values.forall(_.sayLife() == 0)
    }
  }
}
