package model.nonplayable
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
            defence: Int) extends ANonPlayable(name, weight, attackPoints, life, defence) {

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
        getDF == otherCast.getDF )

    } else false
  }

}


