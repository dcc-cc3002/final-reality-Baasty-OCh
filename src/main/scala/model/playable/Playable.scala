package model.playable

trait Playable {
  def sayname(name: String) : Unit
  def saylife(life: Int): Unit
  def saydefence(defence: Int): Unit
  def sayweight(weight: Int): Unit
  def saykind(kind: String): Unit
  def checkWeapon(player:Playable): Unit



}
