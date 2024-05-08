package model.playable
import model.nonplayable.{AWeapon, Enemy}
import model.playable.Playable

/**
 * An abstract class representing a Playable entity in the game.
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana The mana of the character.
 */
abstract class APlayable(val name: String, var healthPoints: Int,
                         val defensePoints: Int, val weight: Int,
                         val mana: Int) extends Playable {
  /**
   * variable to represent a weapon in an APlayable Entity
   */
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

  /**
   * Implementation of Method to know if a Playable Entity has or not a weapon
   * @return The Weapon of the Character or None
   */
  def haveWeapon = arma

  /**
   * Implementation of Method to equip a Weapon on a Playable Entity
   * @param Any class of Weapon
   */
  def putWeapon(a:AWeapon): Unit = {}

  /**
   * Implementation of Method to attack an Enemy entity
   * @param target
   * @return damage
   */
  def attackEnemy(target: Enemy): Int = {
    val damage = arma.map(_.getAttack - target.getDF).getOrElse(0)
    if (damage >= 0) {
      target.wasInjure(damage)
      damage
    }
    else 0
  }

  /**
   * Implementation of Method to hurt an Playable Entity
   * @param pain
   *  @return a new Playable
   */
  def wasAttacked(pain:Int) : Playable



  override def equals(other:Any):Boolean = { // override anula la funcion por defecto y me permite escribir una nueva
    if (other.isInstanceOf[Playable]) {
      val otherCast = other.asInstanceOf[Playable]
      getClass() == otherCast.getClass()
    } else false
  }



}

