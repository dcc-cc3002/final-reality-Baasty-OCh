package model.controller

import model.playable.Playable

trait Shedule {
  def addPlayable(pj: Playable): Unit
  def deletePlayable(pj: Playable): Unit
  def maxActionBar(): Unit
  def resetActionBar(): Unit
  def moveActionBar(n:Int): Unit
  def nextPlayable(): Unit

}
