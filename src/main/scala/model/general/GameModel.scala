package model.general

import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.nonplayable.{Enemy, NonPlayable}
import controller.GameController
import model.general.party.Party
import model.general.schedule.TurnSchedule
import model.playable.Playable

/**
 * Represents the model for the game, managing allies, enemies, and participants. */
class GameModel {

  /**
   * The party of allied units. */
  private val _allies = new Party()

  /**
   * The party of enemy units. */
  private val _enemies = new Party()

  /**
   * The schedule of participants' turns. */
  private val _participants = new TurnSchedule()

  /**
   * Gets the party of allies.
   * @return The party of allied units. */
  def allies: Party = _allies

  /**
   * Gets the party of enemies.
   * @return The party of enemy units. */
  def enemies: Party = _enemies

  /**
   * Gets the schedule of participants' turns.
   * @return The schedule of participants' turns. */
  def participants: TurnSchedule = _participants

  /**
   * Initializes the game model by creating and registering ally and enemy units.
   * @param controller The game controller used to register units. */
  def init(controller: GameController): Unit = {
    val Cristiano: Playable = new Paladin("Cristiano", 100, 40, 10)
    val Vini: Playable = new Warrior("Vinicius", 80, 25, 5)
    val Zidane: Playable = new WhiteMagican("Zidane", 150, 50, 7, 25)
    controller.registerAllyUnit(Cristiano)
    controller.registerAllyUnit(Vini)
    controller.registerAllyUnit(Zidane)

    val Messi: NonPlayable = new Enemy("Messi", 250, 50, 55, 20)
    val Guardiola: NonPlayable = new Enemy("Guardiola", 200, 25, 45, 30)
    val Laporta: NonPlayable = new Enemy("Laporta", 250, 100, 3, 100)
    controller.registerEnemyUnit(Messi)
    controller.registerEnemyUnit(Guardiola)
    controller.registerEnemyUnit(Laporta)
  }
}
