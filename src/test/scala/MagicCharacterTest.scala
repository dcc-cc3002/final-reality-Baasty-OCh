import model.playable.{Character, MagicCharacter}
import munit.FunSuite
class MagicCharacterTest extends FunSuite {
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    Alexis = new MagicCharacter("Alexis", 80, 55, 65, "Mago Blanco", false, 90)
    Vidal = new MagicCharacter("Vidal", 90, 100, 70, "Mago Negro", true, 50)

  }
  test("equalsName") {
    var nombre = Alexis.sayName()
    val expected: String = "Alexis"
    assertEquals(nombre, expected)
  }

  test("NotEqualsName") {
    var nombre1 = Alexis.sayName()
    var nombre2 = Vidal.sayName()
    assertNotEquals(nombre1, nombre2)

  }
  test("equalsLife") {
    var vida = Alexis.sayLife()
    var expected: Int = 80
    assertEquals(vida, expected)

  }
  test("NotEqualsLife") {
    var vida1 = Alexis.sayLife()
    var vida2 = Vidal.sayLife()
    assertNotEquals(vida1, vida2)

  }
  test("equalsDefence") {
    var defensa = Alexis.sayDefence()
    var expected: Int = 55
    assertEquals(defensa, expected)
  }
  test("NotEqualsDefence") {
    var defensa1 = Alexis.sayDefence()
    var defensa2 = Vidal.sayDefence()
    assertNotEquals(defensa1, defensa2)
  }
  test("equalsWeight") {
    var peso = Alexis.sayWeight()
    var expected: Int = 65
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Alexis.sayWeight()
    var peso2 = Vidal.sayWeight()
    assertNotEquals(peso1, peso2)
  }



  test("equalsMana") {
    var mana = Alexis.sayMana()
    var expected: Int = 90
    assertEquals(mana, expected)
  }
  test("NotEqualsMana") {
    var mana1 = Alexis.sayMana()
    var mana2 = Vidal.sayMana()
    assertNotEquals(mana1, mana2)
  }
  test("equalsMagicKind") {
    var clase = Alexis.sayKind()
    var expected: String = "Mago Blanco"
    assertEquals(clase, expected)
  }
  test("NotEqualsMagicKind") {
    var clase1 = Alexis.sayKind()
    var clase2 = Vidal.sayKind()
    assertNotEquals(clase1, clase2)
  }
  test("equalsMagicCharacter") {
    val pjm: MagicCharacter = Alexis
    var expected = Alexis
    assertEquals(pjm, expected)
  }
  test("NotEqualsMagicCharacter") {
    val pjm1: MagicCharacter = Alexis
    val pjm2: MagicCharacter = Vidal
    assertNotEquals(pjm1, pjm2)
  }
}