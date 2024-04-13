import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class MagicWeaponTest extends FunSuite {
  var Wand: MagicWeapon = _
  var Staff: MagicWeapon = _
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _
  var Cristiano: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    Wand = new MagicWeapon("Barita",10,50,50,Alexis)
    Staff = new MagicWeapon("Baston",15,60,45,Vidal)


  }
  test("equalsName") {
    var nombre: String = Wand.sayName()
    var expected = "Barita"
    assertEquals(nombre, expected)
  }
  test("NotEqualsName") {
    var nombre1 = Wand.sayName()
    var nombre2 = Staff.sayName()
    assertNotEquals(nombre1, nombre2)
  }
  test("equalsWeight") {
    var peso = Wand.sayWeight()
    var expected: Int = 10
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Wand.sayWeight()
    var peso2 = Staff.sayWeight()
    assertNotEquals(peso1, peso2)
  }
  test("equalsAttack") {
    var ataque = Wand.sayAttack()
    var expected: Int = 50
    assertEquals(ataque, expected)

  }
  test("NotEqualsAttack") {
    var vida1 = Wand.sayAttack()
    var vida2 = Staff.sayAttack()
    assertNotEquals(vida1, vida2)

  }
  test("equalsMana") {
    var mana = Wand.sayMana()
    var expected: Int = 50
    assertEquals(mana, expected)
  }
  test("NotEqualsMana") {
    var mana1 = Wand.sayMana()
    var mana2 = Staff.sayAttack()
    assertNotEquals(mana1, mana2)
  }

  test("equalsMagicOwner") {
    var dueño: MagicCharacter = Wand.sayOwner()
    var expected: MagicCharacter = Alexis
    assertEquals(dueño, expected)
  }
}
