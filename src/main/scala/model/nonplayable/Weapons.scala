package model.nonplayable
import model.nonplayable.AWeapon
import model.playable.{Guerrero, MagoBlanco, MagoNegro, Ninja, Paladin, Playable}

class Axe(name: String, weight: Int,
          attackPoints: Int, owner: Playable,
          magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {
  def this(owner: Playable) = {
    this("Hacha", 50, 50, owner,0)
  }
  def this() = {
    this ("Hacha", 50, 50, new Guerrero("Casemiro"),0)
  }

  override def getMAP: Int = 0



}
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

class Staff(name: String, weight: Int,
            attackPoints: Int, owner: Playable ,
            magicAttackPoints:Int) extends AWeapon(name, weight, attackPoints, owner,magicAttackPoints ) {
  def this(owner:Playable) = {
    this("Baston",70,70,owner, 40)
  }
  def this() = {
    this("Baston",70,70, new MagoNegro("Vidal"), 40)
  }
}

class Wand(name: String, weight: Int,
           attackPoints: Int, owner: Playable ,
           magicAttackPoints: Int) extends AWeapon(name, weight, attackPoints, owner, magicAttackPoints) {
  def this(owner:Playable) = {
    this("Varita",40,50,owner, 30)
  }
  def this()={
    this("Varita",40,50, new MagoBlanco("Alexis"), 30)
  }
}