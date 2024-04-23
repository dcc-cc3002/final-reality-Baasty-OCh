package model.playable
import model.playable.Playable
class APlayable(name: String, life: Int,
                defence: Int, weight: Int,
                kind: String, weapon: Boolean) extends Playable {

  // Method to return the name of the character
  def sayName(): String = {
    name
  }

  // Method to return the life points of the character
  def sayLife(): Int = {
    life
  }

  // Method to return the defense points of the character
  def sayDefence(): Int = {
    defence
  }

  // Method to return the weight of the character
  def sayWeight(): Int = {
    weight
  }

  // Method to return the kind/type of the character
  def sayKind(): String = {
    kind
  }

  // Method to check if the character has a weapon
  def havWeapon(): Boolean = {
    weapon
  }


}
