import munit.FunSuite
import model.nonplayable.{Weapon,NonPlayable}
class NonPlayableTest extends FunSuite {
  var Sword: NonPlayable = _
  var Bow: NonPlayable = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon()
    Bow = new Weapon()
  }
  test("equalsName"){
    var nombre: String = Sword.sayName("Espada")
    var expected  = "Espada"
    assertEquals(nombre,expected)
  }

  }

