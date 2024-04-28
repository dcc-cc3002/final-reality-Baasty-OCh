package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Playable


abstract class AWeapon(name: String, weight: Int,
             attackPoints: Int, owner: Playable) extends NonPlayable{
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
  }






