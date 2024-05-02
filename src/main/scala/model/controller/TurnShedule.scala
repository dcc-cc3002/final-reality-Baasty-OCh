package model.controller

import model.playable.Playable
import model.playable.APlayable
import scala.collection.mutable.Map


class TurnShedule extends Shedule {
  var actionBar : Map[Int, Playable] = Map()
  def addPlayable( pj :Playable): Unit = {
    actionBar += (pj -> 0)
  }

  def maxActionBar(): Unit = {

  }









}

