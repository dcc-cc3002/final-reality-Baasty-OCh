package model.playable.magic

import model.playable.APlayable

abstract class AMagicPlayable(name:String, healthPoints:Int,
                              defensePoints:Int, weight:Int,
                              mana:Int) extends APlayable(name,healthPoints, defensePoints,weight) {
  private var Mana: Int = mana
  /**
   * Implementation of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int = Mana

  /**
   * Implementation of Method to set the mana points of the playable entity
   * @param newMana represent the new mana points of the playable entity
   */
  def setMana(newMana:Int): Unit = {
    this.Mana = newMana
  }


}
