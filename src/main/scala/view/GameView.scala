package view



import scala.io.StdIn
import scala.collection.mutable.{ArrayBuffer, Queue}
import model.general.GameUnit
import model.general.party.Party
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
    queue.enqueue("Welcome to the battle!")
    queue.enqueue("In the upcoming battle, the weight of the characters (WT)")
    queue.enqueue("is the key to obtaining the turn of participation. The lighter you are, the faster you will access")
    queue.enqueue("the turn. Weapons have attack points (AP) and weight (WT).")
    queue.enqueue("The higher the attack, the heavier the weapon. CHOOSE WISELY")
    queue.enqueue("If a character attacks without a weapon, their damage will be zero (0).")
    queue.enqueue("NOT all weapons can be selected by all characters, keep that in mind.")
    //queue.enqueue("An owned weapon CANNOT be used by another ally.")
    queue.enqueue("Good luck! You'll need it...")
  }


  object ConsoleColors {
    val RED = "\u001b[31m"
    val RESET = "\u001b[0m"
    val GREEN = "\u001b[32m"
    val YELLOW = "\u001b[33m"
  }
  /**
   * Displays the report message showing the status of allies and enemies.
   *
   * @param allies The player's party.
   * @param enemies The enemy party.
   */
  def displayReportMessage(allies: Party, enemies: Party): Unit = {
    queue.enqueue("Match Status")
    displayPlayerUnits(allies)
    displayEnemiesUnits(enemies)
  }

  /**
   * Displays the magic report message showing the status of allies and enemies.
   *
   * @param allies The player's party.
   * @param enemies The enemy party.
   */
  def displayMagicReportMessage(allies: Party, enemies: Party): Unit = {
    queue.enqueue("Match Status")
    displayMagicPlayerUnits(allies)
    displayEnemiesUnits(enemies)
  }

  /**
   * Displays the message indicating the player's turn start.
   *
   * @param pj The player's GameUnit.
   */
  def displayPlayerStart(pj: GameUnit): Unit = {
    queue.enqueue(s"Player's turn: ${pj.getName}")
  }

  /**
   * Displays the message indicating the enemy's turn start.
   *
   * @param pj The enemy's GameUnit.
   */
  def displayEnemyStart(pj: GameUnit): Unit = {
    queue.enqueue(s"Enemy's turn: ${pj.getName}")
  }

  /**
   * Displays the status of all player units.
   *
   * @param allies The player's party.
   */
  def displayPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Status of allies:")
    for (i <- allies.buff.indices) {
      if (allies.buff(i).getHp == 0) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else if (allies.buff(i).getHp <= allies.buff(i).maxHp() / 2) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      }
    }
  }

  /**
   * Displays the status of all player units with magic attributes.
   *
   * @param allies The player's party.
   */
  def displayMagicPlayerUnits(allies: Party): Unit = {
    queue.enqueue("Status of allies:")
    for (i <- allies.buff.indices) {
      if (allies.buff(i).getHp == 0) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Spell: ${allies.buff(i).hasSpell().map(_.getName).getOrElse("None")}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else if (allies.buff(i).getHp <= allies.buff(i).maxHp() / 2) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Spell: ${allies.buff(i).hasSpell().map(_.getName).getOrElse("None")}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      } else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${allies.buff(i).getName} " +
          s" || HP: ${allies.buff(i).getHp} " +
          s" || DP: ${allies.buff(i).getDp}" +
          s" || WT: ${allies.buff(i).getWeight}" +
          s" || AP: ${allies.buff(i).getAttack}" +
          s" || MP: ${allies.buff(i).getMana}" +
          s" || Spell: ${allies.buff(i).hasSpell().map(_.getName).getOrElse("None")}" +
          s" || Weapon: ${allies.buff(i).hasWeapon.map(_.getName).getOrElse("None")}${ConsoleColors.RESET}")
      }
    }
  }

  /**
   * Displays the status of enemy player units.
   *
   * @param enemies The enemy's party.
   */
  def displayEnemiesUnits(enemies: Party): Unit = {
    queue.enqueue("Status of enemies:")
    for (i <- enemies.buff.indices) {
      if (enemies.buff(i).getHp == 0) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.RED}${enemies.buff(i).getName} " +
          s" || HP: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status: ${"Dead"}${ConsoleColors.RESET}")
      } else if (enemies.buff(i).getHp <= enemies.buff(i).maxHp() / 2) {
        queue.enqueue(s"${i+1}) ${ConsoleColors.YELLOW}${enemies.buff(i).getName} " +
          s" || HP: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status: ${enemies.buff(i).getStatus}${ConsoleColors.RESET}")
      } else {
        queue.enqueue(s"${i+1}) ${ConsoleColors.GREEN}${enemies.buff(i).getName} " +
          s" || HP: ${enemies.buff(i).getHp} " +
          s" || DP: ${enemies.buff(i).getDp}" +
          s" || WT: ${enemies.buff(i).getWeight}" +
          s" || AP: ${enemies.buff(i).getAttack}" +
          s" || Status: ${enemies.buff(i).getStatus}${ConsoleColors.RESET}")
      }
    }
  }

  /**
   * Displays the available actions for the player including magic options.
   */
  def displayMagicPlayerAction(): Unit = {
    queue.enqueue("Choose an action:")
    queue.enqueue("0) Abandon Game")
    queue.enqueue("1) Attack")
    queue.enqueue("2) Attack with Magic")
    queue.enqueue("3) Change Weapon")
    queue.enqueue("4) Change Spell")
  }

  /**
   * Displays the available actions for the player.
   */
  def displayPlayerAction(): Unit = {
    queue.enqueue("Choose an action:")
    queue.enqueue("0) Abandon Game")
    queue.enqueue("1) Attack")
    queue.enqueue("2) Change Weapon")
  }
  /**
   * Displays the available enemies to target.
   *
   * @param enemies The enemy party.
   */
  def displayPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Choose an enemy:")
    queue.enqueue("0) Choose Weapon Again")
    for (i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} HP || ${enemies.buff(i).getDp} DP " +
        s"|| ${enemies.buff(i).getAttack} AP")
    }
  }

  /**
   * Displays the magic available enemies to target.
   *
   * @param enemies The enemy party.
   */
  def displayMagicPlayerTarget(enemies: Party): Unit = {
    queue.enqueue("Choose an enemy:")
    for (i <- enemies.buff.indices) {
      queue.enqueue(s"${i+1}) ${enemies.buff(i).getName} ${enemies.buff(i).getHp} HP || ${enemies.buff(i).getDp} DP " +
        s"|| ${enemies.buff(i).getAttack} AP")
    }
    queue.enqueue("4) Choose Spell Again")
  }

  /**
   * Displays the spells available for the player's unit.
   *
   * @param spells The spells available to the player's unit.
   */
  def displayPlayerUnitSpells(spells: ArrayBuffer[Spell]): Unit = {
    queue.enqueue("Choose a spell:")
    queue.enqueue("0) Choose Action Again")
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
    queue.enqueue("WARNING: DO NOT CHOOSE UNAVAILABLE WEAPONS")
    queue.enqueue("Choose a weapon:")
    queue.enqueue("0) Choose action again")
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
    queue.enqueue("WARNING: DO NOT CHOOSE UNAVAILABLE WEAPONS")
    queue.enqueue("Choose a weapon:")
    queue.enqueue("0) Choose action again")
    for (i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName} ${weapons(i).getAttack} AP")
    }
    //queue.enqueue("6) Choose Spell Again")
  }

  /**
   * Displays the status of an enemy.
   *
   * @param gameUnit The enemy unit.
   */
  def displayEnemyStatus(gameUnit: GameUnit): Unit = {
    queue.enqueue(s"${gameUnit.getName} is ${gameUnit.getStatus}")
  }

  /**
   * Displays the healing targets available for selection.
   *
   * @param allies The ally party.
   */
  def displayHealingTarget(allies: Party): Unit = {
    queue.enqueue("Choose an ally:")
    queue.enqueue("0) Choose Weapon Again")
    for (i <- allies.buff.indices) {
      queue.enqueue(s"${i+1}) ${allies.buff(i).getName} ${allies.buff(i).getHp} HP || ${allies.buff(i).getDp} DP " +
        s"|| ${allies.buff(i).getAttack} AP")
    }
  }

  /**
   * Displays the information of a game unit.
   *
   * @param gUnit The GameUnit whose information is to be displayed.
   */
  def displayUnitInfo(gUnit: GameUnit): Unit = {
    queue.enqueue(s"Status of ${gUnit.getName}")
    queue.enqueue(s"HP: ${gUnit.getHp}")
    queue.enqueue(s"MP: ${gUnit.getMana}")
    queue.enqueue(s"DP: ${gUnit.getDp}")
  }

  /**
   * Displays an error notification message.
   *
   * @param s The error message to be displayed.
   */
  def displayNotifyError(s: String): String = {
    s // No modification needed for the message itself
  }

  /**
   * Displays the result of a simple attack.
   *
   * @param src The attacking GameUnit.
   * @param dest The defending GameUnit.
   * @param amount The amount of damage dealt.
   */
  def displaySimpleAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} attacks ${dest.getName}")
    queue.enqueue(s"${src.getName} used ${src.arma.get.getName} which has ${src.arma.get.getAttack} attack points")
    queue.enqueue(s"${dest.getName} uses its shield, received ${amount} damage!")
    queue.enqueue(s"${dest.getName}'s HP reduced to ${dest.getHp}")
    queue.enqueue(s"${dest.getName}'s DP reduced to ${dest.getDp}")
    if (dest.getHp == 0) queue.enqueue(s"${dest.getName}: I AM A COLD BREATH")
    else queue.enqueue("Good hit")
  }

  /**
   * Displays the result of a simple enemy attack.
   *
   * @param src The attacking GameUnit.
   * @param dest The defending GameUnit.
   * @param amount The amount of damage dealt.
   */
  def displaySimpleEnemyAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    queue.enqueue(s"${src.getName} attacks ${dest.getName}")
    queue.enqueue(s"${dest.getName} uses its shield, received ${amount} damage!")
    queue.enqueue(s"${dest.getName}'s HP reduced to ${dest.getHp}")
    queue.enqueue(s"${dest.getName}'s DP reduced to ${dest.getDp}")
    if (dest.getHp == 0) queue.enqueue(s"${dest.getName}: IT'S NEGREIRAAAA'S FAULT")
    else {}
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
    queue.enqueue(s"${src.getName} uses ${sp.name} on ${dest.getName}")
    queue.enqueue(s"${sp.name} takes effect")
    queue.enqueue(s"${src.getName}'s MP reduced to ${src.getMana}")
  }

  /**
   * Displays the victory message.
   */
  def displayVictory(): Unit = {
    queue.enqueue("YES! You won!")
  }

  /**
   * Displays the defeat message.
   */
  def displayDefeat(): Unit = {
    queue.enqueue("You lost!")
  }

  /**
   * Displays the surrender message.
   *
   * @param coward The unit surrendering.
   */
  def displaySurrender(coward: GameUnit): Unit = {
    queue.enqueue(s"${coward.getName} COWARD!!")
    queue.enqueue("YOU BETRAYED YOUR ARMY")
  }

  /**
   * Displays the message for choosing an invalid weapon.
   */
  def displayInvalidWeaponMessage(): Unit = {
    queue.enqueue("You chose an invalid weapon for this character. Try again!")
  }

  /**
   * Displays the message for targeting an invalid enemy.
   */
  def displayInvalidTargetMessage(): Unit = {
    queue.enqueue("You cannot attack a dead enemy. Try again!")
  }

  /**
   * Displays the message for choosing an invalid spell.
   */
  def displayInvalidSpellMessage(): Unit = {
    queue.enqueue("You chose an invalid spell for this character. Try again!")
  }

  /**
   * Displays the error message for insufficient energy.
   */
  def displayErrorNoEnergy(): Unit = {
    queue.enqueue("You don't have enough damn energy")
  }

  /**
   * Displays the error message for an invalid option.
   *
   * @param choice The invalid choice made by the player.
   */
  def displayErrorInvalidOption(choice: Int): Unit = {
    queue.enqueue(s"Invalid option ${choice}")
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
