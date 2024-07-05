package view

import controller.observers._

import scala.io.StdIn
import scala.collection.mutable.{ArrayBuffer, Queue}
import model.general.GameUnit
import model.general.party.Party
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon

/**
 * The GameView class is responsible for managing the display of game information to the user.
 * It queues messages and renders them to the standard output.
 */
class GameView {
  private val queue = new Queue[String]().empty

  /**
   * Reads a numerical input from the standard input.
   *
   * @return The numerical input as an Int.
   */
  def getNumericalInput(): Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }

  /**
   * Displays the initial welcome message.
   */
  def displayInitMessage(): Unit = {
    queue.enqueue("Bienvenido al combate!")
    queue.enqueue("En el siguiente combate el peso de los personajes (WT)")
    queue.enqueue("es la clave para obtener el turno de participacion, entre menor sea tu peso mas rapido accederas ")
    queue.enqueue("al turno, las armas tienen punto de ataque (AP) y peso (WT), ")
    queue.enqueue("entre mas ataque tenga un arma, mas pesada será, ELIGE CON SABIDURIA")
    queue.enqueue("si un personaje sin arma ataca su daño sera cero 0")
    queue.enqueue("NO todas las armas son seleccionables por todos los personajes, ojo con eso")
    //queue.enqueue("Un arma con dueño NO puede ser ocupada por otro aliado")
    queue.enqueue("Buena suerte! La necesitaras...")



  }

  object ConsoleColors {
    val RED = "\u001b[31m"
    val RESET = "\u001b[0m"
    val GREEN = "\u001b[32m"
    val YELLOW = "\u001b[33m"
  }

  def displayReportMessage(allies:Party, enemies: Party): Unit = {
    queue.enqueue("Estado de la Partida")
    displayPlayerUnits(allies)
    displayEnemiesUnits(enemies)
  }


  def displayMagicReportMessage(allies:Party, enemies: Party): Unit = {
    queue.enqueue("Estado de la Partida")
    displayMagicPlayerUnits(allies)
    displayEnemiesUnits(enemies)
  }

  /**
   * Displays the message indicating the player's turn start.
   *
   * @param pj The player's GameUnit.
   */
  def displayPlayerStart(pj: GameUnit): Unit = {
    queue.enqueue(s"Turno del jugador ${pj.getName}")
  }

  /**
   * Displays the message indicating the start of a turn.
   */
  def displayTurnStart(): Unit = {
    queue.enqueue("El turno ha comenzado")
  }

  /**
   * Displays the message indicating the enemy's turn start.
   *
   * @param pj The enemy's GameUnit.
   */
  def displayEnemyStart(pj: GameUnit): Unit = {
    queue.enqueue(s"Turno del enemigo: ${pj.getName}")
  }

  /**
   * Displays the status of all player units.
   *
   * @param allies The player's party.
   */
  def displayPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Estado de los aliados:")
    for (i <- allies.buff.indices) {
      if (allies.buff(i).getHp == 0){
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${allies.buff(i).getName}" +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else if (allies.buff(i).getHp <= allies.buff(i).maxHp()/2){
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${allies.buff(i).getName} " +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")}
      else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${allies.buff(i).getName} " +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")

      }
    }
  }

  def displayMagicPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Estado de los aliados:")
    for (i <- allies.buff.indices) {
      if (allies.buff(i).getHp == 0){
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${allies.buff(i).getName} " +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else if (allies.buff(i).getHp <= allies.buff(i).maxHp()/2){
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${allies.buff(i).getName} " +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")}
      else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${allies.buff(i).getName} " +
          s" || PV: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")

      }
    }
  }


  /**
   * Displays the status of enemy player units.
   *
   * @param enemies The player's party.
   */
  def displayEnemiesUnits(enemies: Party): Unit = {
    queue.enqueue("Estado de los enemigos:")
    for (i <- enemies.buff.indices) {
      if (enemies.buff(i).getHp == 0){
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${enemies.buff(i).getName} " +
          s" || PV: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status:${"Muerto"}${ConsoleColors.RESET}")
      } else if (enemies.buff(i).getHp <= enemies.buff(i).maxHp()/2){
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${enemies.buff(i).getName} " +
          s" || PV: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status:${enemies.buff(i).getStatus}${ConsoleColors.RESET}")}
      else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${enemies.buff(i).getName} " +
          s" || PV: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status:${enemies.buff(i).getStatus}${ConsoleColors.RESET}")

      }
    }
  }

  /**
   * Displays the available actions for the player including magic options.
   */
  def displayMagicPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("0) Abandonar Partida")
    queue.enqueue("1) Atacar")
    queue.enqueue("2) Atacar con Magia")
    queue.enqueue("3) Cambiar Arma")
    queue.enqueue("4) Cambiar Hechizo")
    }

  /**
   * Displays the available actions for the player.
   */
  def displayPlayerAction(): Unit = {
    queue.enqueue("Escoge una acción:")
    queue.enqueue("0) Abandonar partida")
    queue.enqueue("1) Atacar")
    queue.enqueue("2) Cambiar Arma")


  }

  /**
   * Displays the available enemies to target.
   *
   * @param enemies The enemy party.
   */
  def displayPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Escoge un enemigo:")
    queue.enqueue("0) Volver a elegir Arma")
    for (i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} PV || ${enemies.buff(i).getDp} DP " +
        s"|| ${enemies.buff(i).getAttack} AP")
    }
  }

  def displayMagicPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Escoge un enemigo:")
    queue.enqueue("0) Volver a elegir Arma")
    for (i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} PV || ${enemies.buff(i).getDp} DP " +
        s"|| ${enemies.buff(i).getAttack} AP")
    }
    queue.enqueue("4) Volver a elegir Hechizo")
  }

  /**
   * Displays the spells available for the player's unit.
   *
   * @param spells The spells available to the player's unit.
   */
  def displayPlayerUnitSpells(spells: ArrayBuffer[Spell]): Unit = {
    queue.enqueue("Escoge un hechizo:")
    queue.enqueue("0) Volver a elegir Accion")
    for (i <- spells.indices) {
      queue.enqueue(s"${i+1}) ${spells(i).name} ${spells(i).getCost} MP")
    }
  }

  /**
   * Displays the weapons available for the player's unit.
   *
   * @param weapons The weapons available to the player's unit.
   */
  def displayPlayerUnitWeapons(weapons: ArrayBuffer[Weapon]): Unit = {
    queue.enqueue("WARNING: NO ELIJAS ARMAS NO DISPONIBLES")
    queue.enqueue("Escoge un arma:")
    queue.enqueue("0) Volver a elegir acción")
    for (i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName} ${weapons(i).getAttack} AP" +
        s" || ${weapons(i).getWeight} WP ")
    }
  }

  /**
   * Displays the weapons available for the player's unit during a magic action.
   *
   * @param weapons The weapons available to the player's unit.
   */
  def displayMagicPlayerUnitWeapons(weapons: ArrayBuffer[Weapon]): Unit = {
    queue.enqueue("WARNING: NO ELIJAS ARMAS NO DISPONIBLES")
    queue.enqueue("Escoge un arma:")
    queue.enqueue("0) Volver a elegir acción")
    for (i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName} ${weapons(i).getAttack} AP")
    }
    //queue.enqueue("6) Volver a elegir Hechizo")
  }

  def displayEnemyStatus(gameUnit: GameUnit) = {
    queue.enqueue(s"${gameUnit.getName} esta ${gameUnit.getStatus}")

  }

  def displayHealingTarget(allies: Party) = {
    queue.enqueue("Escoge un aliado:")
    queue.enqueue("0) Volver a elegir Arma")
    for (i <- allies.buff.indices) {
      queue.enqueue(s"${i+1}) ${allies.buff(i).getName} ${allies.buff(i).getHp} PV || ${allies.buff(i).getDp} DP " +
        s"|| ${allies.buff(i).getAttack} AP")
    }


  }

  /**
   * Displays the information of a game unit.
   *
   * @param gUnit The GameUnit whose information is to be displayed.
   */
  def displayUnitInfo(gUnit: GameUnit): Unit = {
    queue.enqueue(s"Estado de ${gUnit.getName}")
    queue.enqueue(s"PV: ${gUnit.getHp}")
    queue.enqueue(s"EM: ${gUnit.getMana}")
    queue.enqueue(s"DP: ${gUnit.getDp}")
  }

  def displayNotifyError(s:String) = {
    s
  }

  /**
   * Displays the result of a simple attack.
   *
   * @param src The attacking GameUnit.
   * @param dest The defending GameUnit.
   * @param amount The amount of damage dealt.
   */
  def displaySimpleAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} ataca ${dest.getName}")
    queue.enqueue(s"${src.getName} usó ${src.arma.get.getClass()} que tiene ${src.arma.get.getAttack} puntos de ataque")
    //queue.enqueue(s"como ${dest.getName} tenia ${dest.getDp + amount} puntos de escudo!")
    queue.enqueue(s"${dest.getName} usa su escudo, recibió ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
    queue.enqueue(s"DP de ${dest.getName} reducidos a ${dest.getDp}")
    if (dest.getHp == 0) queue.enqueue(s"${dest.getName} : SOY UN PECHO FRIO")
    else queue.enqueue("Buen golpe")
  }



  /**
   * Displays the result of a simple enemy attack.
   *
   * @param src The attacking GameUnit.
   * @param dest The defending GameUnit.
   * @param amount The amount of damage dealt.
   */
  def displaySimpleEnemyAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} ataca ${dest.getName}")
    queue.enqueue(s"${src.getName} hizo ${amount} de daño!")
    queue.enqueue(s"PV de ${dest.getName} reducidos a ${dest.getHp}")
    queue.enqueue(s"DP de ${dest.getName} reducidos a ${dest.getDp}")
    if (dest.getHp == 0) queue.enqueue(s"${dest.getName} : ES CULPA DE NEGREIRAAAA")
    else queue.enqueue("Buen golpe")
  }

  /**
   * Displays the result of a spell attack.
   *
   * @param src The attacking GameUnit.
   * @param dest The defending GameUnit.
   * @param sp The spell being used.
   * @param amount The amount of damage dealt.
   */
  def displaySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} usa ${sp.name} contra ${dest.getName}")
    queue.enqueue(s"${sp.name} realiza su efecto")
    queue.enqueue(s"MP de ${src.getName} reducidos a ${src.getMana}")
  }

  /**
   * Displays the victory message.
   */
  def displayVictory(): Unit = {
    queue.enqueue("Felicidades! Ganaste!")
  }

  /**
   * Displays the defeat message.
   */
  def displayDefeat(): Unit = {
    queue.enqueue("Oh no! Perdiste :c")
  }

  /**
   * Displays the surrender message.
   */
  def displaySurrender(coward:GameUnit): Unit = {
    queue.enqueue(s"${coward.getName}  COBARDEEE!!")
    queue.enqueue("TRAICIONASTE A TU ARMADA")

  }

  def displayInvalidWeaponMessage() : Unit = {
    queue.enqueue(" Elegiste un Arma invalida para este personaje, Intentalo de nuevo!")
  }
  def displayInvalidTargetMessage(): Unit = {
    queue.enqueue(" No se puede atacar a un Enemigo Muerto, Intentalo de nuevo!")
  }

  /**
   * Displays the error message for insufficient energy.
   */
  def displayErrorNoEnergy(): Unit = {
    queue.enqueue("No tienes suficiente energía maldita")
  }

  /**
   * Displays the error message for an invalid option.
   *
   * @param choice The invalid choice made by the player.
   */
  def displayErrorInvalidOption(choice: Int): Unit = {
    queue.enqueue(s"Opción inválida ${choice}")
  }

  /**
   * Renders all queued messages to the standard output.
   */
  def render(): Unit = {
    while (queue.nonEmpty) {
      println(queue.dequeue())
    }
  }
}
