import munit.FunSuite
import model.playable.Playable
import model.playable.Character
class PlayableTest extends FunSuite {
  var Cristiano: Playable = _
  var Messi: Playable = _

  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Character()
    Messi = new Character()
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
}