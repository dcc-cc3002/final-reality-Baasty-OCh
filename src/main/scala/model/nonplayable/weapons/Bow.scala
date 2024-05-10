package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}


class Bow(name: String, weight: Int,
          attackPoints: Int, owner: Playable,
          magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints){
  def this(owner:Playable) = {
    this("Arco",30,40,owner,0)
  }
  def this() = {
    this("Arco",30,40, new Ninja("Messi"),0)
  }
  override def getMAP: Int = 0
}