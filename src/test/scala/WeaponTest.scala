import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class WeaponTest extends FunSuite {
  var Sword: Weapon = _
  var Bow: Weapon = _
  var Cristiano: Character = _
  var Messi: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon()
    Bow = new Weapon()
    Cristiano = new Character()
    Messi = new Character()
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
    var expected: Character = Cristiano
    assertEquals(dueño, expected)
  }

  test("NotEqualsOwner") {
    var dueño1: Character = Sword.sayOwner(Cristiano)
    var dueño2: Character = Bow.sayOwner(Messi)
    assertNotEquals(dueño1, dueño2)
  }
}
