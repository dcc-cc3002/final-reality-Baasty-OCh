import munit.FunSuite
import model.playable.{Character, MagicCharacter, Playable}
class CharacterTest extends FunSuite {
  var Cristiano: Character = _
  var Messi: Character = _
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Character("Cristiano",100,50,70,"Paladin",false)
    Messi = new Character("Messi",90,40,60,"Guerrero",true)
    Alexis = new MagicCharacter("Alexis",80,55,65,"Mago Blanco",false,90)
    Vidal = new MagicCharacter("Vidal",90,100,70,"Mago Negro",true,50)

  }
  test("equals") {
    val pj : Character = Cristiano
    var expected = Cristiano
    assertEquals(pj, expected)
  }
  test("NotEquals") {
    val pj1 : Character = Cristiano
    val pj2 : Character = Messi
    assertNotEquals(pj1, pj2)
  }
  test("equalsName") {
    var nombre = Cristiano.sayName()
    val expected: String = "Cristiano"
    assertEquals(nombre, expected)
  }

  test("NotEqualsName") {
    var nombre1 = Cristiano.sayName()
    var nombre2 = Messi.sayName()
    assertNotEquals(nombre1, nombre2)

  }
  test("equalsLife") {
    var vida = Cristiano.sayLife()
    var expected: Int = 100
    assertEquals(vida, expected)

  }
  test("NotEqualsLife") {
    var vida1 = Cristiano.sayLife()
    var vida2 = Messi.sayLife()
    assertNotEquals(vida1, vida2)

  }
  test("equalsDefence") {
    var defensa = Cristiano.sayDefence()
    var expected: Int = 50
    assertEquals(defensa, expected)
  }
  test("NotEqualsDefence") {
    var defensa1 = Cristiano.sayDefence()
    var defensa2 = Messi.sayDefence()
    assertNotEquals(defensa1, defensa2)
  }
  test("equalsWeight") {
    var peso = Cristiano.sayWeight()
    var expected: Int = 70
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Cristiano.sayWeight()
    var peso2 = Messi.sayWeight()
    assertNotEquals(peso1, peso2)
  }
  test("equalsKind") {
    var clase = Cristiano.sayKind()
    var expected: String = "Paladin"
    assertEquals(clase, expected)
  }
  test("NotEqualsKind") {
    var clase1 = Cristiano.sayKind()
    var clase2 = Messi.sayKind()
    assertNotEquals(clase1, clase2)
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
    val pjm2 : MagicCharacter = Vidal
    assertNotEquals(pjm1, pjm2)
  }
}