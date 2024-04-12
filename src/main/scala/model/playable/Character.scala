package model.playable
import model.playable.Playable

class Character(name:String, life:Int,
                defence:Int,weight:Int,
                kind:String,weapon:Boolean) extends Playable {
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

  def sayKind(): String = {
    kind
  }

  def havWeapon(): Boolean = {
    weapon}

  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Playable]) {
      val otherCast = other.asInstanceOf[Character]
      sayName() == otherCast.sayName() &&
        sayKind() == otherCast.sayKind()
    } else false
  }
}



