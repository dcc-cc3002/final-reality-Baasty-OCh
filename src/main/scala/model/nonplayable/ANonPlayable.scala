package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Playable

/**
 *
 * @param name
 * @param weight
 * @param attackPoints
 */
protected abstract class ANonPlayable(name: String, weight: Int,
                            attackPoints: Int, life: Int,
                            defence: Int) extends NonPlayable {
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
  def getLife: Int = life


  def getDF: Int = defence
  def attackPlayer(target:Playable): Int = {
    val damage : Int = this.attackPoints - target.getDp
    if (damage >= 0) {
      target.wasAttacked(damage)
      damage
    } else 0

  }

}
