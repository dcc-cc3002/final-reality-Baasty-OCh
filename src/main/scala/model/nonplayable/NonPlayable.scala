package model.nonplayable

import model.playable.Playable

// Trait to represent non-playable entities
trait NonPlayable {
  /**
   * Abstract method to get the name of the non-playable entity
   *
   * @return The name of the non-playable entity as a String
   */
  def getName: String

  /**
   * Abstract method to get the weight of the non-playable entity
   *
   * @return The weight of the non-playable entity as an integer
   */
  def getWeight: Int


  /**
   * Abstract method to get the attack points of the non-playable entity
   *
   * @return The attack points of the non-playable entity as an integer
   */
  def getAttack: Int

}

