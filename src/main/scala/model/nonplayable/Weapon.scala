package model.nonplayable
import model.nonplayable.NonPlayable
import model.playable.Character
class Weapon extends NonPlayable {
  def sayOwner(owner : Character): Character = {
    return owner
  }
  def sayName(name: String): String = {
    return name
  }

  def sayWeight(weight: Int): Int = {
    return weight
  }

  def sayAttack(attack: Int): Int = {
    return attack
  }




}
