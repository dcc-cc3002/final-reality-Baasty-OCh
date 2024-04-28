package model.nonplayable
import model.nonplayable.AWeapon
import model.playable.Playable

class Axe(name: String, weight: Int,
          attackPoints: Int, owner: Playable) extends AWeapon(name, weight, attackPoints, owner) {
  def this(owner: Playable) = {
    this("Hacha", 50, 50, owner)
  }
}
class Sword(name: String, weight: Int,
            attackPoints: Int, owner: Playable) extends AWeapon(name, weight, attackPoints, owner) {
    def this(owner:Playable) = {
      this("Espada",70,70,owner)
    }
}

class Bow(name: String, weight: Int,
            attackPoints: Int, owner: Playable) extends AWeapon(name, weight, attackPoints, owner) {
  def this(owner:Playable) = {
    this("Arco",30,40,owner)
  }
}

class Staff(name: String, weight: Int,
            attackPoints: Int, owner: Playable ,
            mana: Int) extends AWeapon(name, weight, attackPoints, owner) {
  def this(owner:Playable) = {
    this("Baston",70,70,owner, 40)
  }
}

class Wand(name: String, weight: Int,
           attackPoints: Int, owner: Playable ,
           mana: Int) extends AWeapon(name, weight, attackPoints, owner) {
  def this(owner:Playable) = {
    this("Varita",70,70,owner, 30)
  }
}