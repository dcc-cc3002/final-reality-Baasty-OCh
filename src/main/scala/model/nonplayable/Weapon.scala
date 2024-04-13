package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Character

// Weapon class represents a non-playable entity that is a weapon
class Weapon(name: String, weight: Int,
             attack: Int, owner: Character) extends NonPlayable {

  // Method to return the owner character of the weapon
  def sayOwner(): Character = {
    owner
  }

  // Method to return the name of the weapon
  def sayName(): String = {
    name
  }

  // Method to return the weight of the weapon
  def sayWeight(): Int = {
    weight
  }

  // Method to return the attack power of the weapon
  def sayAttack(): Int = {
    attack
  }
}
