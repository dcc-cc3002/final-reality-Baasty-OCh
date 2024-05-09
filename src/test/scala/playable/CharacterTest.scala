package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
class CharacterTest extends FunSuite {
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Character
  var Casemiro: Playable = _ // We declare a variable Messi of type Character
  var Messi: Playable = _ // We declare a variable Messi of type Character
  var Neymar: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Paladin("Cristiano")
    Casemiro = new Warrior("Casemiro")
    Messi = new Ninja("Messi")
    Neymar = new Enemy("Neymar")

  }


  test("attack"){
    Cristiano.putWeapon(new Sword())
    val daño: Int = Cristiano.attackEnemy(Neymar)
    val expected: Int = 70 - 50
    assertEquals(daño,expected)
  }
  test("wasAttacked"){
    assertEquals(Cristiano.wasAttacked(25).getHp,75) // 100 de vida - 25 de daño -> 75 de vida
    assertEquals(Cristiano.wasAttacked(125).getHp,0)
  }




}