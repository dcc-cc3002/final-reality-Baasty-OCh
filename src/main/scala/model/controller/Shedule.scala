package model.controller

import model.playable.Playable

trait Shedule {
  def addPlayer(pj:Playable): Unit
  def deletePlayer(pj:Playable): Unit
  def resetActionBar(pj:Playable): Unit
  def fillActionBar(n: Int): Unit
  def showTurns(): Unit

}
