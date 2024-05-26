package playableTest.magicTest

import model.nonplayable.Enemy
import model.playable.magic.BlackMagican
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `BlackMagican` class.
 * This class contains tests for various functionalities of the `BlackMagican` class.
 */
class BlackMagicanTest extends FunSuite {
  var Modric: BlackMagican = _
  var Iniesta: Enemy = _
  var James: BlackMagican = _
  var Puyol: Enemy = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Modric = new BlackMagican("Modric")
    James = new BlackMagican("James",50,60,80,21)
    Iniesta = new Enemy("Iniesta")
    Puyol = new Enemy("Puyol",50,50,250,500) // enemy with ridiculous defense
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Modric`) are considered equal.
   * false in other case.
   */
  test("equals") {
    assertEquals(Modric.equals(Modric),true)
    assertEquals(Modric.equals(James),false)
    assertEquals(Modric.equals(Iniesta),false)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the BlackMagican 'Modric' can Equip particular kind of weapon or not
   * (he can: Staff, Wand and Sword. and can not: Bow and Axe)
   */
  test("canEquip"){
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()

    assertEquals(Modric.canEquipStaff(Baston),true)
    assertEquals(Modric.canEquipWand(Varita),true)
    assertEquals(Modric.canEquipSword(Espada),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Staff' , 'Wand' or 'Sword') on the
   * BlackMagican `Modric`.
   */
  test("putWeapon") {
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()

    assertEquals(Modric.putWeapon(Baston), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Baston))

    assertEquals(Modric.putWeapon(Varita), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Varita))

    assertEquals(Modric.putWeapon(Espada), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Espada))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Modric'
   */
  test("dropWeapon"){
    val Baston: Staff = new Staff()
    Modric.putWeapon(Baston)
    assertEquals(Modric.hasWeapon, Some(Baston))

    Modric.dropWeapon()
    assertEquals(Modric.hasWeapon,None)
  }

  test("It should throw an exception if the BlackMagican cant equip an Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Modric.putWeapon(Hacha),"The character: Modric can't wear an Axe")
  }

  test("It should throw an exception if the BlackMagican cant equip a Bow"){
    val Arco: Bow = new Bow()
    assertEquals(Modric.putWeapon(Arco),"The character: Modric can't wear a Bow")
  }

  test("It should throw an exception if the BlackMagican cant equip a foreign weapon"){
    val Baston: Staff = new Staff()
    James.putWeapon(Baston)

    assertEquals(Modric.putWeapon(Baston),"The weapon: Baston already has owner")
  }

  /**
   * Test case for attack method.
   * This test verifies if the `attack` method inflicts the correct damage on the enemy (`Iniesta`) when `Modric`
   * attacks with a `Wand`. Also verifies if the 'attack' method inflicts zero damage
   * when the defense poitns of enemy are higher than the attack points of BlackMagican
   */
  test("attack") {
    val Baston: Staff = new Staff()
    Modric.putWeapon(Baston)

    assertEquals(Modric.attack(Iniesta),"The enemy was Attack")
    assertEquals(Modric.attack(Puyol),"The enemy was Attack, but the damage is not enough")
  }

  test("It should throw an exception if the BlackMagican cant attack game unit"){
    val Baston: Staff = new Staff()
    Modric.putWeapon(Baston)

    assertEquals(Modric.attack(James), "The character: Modric can't attack an Allie")
  }

}

