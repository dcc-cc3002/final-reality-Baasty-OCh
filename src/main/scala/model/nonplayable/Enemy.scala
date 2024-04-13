package model.nonplayable
import model.nonplayable.NonPlayable

// Enemy class represents a non-playable entity that is an enemy
class Enemy(name: String, weight: Int,
            attack: Int, life: Int,
            defence: Int) extends NonPlayable {

  // Method to return the name of the enemy
  def sayName(): String = {
    name
  }

  // Method to return the weight of the enemy
  def sayWeight(): Int = {
    weight
  }

  // Method to return the attack power of the enemy
  def sayAttack(): Int = {
    attack
  }

  // Method to return the life points of the enemy
  def sayLife(): Int = {
    life
  }

  // Method to return the defence points of the enemy
  def sayDefence(): Int = {
    defence
  }
}
