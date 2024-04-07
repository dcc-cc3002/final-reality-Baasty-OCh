import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon}
import model.playable.{Character, MagicCharacter, Playable}
class NonPlayableTest extends FunSuite {
  var Sword: Weapon = _
  var Bow: Weapon = _
  var Wand: MagicWeapon = _
  var Staff: MagicWeapon = _
  var Cristiano: Character = _
  var Messi: Character = _
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon()
    Bow = new Weapon()
    Wand = new MagicWeapon()
    Staff = new MagicWeapon()
    Cristiano = new Character()
    Messi = new Character()
    Alexis = new MagicCharacter()
    Vidal = new MagicCharacter()

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
  test("equalsAttack") {
    var ataque = Sword.sayAttack(25)
    var expected: Int = 25
    assertEquals(ataque, expected)

  }
  test("NotEqualsAttack") {
    var vida1 = Sword.sayAttack(25)
    var vida2 = Bow.sayAttack(20)
    assertNotEquals(vida1, vida2)

  }
  test("equalsOwner") {
    var dueño: Character = Sword.sayOwner(Cristiano)
    var expected : Character = Cristiano
    assertEquals(dueño, expected)
  }

  test("NotEqualsOwner") {
    var dueño1: Character = Sword.sayOwner(Cristiano)
    var dueño2: Character = Bow.sayOwner(Messi)
    assertNotEquals(dueño1, dueño2)
  }

  test("equalsMagicOwner") {
    var dueño: MagicCharacter = Wand.sayMagicOwner(Alexis)
    var expected : MagicCharacter = Alexis
    assertEquals(dueño, expected)
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
}
