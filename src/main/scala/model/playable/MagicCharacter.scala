package model.playable
import model.playable.APlayable

// MagicCharacter class extends the Playable trait
class MagicCharacter(name: String, life: Int,
                     defence: Int, weight: Int,
                     kind: String, weapon: Boolean,
                     mana: Int) extends Playable {

  // Method to return the name of the magic character
  def sayName(): String = {
    name
  }

  // Method to return the life points of the magic character
  def sayLife(): Int = {
    life
  }

  // Method to return the defense points of the magic character
  def sayDefence(): Int = {
    defence
  }

  // Method to return the weight of the magic character
  def sayWeight(): Int = {
    weight
  }

  // Method to return the kind/type of the magic character
  def sayKind(): String = {
    kind
  }

  // Method to check if the magic character has a weapon
  def havWeapon(): Boolean = {
    weapon
  }

  // Method to return the mana points of the magic character
  def sayMana(): Int = {
    mana
  }

  // Override equals method to compare two magic characters based on their name and kind
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Playable]) {
      val otherCast = other.asInstanceOf[MagicCharacter]
      sayName() == otherCast.sayName() && sayKind() == otherCast.sayKind()
    } else false
  }
}
