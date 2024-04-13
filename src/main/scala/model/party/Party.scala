package model.party
import model.playable.{Character, MagicCharacter, Playable}

import scala.collection.mutable.Map
class Party {
  val allies: Map[String, Playable] = Map()

  // Método para añadir un personaje a la party
  def addPlayable(character: Playable): Unit = {
    allies.put(character.sayKind(), character)
  }
  }