package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Playable

/**
 * @param name
 * @param weight
 * @param attackPoints
 */
protected abstract class ANonPlayable(val name: String, val weight: Int,
                                      val attackPoints: Int, var life: Int,
                                      val defence: Int) extends NonPlayable {
  require(weight >=0)
  require(attackPoints >=0)
  require(life >=0)
  require(defence >=0)
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

  /**
   * Method to get the life points of a non-playable entity
   * @return life of the non-playable entity
   */
  def getLife: Int = life

  /**
   * Implementation of Method to set the life of the non-playable
   * @param newLife represent the new life points of the non-playable entity
   */
  def setLife(newLife:Int) : Unit = {
    this.life = newLife
  }

  /**
   * Method to get defence points of the non-playable entity
   * @return defence of the non-playable entity
   */
  def getDF: Int = defence

  /**
   * Implementation of Method to attack an Enemy entity
   * @param target represent an object of Playable class and is our objective
   * @return damage represent the amount of damage inflicted on the target
   */
  def attackPlayer(target:Playable): Int = {
    val damage : Int = this.attackPoints - target.getDp
    if (damage >= 0) {
      target.wasAttacked(damage)
      damage
    } else 0
  }

  /**
   * Method to simulate the playable entity being attacked.
   * @param pain The amount of damage inflicted on the playable entity.
   */

  def wasInjure(pain: Int): Unit = {
    if (this.life >= pain){
      this.setLife(this.life-pain)
    }
    else {
      this.setLife(0)
    }
  }

}
