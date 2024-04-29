package model.nonplayable
import model.nonplayable.NonPlayable

/**
 * "An enemy is a type of non-playable character that represents the adversary
 *  or adversaries to be defeated by the group of players."
 * @param name
 * @param weight
 * @param attack
 * @param life
 * @param defence
 */
class Enemy(name: String, weight: Int,
            attackPoints: Int, life: Int,
            defence: Int) extends NonPlayable {
  def this(name:String) ={
    this(name,50,50,250,50)
  }
  /**
   * Implementation of Method to get the name of the non-playable entity
   * @return : The name of non-playable entity
   */
  def getName: String = name
  /**
   * Implementation of Method to get the weight of the non-playable entity
   * @return The weight of non-playable entity
   */
  def getWeight: Int = weight
  /**
   * Implementation of Method to get the attack points of the non-playable entity
   * @return The attack points of non-playable entity
   */
  def getAttack: Int = attackPoints

  override def getOwner: String  = {"The Game"}
  override def getMAP: Int = 0
}


