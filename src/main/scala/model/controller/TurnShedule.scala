package model.controller

import model.playable.{APlayable, WhiteMagican, Paladin, Playable}

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}


class TurnShedule extends Shedule {
  val actionBar : Map[Playable, (Int,Int)] = Map()
  val turns: Queue[Playable] = Queue()
  def addPlayer(pj:Playable): Unit ={
    val maxActionBar = pj.getWeight
    var cntBar = 0
    actionBar.put(pj,(maxActionBar,cntBar))
  }
  def deletePlayer(pj:Playable): Unit = {
    if(actionBar.contains(pj)) {
      actionBar.remove(pj)
    }
  }
  def resetActionBar(pj:Playable):Unit ={
    actionBar.get(pj).foreach {
      case (maxActionBar,_) =>
    actionBar.update(pj,(maxActionBar,0))
    }
  }

  def fillActionBar(n:Int):Unit = {
    actionBar.keys.foreach { key =>
      val (maxActionBar, cntBar) = actionBar.getOrElse(key, (0, 0))
      val newCntBar = cntBar + n
      actionBar.update(key, (maxActionBar, newCntBar))
      if (newCntBar >= maxActionBar) {
        turns.enqueue(key)
        actionBar.update(key, (maxActionBar, 0))

      }
    }
  }
  // Método para mostrar el estado actual de turnos
  def CanPlay(q:Queue[Playable]): Playable = {
    val Player1: Playable = q.head
    q.removeHead()
    Player1
    }

}



