package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Playable


abstract class AWeapon(name: String, weight: Int,
             attackPoints: Int, owner: Playable) extends NonPlayable{
  /**
   * Implementation of Method to get the name of the non-playable entity
   * @return : The name of Weapon
   */
  def getName: String = name
  /**
   * Implementation of Method to get the weight of the non-playable entity
   * @return The weight of Weapon
   */
  def getWeight: Int = weight
  /**
   * Implementation of Method to get the attack points of the non-playable entity
   * @return The attack points of Weapon
   */
  def getAttack: Int = attackPoints

  /**
   * Implementation of Method to get the weight of the non-playable entity
   * @return The owner of the Weapon
   */
  def getOwner: Playable = owner
  override def equals(other:Any):Boolean = { // override anula la funcion por defecto y me permite escribir una nueva
    if (other.isInstanceOf[NonPlayable]) {
      val otherCast = other.asInstanceOf[NonPlayable]
      getClass() == otherCast.getClass()
    } else false
  }
  }






