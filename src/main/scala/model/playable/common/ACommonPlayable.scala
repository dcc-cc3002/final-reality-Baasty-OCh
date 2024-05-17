package model.playable.common

import model.playable.APlayable

abstract class ACommonPlayable(name:String, healthPoints:Int,
                               defensePoints:Int, weight:Int,
                               ) extends APlayable(name,healthPoints, defensePoints,weight) {


}
