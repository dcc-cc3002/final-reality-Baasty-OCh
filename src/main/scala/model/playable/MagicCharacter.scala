package model.playable
import model.playable.Character
class MagicCharacter(name:String, life:Int,
                      defence:Int,weight:Int,
                      kind:String,weapon:Boolean,
                      mana:Int) extends Playable {
  def sayName(): String = {
    name
  }

  def sayLife(): Int = {
    life
  }

  def sayDefence(): Int = {
    defence
  }

  def sayWeight(): Int = {
    weight
  }
  def sayKind():String={kind}

  def havWeapon(): Boolean = {
    weapon
  }

  def sayMana()={
    mana
  }
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Playable]) {
      val otherCast = other.asInstanceOf[MagicCharacter]
      sayName() == otherCast.sayName() &&
        sayKind() == otherCast.sayKind()
    } else false
  }


}
