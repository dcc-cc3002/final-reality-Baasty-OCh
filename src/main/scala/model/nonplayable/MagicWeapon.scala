package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.MagicCharacter

class MagicWeapon(name:String,weight:Int,
                  attack:Int,mana:Int,
                  owner: MagicCharacter) extends NonPlayable {
  def sayMana(): Int ={
    mana
  }

  def sayName(): String = {
    name
  }

  def sayWeight(): Int = {
    weight
  }

  def sayAttack() : Int = {
    attack
  }
  def sayOwner(): MagicCharacter = {
    owner
  }
}
