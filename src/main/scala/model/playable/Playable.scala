package model.playable

trait Playable {
  def sayName(name: String) : String
  def sayLife(life: Int): Int
  def sayDefence(defence: Int): Int
  def sayWeight(weight: Int): Unit
  def sayKind(kind: String): Unit
  def putWeapon(weapon: String): Unit



}
