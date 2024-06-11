package model.general


import model.general.GameUnit
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.nonplayable.Enemy
import model.spell.Spell

import scala.collection.mutable.ArrayBuffer
import controller.GameController
import model.general.party.Party
import model.general.schedule.TurnSchedule
import model.view.GameView

class GameModel {
  private val _allies = new Party()
  private val _enemies = new Party()
  val _participantes = new TurnSchedule()

  def init(controller: GameController): Unit = {
    val Cristiano = new Paladin("Cristiano",100,40,1)
    val Vini = new Warrior("Vinicius",80,25,1)
    val Zidane = new WhiteMagican("Zidane",150,50,70,25)
    controller.registerUnit(Cristiano)
    controller.registerUnit(Vini)
    controller.registerUnit(Zidane)
    _participantes.addPlayer(Cristiano)
    _participantes.addPlayer(Vini)
    _participantes.addPlayer(Zidane)

    _allies.addGameUnit(Cristiano)
    _allies.addGameUnit(Vini)
    _allies.addGameUnit(Zidane)

    val Messi = new Enemy("Messi",250,50,50,50)
    val Guardiola = new Enemy("Guardiola",200,25,55,50)
    val Laporta = new Enemy("Laporta") // 60 peso
    controller.registerUnit(Messi)
    controller.registerUnit(Guardiola)
    controller.registerUnit(Laporta)
    _participantes.addPlayer(Messi)
    _participantes.addPlayer(Guardiola)
    _participantes.addPlayer(Laporta)

    _enemies.addGameUnit(Messi)
    _enemies.addGameUnit(Guardiola)
    _enemies.addGameUnit(Laporta)
  }



  def allies: Party = _allies

  def enemies: Party = _enemies
  /*
    def enemiesAlive(): Boolean = {
      var alive = false
      for (u <- enemies) {
        alive ||= u.isAlive()
      }
      alive
    }

    def alliesAlive(): Boolean = {
      var alive = false
      for (u <- allies) {
        alive ||= u.isAlive()
      }
      alive
    }
  */
}
