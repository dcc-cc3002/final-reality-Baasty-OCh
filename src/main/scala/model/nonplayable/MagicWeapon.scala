package model.nonplayable
import model.nonplayable.Weapon
import model.playable.MagicCharacter

class MagicWeapon extends Weapon {
  def sayMana(mana:Int): Int = {
    return mana
  }
  override def sayOwner(magicOwner : MagicCharacter): MagicCharacter = {
    return magicOwner
  }

}
