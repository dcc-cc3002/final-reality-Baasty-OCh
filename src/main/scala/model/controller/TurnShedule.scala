package model.controller

import model.playable.Playable
import model.playable.APlayable
import scala.collection.mutable.Map


class TurnShedule {
  val actionBar : Map[Playable, (Int,Int)] = Map()
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


}

