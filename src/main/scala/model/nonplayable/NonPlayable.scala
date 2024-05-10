package model.nonplayable
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
   * Abstract method to get the defense points of the non-playable entity
   *
   * @return The defense points of the non-playable entity as an integer
   */
  def getDF: Int

  /**
   * Abstract method to get the life points of the non-playable entity
   *
   * @return The life points of the non-playable entity as an integer
   */
  def getLife: Int

  /**
   * Abstract method to get the attack points of the non-playable entity
   *
   * @return The attack points of the non-playable entity as an integer
   */
  def getAttack: Int

  /**
   * Abstract method to get the owner of the non-playable entity
   *
   * @return The owner of the non-playable entity (type should be specified)
   */
  def getOwner: Unit

  /**
   * Abstract method to get the mana points of the non-playable entity
   *
   * @return The mana points of the non-playable entity as an integer
   */
  def getMAP: Int
}

