import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class WeaponTest extends FunSuite {
  var Sword: Weapon = _
  var Bow: Weapon = _
  var Cristiano: Character = _
  var Messi: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon("Espada",70,100,Cristiano)
    Bow = new Weapon("Arco",25,50,Messi)
    //Cristiano = new Character()
    //Messi = new Character()
  }

  test("equalsName") {
    var nombre: String = Sword.sayName()
    var expected = "Espada"
    assertEquals(nombre, expected)
  }
  test("NotEqualsName") {
    var nombre1 = Sword.sayName()
    var nombre2 = Bow.sayName()
    assertNotEquals(nombre1, nombre2)
  }
  test("equalsWeight") {
    var peso = Sword.sayWeight()
    var expected: Int = 70
    assertEquals(peso, expected)
  }
  test("NotEqualsWeight") {
    var peso1 = Sword.sayWeight()
    var peso2 = Bow.sayWeight()
    assertNotEquals(peso1, peso2)
  }
  test("equalsAttack") {
    var ataque = Sword.sayAttack()
    var expected: Int = 100
    assertEquals(ataque, expected)

  }
  test("NotEqualsAttack") {
    var vida1 = Sword.sayAttack()
    var vida2 = Bow.sayAttack()
    assertNotEquals(vida1, vida2)

  }
  test("equalsOwner") {
    var dueño: Character = Sword.sayOwner()
    var expected: Character = Cristiano
    assertEquals(dueño, expected)
  }

}
