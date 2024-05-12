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
  def this(name:String) ={
    this(name,50,80,250,50)
  }


  def wasInjure(pain: Int): Enemy = {
    if (this.life >= pain){
      val Enemy: Enemy = new Enemy(this.name, this.weight, this.attackPoints, this.life - pain, this.defence)
      Enemy
    }
    else {
      val Enemy: Enemy = new Enemy(this.name, this.weight, this.attackPoints, 0, this.defence)
      Enemy

    }
  }

}


