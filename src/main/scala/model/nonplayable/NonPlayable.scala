package model.nonplayable

// Trait to represent non-playable entities
trait NonPlayable {
  /**
   * Abstract method to get the name of the non-playable entity
   */
  def getName: String
  /**
   * Abstract method to get the Weight of the non-playable entity
   */
  def getWeight: Int
  def getDF: Int
  def getlife: Int

  /**
   * Abstract method to get the Attack Points of the non-playable entity
   */
  def getAttack: Int
  def getOwner: {}
  def getMAP: Int
}

