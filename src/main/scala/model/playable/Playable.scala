package model.playable

trait Playable {
  def sayName(name: String) : String
  def sayLife(life: Int): Int
  def sayDefence(defence: Int): Int
  def sayWeight(weight: Int): Int
  def sayKind(kind: String): String
  def putWeapon(weapon: String): Unit



}
