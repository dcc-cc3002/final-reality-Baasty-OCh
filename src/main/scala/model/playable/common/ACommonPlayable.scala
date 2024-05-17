package model.playable.common

import model.playable.APlayable

/**
 * Abstract class to made a group of common characters
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
abstract class ACommonPlayable(name:String, healthPoints:Int,
                               defensePoints:Int, weight:Int,
                               ) extends APlayable(name,healthPoints, defensePoints,weight) {


}
