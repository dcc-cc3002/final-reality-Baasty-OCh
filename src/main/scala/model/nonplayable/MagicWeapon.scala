package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.MagicCharacter

class MagicWeapon extends NonPlayable {
  def sayMana(mana:Int): Int = {
    return mana
  }
  def sayMagicOwner(magicOwner: MagicCharacter): MagicCharacter ={
    return magicOwner
  }

  def sayName(name: String): String = {
    return name
  }

  def sayWeight(weight: Int): Int = {
    return weight
  }

  def sayAttack(attack: Int): Int = {
    return attack
  }



}
