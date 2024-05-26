package model.nonplayable
import model.general.GameUnit
import model.nonplayable.NonPlayable
import model.playable.Playable

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
            defence: Int) extends AEnemy(name, weight, attackPoints, life, defence) {

  /**
   * "The auxiliary builder receives the name that the user chooses for their non-playable entity
   * and sets the other statistics according to the enemy class."
   * @param name
   * @return Playable
   */

  def this(name:String) ={
    this(name,50,80,250,50)
  }

  /**
   * Implementation method to know if Enemy can be attacked by other particular Game Unit
   * @param entity represents the possible attacker
   * @return true in case Game Unit was enemy of our non-playable entity
   */
  def wasAttackBy(entity:GameUnit): Boolean = entity.CanAttackEnemies()

  /**
   * Checks if this Enemy is equal to another Enemy.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, Name, Weight, Life and DF, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Enemy]) {
      val otherCast = other.asInstanceOf[Enemy]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getLife == otherCast.getLife &&
        getDp == otherCast.getDp )

    } else false
  }

}


