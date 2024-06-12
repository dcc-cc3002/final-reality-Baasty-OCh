package model.view


import controller.observers._

import scala.io.StdIn
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import model.general.GameUnit
import model.general.party.Party
import model.spell.Spell
import model.weapons.Weapon

class GameView {
  private val queue = new Queue[String].empty

  def getNumericalInput(): Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }

  def displayInitMessage(): Unit = {
    queue.enqueue("Bienvenido al combate!")
  }

  def displayPlayerStart(pj: GameUnit): Unit = {
    queue.enqueue(s"Turno del jugador ${pj.getName}")
  }

  def displayTurnStart(): Unit = {
    queue.enqueue("El turno ha comenzado")
  }
  def displayEnemyStart(pj:GameUnit): Unit = {
    queue.enqueue(s"Turno del enemigo: ${pj.getName}")
  }

  def displayPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Estado de los aliados:")
    for(i <- allies.buff.indices) {
      queue.enqueue(s"${i+1}) ${allies.buff(i).getName} || PV: ${allies.buff(i).getHp} " +
        s"|| WT: ${allies.buff(i).getWeight + allies.buff(i).arma.map(_.getWeight).getOrElse(0)}")
    }
  }


  def displayMagicPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("1) Atacar")
    queue.enqueue("2) Usar Magia")
    queue.enqueue("5) Terminar Partida")

  }

  def displayPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("1) Atacar")
    queue.enqueue("5) Terminar Partida")

  }

  def displayPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Escoge un enemigo:")
    queue.enqueue("0) Volver a elegir Arma")
    for(i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} PV || ${enemies.buff(i).getDp} DP " +
        s"|| ${enemies.buff(i).getAttack} AP")
    }
  }

  def displayPlayerUnitSpells(spells: ArrayBuffer[Spell]): Unit = {
    queue.enqueue("Escoge un hechizo:")
    queue.enqueue("0) Volver a elegir Accion")
    for(i <- spells.indices) {
      queue.enqueue(s"${i+1}) ${spells(i).name} ${spells(i).getCost} EM")
    }
  }

  def displayPlayerUnitWeapons(weapons: ArrayBuffer[Weapon]): Unit = {
    queue.enqueue("Escoge un arma:")
    queue.enqueue("0) Volver a elegir acción")
    for(i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName} ${weapons(i).getAttack} AP" +
        s" || ${weapons(i).getWeight} WP ")
    }
  }

  def displayMagicPlayerUnitWeapons(weapons: ArrayBuffer[Weapon]): Unit = {
    queue.enqueue("Escoge un arma:")
    queue.enqueue("0) Volver a elegir acción")
    for(i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName} ${weapons(i).getAttack} AP")
    }
    queue.enqueue("4) Volver a elegir Hechizo")
  }

  def displayUnitInfo(gUnit: GameUnit): Unit = {
    queue.enqueue(s"Estado de ${gUnit.getName}")
    queue.enqueue(s"PV: ${gUnit.getHp}")
    queue.enqueue(s"EM: ${gUnit.getMana}")
    queue.enqueue(s"DP: ${gUnit.getDp}")
  }

  def displaySimpleAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} ataca ${dest.getName}")
    queue.enqueue(s"${src.getName} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
    queue.enqueue(s"DP de ${dest.getName} reducidos a ${dest.getDp}")
    if (dest.getHp == 0){queue.enqueue((s"${dest.getName} : SOY UN PECHO FRIO"))}
    else queue.enqueue("Buen golpe")
  }

  def displaySimpleEnemyAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} ataca ${dest.getName}")
    queue.enqueue(s"${src.getName} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
    queue.enqueue(s"DP de ${dest.getName} reducidos a ${dest.getDp}")
    if (dest.getHp == 0){queue.enqueue((s"${dest.getName} : ES CULPA DE NEGREIRAAAA"))}
    else queue.enqueue("Buen golpe")
  }

  def displaySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} usa ${sp.name} contra ${dest.getName}")
    queue.enqueue(s"${sp.name} realiza su efecto")
    queue.enqueue(s"EM de ${src.getName} reducidos a ${src.getMana}")
  }

  def displayVictory(): Unit = {
    queue.enqueue("Felicidades! Ganaste!")
  }

  def displayDefeat(): Unit = {
    queue.enqueue("Oh no! Perdiste :c")
  }

  def displaySurrender(): Unit = {
    queue.enqueue("Perdiste, COBARDE!!")
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