package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

class Sword(name: String, weight: Int,
            attackPoints: Int, owner: Playable,
            magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints: Int){
  def this(owner:Playable) = {
    this("Espada",70,70,owner,0)
  }
  def this() = {
    this("Espada",70,70, new Paladin("Cristiano"),0)
  }
  override def getMAP: Int = 0
}

