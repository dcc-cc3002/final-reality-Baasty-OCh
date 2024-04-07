package model.playable
import model.playable.Playable

class Character extends Playable {
  def sayName(name: String): String = {
    return name

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

  def sayKind(kind: String): Unit = {
    println(kind)
  }

  def putWeapon(weapon: String): Unit = {
    val arma: Unit = println(weapon)

  }
}

  object HelloWorld {
    def main(args: Array[String]): Unit = {

      var Cris: Playable = new Character()
      Cris.sayName("Mercedes Benz")
      Cris.sayLife(2019)
      Cris.sayDefence(2015)


    }
  }

