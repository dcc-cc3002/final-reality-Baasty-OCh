package model.playable


class Character extends Playable {
  def sayName(name: String): Unit = {
    println(name)
  }

  def sayLife(life: Int): Unit = {
    println(life)
  }


}
