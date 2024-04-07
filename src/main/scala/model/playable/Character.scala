package model.playable


class Character extends Playable {
  def sayName(name: String): Unit = {
    println(name)
  }

  def sayLife(life: Int): Unit = {
    println(life)
  }

  def sayDefence(defence: Int): Unit = {
    println(defence)
  }

  def sayWeight(weight: Int): Unit = {
    println(weight)
  }


}
