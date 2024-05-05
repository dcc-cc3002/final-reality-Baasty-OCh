package model.nonplayable
import model.nonplayable.NonPlayable

/**
 *
 * @param name
 * @param weight
 * @param attackPoints
 */
abstract class ANonPlayable(val name: String, val weight: Int,
                   val attackPoints: Int) extends NonPlayable {
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
  override def equals(other:Any):Boolean = { // override anula la funcion por defecto y me permite escribir una nueva
    if (other.isInstanceOf[NonPlayable]) {
      val otherCast = other.asInstanceOf[NonPlayable]
      getClass() == otherCast.getClass()
    } else false
  }
}
