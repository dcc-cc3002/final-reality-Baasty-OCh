package model.nonplayable.weapons

import model.nonplayable.weapons.AWeapon
import model.playable.{Warrior, WhiteMagican, BlackMagican, Ninja, Paladin, Playable}

class Axe(name: String, weight: Int,
          attackPoints: Int, owner: Playable,
          magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {
  def this(owner: Playable) = {
    this("Hacha", 50, 50, owner,0)
  }
  def this() = {
    this ("Hacha", 50, 50, new Warrior("Casemiro"),0)
  }

  override def getMAP: Int = 0
