package model.nonplayable
import model.nonplayable.NonPlayable

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
            attack: Int, life: Int,
            defence: Int) extends ANonPlayable(name,weight,attack) {
  def this(name:String) ={
    this(name,50,50,250,50)
  }

}
