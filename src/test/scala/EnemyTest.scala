import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _
  var Bale: Enemy = _
  override def beforeEach(context: BeforeEach): Unit = {
    Neymar = new Enemy()
    Bale = new Enemy()

  }

  test("equalsEnemyName"){
    var nombre: String = Neymar.sayName("Neymar")
    var expected: String = "Neymar"
    assertEquals(nombre,expected)
  }
  test("NotEqualsEnemyName"){
    var nombre1: String = Neymar.sayName("Neymar")
    var nombre2: String = Bale.sayName("Bale")
    assertNotEquals(nombre1,nombre2)
  }
  test("equalsWeight") {
    var peso = Neymar.sayWeight(5)
    var expected: Int = 5
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Neymar.sayWeight(5)
    var peso2 = Bale.sayWeight(3)
    assertNotEquals(peso1, peso2)
  }
  test("equalsAttack") {
    var ataque = Neymar.sayAttack(25)
    var expected: Int = 25
    assertEquals(ataque, expected)

  }
  test("NotEqualsAttack") {
    var vida1 = Neymar.sayAttack(25)
    var vida2 = Bale.sayAttack(20)
    assertNotEquals(vida1, vida2)

  }
  test("equalsLife") {
    var vida = Neymar.sayLife(100)
    var expected: Int = 100
    assertEquals(vida, expected)

  }
  test("NotEqualsLife") {
    var vida1 = Neymar.sayLife(100)
    var vida2 = Bale.sayLife(90)
    assertNotEquals(vida1, vida2)

  }
  test("equalsDefence") {
    var defensa = Neymar.sayDefence(10)
    var expected: Int = 10
    assertEquals(defensa, expected)
  }
  test("NotEqualsDefence") {
    var defensa1 = Neymar.sayDefence(10)
    var defensa2 = Bale.sayDefence(5)
    assertNotEquals(defensa1, defensa2)
  }
}

