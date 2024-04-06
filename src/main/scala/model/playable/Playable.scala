package model.playable

trait Playable {
  def sayName(name: String) : Unit
  def sayLife(life: Int): Unit
  def sayDefence(defence: Int): Unit
  def sayWeight(weight: Int): Unit
  def sayKind(kind: String): Unit
  def checkWeapon(player:Playable): Unit



}
