package model.playable
import model.nonplayable.weapons.AWeapon
import model.playable.APlayable

class Ninja(name:String, healthPoints: Int,
            defensePoints: Int, weight: Int,
            mana: Int) extends APlayable(name, healthPoints, defensePoints, weight, mana){
  def this(name:String) = {
    this(name,80,70,30,0)
  }

  override def setMana(m:Int) : Unit = {}
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Ninja]) {
      val otherCast = other.asInstanceOf[Ninja]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }

}
