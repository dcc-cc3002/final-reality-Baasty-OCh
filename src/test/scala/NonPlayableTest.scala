import munit.FunSuite
import model.nonplayable.{Weapon,NonPlayable}
class NonPlayableTest extends FunSuite {
  var Sword: NonPlayable = _
  var Bow: NonPlayable = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon()
    Bow = new Weapon()
  }

  test("equalsName") {
    var nombre: String = Sword.sayName("Espada")
    var expected = "Espada"
    assertEquals(nombre, expected)
  }
  test("NotEqualsName") {
    var nombre1 = Sword.sayName("Espada")
    var nombre2 = Bow.sayName("Arco")
    assertNotEquals(nombre1, nombre2)
  }
  test("equalsWeight") {
    var peso = Sword.sayWeight(5)
    var expected: Int = 5
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Sword.sayWeight(5)
    var peso2 = Bow.sayWeight(3)
    assertNotEquals(peso1, peso2)
  }
}
