package model.nonplayable
import model.controller.GameUnit
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
  require(weight >=0 && weight<=150)
  require(attackPoints >=0 && attackPoints<=100)
  require(life >=0 && life <=250)
  require(defence >=0 && defence<=200)

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
  private def setLife(newLife:Int) : Unit = {
    this.life = newLife
  }

  /**
   * Method to get defence points of the non-playable entity
   * @return defence of the non-playable entity
   */
  def getDp: Int = defence

  /**
   * Abstract Method to attack an entity
   * @param entity the guy who will be attack by a Playable
   * @return damage
   */
  def attack(entity:GameUnit):Int = {
    entity.wasAttackBy(this)
    val damage : Int = this.attackPoints - entity.getDp
    if (damage >= 0) {
    entity.wasAttacked(damage)
    damage
    } else 0
}





def CanAttackPlayables(player:Playable): Boolean = true
  def CanAttackEnemies(target: Enemy): Boolean = false

  /**
   * Method to simulate the playable entity being attacked.
   * @param pain The amount of damage inflicted on the playable entity.
   */

  def wasAttacked(pain: Int): Unit = {
    if (this.life >= pain){
      this.setLife(this.life-pain)
    }
    else {
      this.setLife(0)
    }
  }

}
