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
}

