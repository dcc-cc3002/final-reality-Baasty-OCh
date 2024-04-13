package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.MagicCharacter

// MagicWeapon class represents a non-playable entity that is a magic weapon
class MagicWeapon(name: String, weight: Int,
                  attack: Int, mana: Int,
                  owner: MagicCharacter) extends NonPlayable {

  // Method to return the mana points required to use the magic weapon
  def sayMana(): Int ={
    mana
  }

  // Method to return the name of the magic weapon
  def sayName(): String = {
    name
  }

  // Method to return the weight of the magic weapon
  def sayWeight(): Int = {
    weight
  }

  // Method to return the attack power of the magic weapon
  def sayAttack(): Int = {
    attack
  }

  // Method to return the owner character of the magic weapon
  def sayOwner(): MagicCharacter = {
    owner
  }
}

