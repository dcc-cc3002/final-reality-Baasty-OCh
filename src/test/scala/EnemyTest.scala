import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class EnemyTest extends FunSuite {
  var Wand: MagicWeapon = _
  var Staff: MagicWeapon = _
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _
  var Neymar: Enemy = _
  var Bale: Enemy = _
  override def beforeEach(context: BeforeEach): Unit = {
    Wand = new MagicWeapon()
    Staff = new MagicWeapon()
    Alexis = new MagicCharacter()
    Vidal = new MagicCharacter()
    Neymar = new Enemy()
    Bale = new Enemy()

  }

  test("equalsMagicOwner") {
    var dueño: MagicCharacter = Wand.sayMagicOwner(Alexis)
    var expected : MagicCharacter = Alexis
    assertEquals(dueño, expected)
  }

  test("NotEqualsMagicOwner") {
    var dueño1: Character = Wand.sayMagicOwner(Alexis)
    var dueño2: Character = Staff.sayMagicOwner(Vidal)
    assertNotEquals(dueño1, dueño2)
  }

  test("equalsMana") {
    var mana = Wand.sayMana(20)
    var expected: Int = 20
    assertEquals(mana, expected)
  }
  test("NotEqualsMana") {
    var mana1 = Wand.sayMana(20)
    var mana2 = Staff.sayAttack(30)
    assertNotEquals(mana1, mana2)
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

