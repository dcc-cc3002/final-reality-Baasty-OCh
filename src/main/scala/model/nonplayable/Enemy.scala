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
            defence: Int) extends NonPlayable {
  def this(name:String) ={
    this(name,50,80,250,50)
  }
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
  def wasInjure(pain: Int) = {
    if (this.life >= pain){
      val Enemy: NonPlayable = new Enemy(this.name, this.weight, this.attackPoints, this.life - pain, this.defence)
      Enemy
    }
    else {
      val Enemy: NonPlayable = new Enemy(this.name, this.weight, this.attackPoints, 0, this.defence)
      Enemy

    }
  }


  override def getMAP: Int = 0
}


