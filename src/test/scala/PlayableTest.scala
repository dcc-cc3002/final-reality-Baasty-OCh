import munit.FunSuite
import model.playable.{Character, MagicCharacter, Playable}
class PlayableTest extends FunSuite {
  var Cristiano: Playable = _
  var Messi: Playable = _
  var Alexis: MagicCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Character()
    Messi = new Character()
    Alexis = new MagicCharacter()

  }

  test("equalsName") {
    var nombre = Cristiano.sayName("Cristiano")
    val expected: String = "Cristiano"
    assertEquals(nombre, expected)
  }

  test("NotEqualsName") {
    var nombre1 = Cristiano.sayName("Cristiano")
    var nombre2 = Messi.sayName("Messi")
    assertNotEquals(nombre1, nombre2)

  }
  test("equalsLife") {
    var vida = Cristiano.sayLife(100)
    var expected: Int = 100
    assertEquals(vida, expected)

  }
  test("NotEqualsLife") {
    var vida1 = Cristiano.sayLife(100)
    var vida2 = Messi.sayLife(90)
    assertNotEquals(vida1, vida2)

  }
  test("equalsDefence") {
    var defensa = Cristiano.sayDefence(10)
    var expected: Int = 10
    assertEquals(defensa, expected)
  }
  test("NotEqualsDefence") {
    var defensa1 = Cristiano.sayDefence(10)
    var defensa2 = Messi.sayDefence(5)
    assertNotEquals(defensa1, defensa2)
  }
  test("equalsWeight") {
    var peso = Cristiano.sayWeight(50)
    var expected: Int = 50
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Cristiano.sayWeight(50)
    var peso2 = Messi.sayWeight(40)
    assertNotEquals(peso1, peso2)
  }
  test("equalsKind") {
    var clase = Cristiano.sayKind("Paladin")
    var expected: String = "Paladin"
    assertEquals(clase, expected)
  }
  test("NotEqualsKind") {
    var clase1 = Cristiano.sayKind("Paladin")
    var clase2 = Messi.sayKind("Guerrero")
    assertNotEquals(clase1, clase2)
  }
  test("equalsWeapon") {
    var arma = Cristiano.putWeapon("Hacha")
    var expected: String = "Hacha"
    assertEquals(arma, expected)
  }
  test("NotEqualsWeapon") {
    var arma1 = Cristiano.putWeapon("Hacha")
    var arma2 = Messi.putWeapon("Arco")
    assertNotEquals(arma1, arma2)
  }
  test("equalsMana") {
    var mana = Alexis.sayMana(90)
    var expected: Int = 90
    assertEquals(mana, expected)
  }
}