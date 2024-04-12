package model.playable
import model.playable.Character
class MagicCharacter(name:String, life:Int,
                      defence:Int,weight:Int,
                      kind:String,weapon:Boolean,
                      mana:Int) extends Playable {
  def sayName() = {name}
  def sayLife()= {life}

  def sayDefence()= {defence}

  def sayWeight()={weight}
  def sayKind()={kind}

  def havWeapon()={weapon}

  def sayMana()={mana}


}
