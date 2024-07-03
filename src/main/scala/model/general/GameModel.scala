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

  val _weapons = ArrayBuffer.empty[Weapon]
  private val Arco: Weapon = new Bow()
  private val Espada: Weapon = new Sword()
  private val Hacha: Weapon = new Axe()
  private val Baston: Weapon = new Staff()
  private val Varita: Weapon = new Wand()
  def weapons(): ArrayBuffer[Weapon] = _weapons.clone()

  def addWeapon(weapon: Option[Weapon]): Unit = _weapons += weapon.get

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
  //def weapons: ArrayBuffer[Weapon] = _weapons


  /**
   * Initializes the game model by creating and registering ally and enemy units.
   * @param controller The game controller used to register units. */
  def init(controller: GameController): Unit = {
    val Cristiano: Playable = new Warrior("Cristiano")
    val Vini: Playable = new WhiteMagican("Vinicius")
    val Zidane: Playable = new BlackMagican("Zidane",300,100,5,100)
    val Modric: Playable = new Ninja("Modric")
    controller.registerAllyUnit(Cristiano)
    controller.registerAllyUnit(Vini)
    //controller.registerAllyUnit(Modric)
    controller.registerAllyUnit(Zidane)

    val Messi: NonPlayable = new Enemy("Messi")
    val Guardiola: NonPlayable = new Enemy("Guardiola")
    val Laporta: NonPlayable = new Enemy("Laporta")
    controller.registerEnemyUnit(Messi)
    controller.registerEnemyUnit(Guardiola)
    controller.registerEnemyUnit(Laporta)

    //val Arco: Weapon = new Bow()
    //val Espada: Weapon = new Sword()
    //val Hacha: Weapon = new Axe()
    //val Baston: Weapon = new Staff()
    //val Varita: Weapon = new Wand()
    controller.registerWeapon(Arco)
    controller.registerWeapon(Espada)
    controller.registerWeapon(Hacha)
    controller.registerWeapon(Baston)
    controller.registerWeapon(Varita)
  }
}
