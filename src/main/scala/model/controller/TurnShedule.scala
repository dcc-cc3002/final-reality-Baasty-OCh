package model.controller

import model.playable.Playable
import model.playable.APlayable

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}


class TurnShedule {
  val actionBar : Map[Playable, (Int,Int)] = Map()
  val turnos: Queue[Playable] = Queue()
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
    actionBar.get(pj) match {
      case Some((maxActionBar,_)) =>
    actionBar.update(pj,(maxActionBar,0))
    }
  }

  def fillActionBar(n:Int):Unit = {
    actionBar.keys.foreach {key =>
      actionBar.get(key) match {
        case Some((maxActionBar,cntBar)) =>
          val newCntBar = cntBar + n
          actionBar.update(key,(maxActionBar,newCntBar))
          if (newCntBar == maxActionBa) {
            turnos.enqueue(key)
            resetActionBar(key)
          }
      }
    }
  }

}

