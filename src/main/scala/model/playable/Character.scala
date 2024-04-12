package model.playable
import model.playable.Playable

class Character(name:String, life:Int,
                defence:Int,weight:Int,
                kind:String,weapon:Boolean) extends Playable {
  def sayName() = {name}
  def sayLife()= {life}

  def sayDefence()= {defence}

  def sayWeight()={weight}
  def sayKind()={kind}

  def havWeapon()={weapon}

}



