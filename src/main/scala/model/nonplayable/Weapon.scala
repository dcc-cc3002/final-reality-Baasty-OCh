package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Character
class Weapon(name:String,weight:Int,
             attack:Int,owner:Character) extends NonPlayable {
  def sayOwner() : Character = {
    owner
  }

  def sayName(): String = {
     name
  }

  def sayWeight(): Int = {
    weight
  }

  def sayAttack(): Int = {
    attack
  }




}
