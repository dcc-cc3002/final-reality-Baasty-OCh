import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class EnemyTest extends FunSuite {
  var Neymar: NonPlayable = _
  var Bale: NonPlayable = _
  override def beforeEach(context: BeforeEach): Unit = {
    Neymar = new Enemy("Neymar",60,90,70,30)
    Bale = new Enemy("Bale",70,85,75,50)

  }

  test("equalsEnemyName"){
    var nombre: String = Neymar.sayName()
    var expected: String = "Neymar"
    assertEquals(nombre,expected)
  }
  test("NotEqualsEnemyName"){
    var nombre1: String = Neymar.sayName()
    var nombre2: String = Bale.sayName()
    assertNotEquals(nombre1,nombre2)
  }
  test("equalsWeight") {
    var peso = Neymar.sayWeight()
    var expected: Int = 60
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Neymar.sayWeight()
    var peso2 = Bale.sayWeight()
    assertNotEquals(peso1, peso2)
  }
  test("equalsAttack") {
    var ataque = Neymar.sayAttack()
    var expected: Int = 90
    assertEquals(ataque, expected)

  }
  test("NotEqualsAttack") {
    var vida1 = Neymar.sayAttack()
    var vida2 = Bale.sayAttack()
    assertNotEquals(vida1, vida2)

  }
  test("equalsLife") {
    var vida = Neymar.sayLife()
    var expected: Int = 70
    assertEquals(vida, expected)

  }
  test("NotEqualsLife") {
    var vida1 = Neymar.sayLife()
    var vida2 = Bale.sayLife()
    assertNotEquals(vida1, vida2)

  }
  test("equalsDefence") {
    var defensa = Neymar.sayDefence()
    var expected: Int = 30
    assertEquals(defensa, expected)
  }
  test("NotEqualsDefence") {
    var defensa1 = Neymar.sayDefence()
    var defensa2 = Bale.sayDefence()
    assertNotEquals(defensa1, defensa2)
  }
}

