package model.controller

trait GameUnit {
  /**
   * Abstract Method to get the weight of a entity (characters or enemies) in the game.
   * @return weight of players (characters or enemies)
   */
  def getWeight: Int

  def attack(entity: GameUnit): Int

}
