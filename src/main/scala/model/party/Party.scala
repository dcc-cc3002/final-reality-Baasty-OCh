package model.party
import model.playable.{Character, MagicCharacter, Playable}

import scala.collection.mutable.Map
class Party {
  val allies: Map[String, Playable] = Map()

  // Método para añadir un personaje a la party
  def addPlayable(pj: Playable): Unit = {
    allies.put(pj.sayKind(), pj)
  }
  // Método para verificar si la party está derrotada
  def isDefeated: Boolean = if (allies.isEmpty) {
    println("Party Empty")
    true // La party está vacía, por lo tanto se considera derrotada
  } else {
    allies.values.forall(_.sayLife() == 0)
  }


}