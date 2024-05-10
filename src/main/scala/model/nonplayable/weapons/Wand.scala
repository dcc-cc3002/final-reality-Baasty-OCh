package model.nonplayable.weapons
import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

class Wand(name: String, weight: Int,
           attackPoints: Int, owner: Playable ,
           magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {
  def this(owner:Playable) = {
    this("Varita",40,50,owner, 30)
  }
  def this()={
    this("Varita",40,50, new WhiteMagican("Alexis"), 30)
  }
}
