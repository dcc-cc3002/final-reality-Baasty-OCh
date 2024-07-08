package model.general

import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.nonplayable.{Enemy, NonPlayable}
import controller.GameController
import model.general.party.Party
import model.general.schedule.TurnSchedule
import model.playable.Playable
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

import scala.collection.mutable.ArrayBuffer

/**
 * Represents the model for the game, managing allies, enemies, and participants.
 */
class GameModel {

  /** The party of allied units. */
  private val _allies = new Party()

  /** The party of enemy units. */
  private val _enemies = new Party()

  /** The schedule of participants' turns. */
  private val _participants = new TurnSchedule()

  /** ArrayBuffer to store weapons in the game model. */
  val _weapons = ArrayBuffer.empty[Weapon]

  // Define instances of each type of weapon
  private val Arco: Weapon = new Bow()
  private val Espada: Weapon = new Sword()
  private val Hacha: Weapon = new Axe()
  private val Baston: Weapon = new Staff()
  private val Varita: Weapon = new Wand()

  /**
   * Adds a weapon to the game model.
   * @param weapon The weapon to add.
   */
  def addWeapon(weapon: Option[Weapon]): Unit = _weapons += weapon.get

  /**
   * Retrieves the party of allied units.
   * @return The party of allied units.
   */
  def allies: Party = _allies

  /**
   * Retrieves the party of enemy units.
   * @return The party of enemy units.
   */
  def enemies: Party = _enemies

  /**
   * Retrieves the schedule of participants' turns.
   * @return The schedule of participants' turns.
   */
  def participants: TurnSchedule = _participants

  /**
   * Initializes the game model by creating and registering ally and enemy units.
   * @param controller The game controller used to register units.
   */
  def init(controller: GameController): Unit = {
    // Create and register ally units
    val Cristiano: Playable = new Warrior("Cristiano",350,100,20)
    val Vini: Playable = new WhiteMagican("Vinicius",150,150,15,50)
    val Zidane: Playable = new BlackMagican("Zidane", 300, 100, 10, 100)
    val Modric: Playable = new Ninja("Modric")
    controller.registerAllyUnit(Cristiano)
    controller.registerAllyUnit(Vini)
    //controller.registerAllyUnit(Modric)
    controller.registerAllyUnit(Zidane)

    // Create and register enemy units
    val Messi: NonPlayable = new Enemy("Messi", 250, 50, 55, 30, "Healthy")
    val Guardiola: NonPlayable = new Enemy("Guardiola",150,150,65,40,"Healthy")
    val Laporta: NonPlayable = new Enemy("Laporta",300,50,100,100,"Healthy")
    controller.registerEnemyUnit(Messi)
    controller.registerEnemyUnit(Guardiola)
    controller.registerEnemyUnit(Laporta)

    // Register weapons
    controller.registerWeapon(Arco)
    controller.registerWeapon(Espada)
    controller.registerWeapon(Hacha)
    controller.registerWeapon(Baston)
    controller.registerWeapon(Varita)
  }
}
