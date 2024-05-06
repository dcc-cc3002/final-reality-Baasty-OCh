package model.playable
import model.nonplayable.{AWeapon, Enemy}
import model.playable.Playable

/**
 * An abstract class representing a Playable entity in the game.
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 */
abstract class APlayable(val name: String, var healthPoints: Int,
                         val defensePoints: Int, val weight: Int,
                         val mana: Int) extends Playable {
  var arma: Option[AWeapon] = None

  /**
   * Implementation of Method to get the name of the playable entity
   * @return : The name of playable entity
    */
  def getName: String = name

  /**
   * Implementation of Method to get the health points of the playable entity
    * @return The health points of playable entity
   */
  def getHp: Int = healthPoints

  /**
   * Implementation of Method to get the defense points of the playable entity
   * @return The defense points of playable entity
   */
  def getDp: Int = defensePoints

  /**
   * Implementation of Method to get the weight of the playable entity
   * @return The weight of playable entity
   */
  def getWeight: Int = weight

  /**
   * Implementation of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int = mana

  def haveWeapon = arma

  def putWeapon(a:AWeapon): Unit = {}

  def attackEnemy(e: Enemy): Unit = {}



  override def equals(other:Any):Boolean = { // override anula la funcion por defecto y me permite escribir una nueva
    if (other.isInstanceOf[Playable]) {
      val otherCast = other.asInstanceOf[Playable]
      getClass() == otherCast.getClass()
    } else false
  }



}

