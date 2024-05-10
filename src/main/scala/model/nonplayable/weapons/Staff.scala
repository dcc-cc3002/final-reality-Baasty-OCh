package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}



class Staff(name: String, weight: Int,
            attackPoints: Int, owner: Playable ,
            magicAttackPoints:Int) extends AWeapon(name, weight, attackPoints, owner,magicAttackPoints ) {
  def this(owner:Playable) = {
    this("Baston",70,70,owner, 40)
  }
  def this() = {
    this("Baston",70,70, new BlackMagican("Vidal"), 40)
  }
}