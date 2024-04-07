package model.nonplayable
import model.nonplayable.NonPlayable
class Enemy extends NonPlayable{

  def sayName(name: String): String = {
    return name
  }

  def sayWeight(weight: Int): Int = {
    return weight
  }

  def sayAttack(attack: Int): Int = {
    return attack
  }

  def sayLife(life: Int): Int = {
    return life
  }

  def sayDefence(defence: Int): Int = {
    return defence
  }
}
