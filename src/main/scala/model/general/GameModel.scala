package model.general


import model.general.GameUnit
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.nonplayable.Enemy
import model.spell.Spell

import scala.collection.mutable.ArrayBuffer
import controller.GameController
import model.general.party.Party
import model.view.GameView

class GameModel {
  private val _allies = new Party()
  private val _enemies = new Party()

  def init(controller: GameController): Unit = {
    val Cristiano = new Paladin("Cristiano",1,1,1)
    val Vini = new Ninja("Vinicius",10,10,10)
    val Zidane = new WhiteMagican("Zidane",1,1,1,100)
    controller.registerUnit(Cristiano)
    controller.registerUnit(Zidane)
    _allies.addGameUnit(Cristiano)
    _allies.addGameUnit(Vini)
    _allies.addGameUnit(Zidane)



    val Messi = new Enemy("Messi",20,100,1,1)
    val Guardiola = new Enemy("Guardiola",1,1,1,1)
    controller.registerUnit(Messi)
    controller.registerUnit(Guardiola)
    _enemies.addGameUnit(Messi)
    _enemies.addGameUnit(Guardiola)
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
