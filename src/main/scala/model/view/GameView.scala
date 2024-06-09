package model.view


import controller.observers._

import scala.io.StdIn
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import model.general.GameUnit
import model.general.party.Party
import model.spell.Spell

class GameView {
  private val queue = new Queue[String].empty

  def getNumericalInput(): Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }

  def displayInitMessage(): Unit = {
    queue.enqueue("Bienvenido al combate!")
  }

  def displayPlayerStart(): Unit = {
    queue.enqueue("Turno del jugador")
  }

  def displayEnemyStart(): Unit = {
    queue.enqueue("Turno del enemigo")
  }

  def displayPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Escoge un aliado:")
    for(i <- allies.buff.indices) {
      queue.enqueue(s"${i+1}) ${allies.buff(i).getName}")
    }
  }


  def displayPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("1) Atacar")
    queue.enqueue("2) Usar Magia")
    queue.enqueue("0) Cambiar de aliado")

  }

  def displayPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Escoge un enemigo:")
    for(i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} PV")
    }
  }

  def displayPlayerUnitSpells(spells: ArrayBuffer[Spell]): Unit = {
    queue.enqueue("Escoge un hechizo:")
    for(i <- spells.indices) {
      queue.enqueue(s"${i+1}) ${spells(i).name} ${spells(i).getCost} EM")
    }
  }

  def displayUnitInfo(gUnit: GameUnit): Unit = {
    queue.enqueue(s"Estado de ${gUnit.getName}")
    queue.enqueue(s"PV: ${gUnit.getHp}")
    queue.enqueue(s"EM: ${gUnit.getMana}")
  }

  def displaySimpleAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} ataca ${dest.getName}")
    queue.enqueue(s"${src.getName} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
  }

  def displaySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} usa ${sp.name} contra ${dest.getName}")
    queue.enqueue(s"${sp.name} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
    queue.enqueue(s"EM de ${src.getName} reducidos a ${src.getMana}")
  }

  def displayVictory(): Unit = {
    queue.enqueue("Felicidades! Ganaste!")
  }

  def displayDefeat(): Unit = {
    queue.enqueue("O no! Perdiste :c")
  }

  def displayErrorNoEnergy(): Unit = {
    queue.enqueue("No tienes suficiente energía maldita")
  }

  def displayErrorInvalidOption(choice: Int): Unit = {
    queue.enqueue(s"Opción inválida ${choice}")
  }

  def render(): Unit = {
    // Usamos algo clásico en el desarrollo de juegos
    // que es acumular el rendering en una cola
    // esto permite poder decidie en que orden
    // hacer cada render, cosa que aqui no es
    // necesario, pero es un buen dato :)

    while (!queue.isEmpty) {
      println(queue.dequeue())
    }
  }

}