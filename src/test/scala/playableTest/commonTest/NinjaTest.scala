package playableTest.commonTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.Ninja
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `Ninja` class.
 * This class contains tests for various functionalities of the `Ninja` class.
 */
class NinjaTest extends FunSuite {
  var Kroos: Playable = _
  var Rakitic: Enemy = _
  var Alonso: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Kroos = new Ninja("Kroos")
    Alonso = new Ninja("Alonso",100,50,12)
    Rakitic = new Enemy("Rakitic")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Kroos`) are considered equal.
   */
  test("equals") {
    assertEquals(Kroos.equals(Kroos),true)
    assertEquals(Kroos.equals(Alonso),false)
    assertEquals(Kroos.equals(Rakitic),false)
  }
  test("maxHp"){
    assertEquals(Kroos.maxHp(),100)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the Ninja 'Kroos' can Equip particular kind of weapon or not
   * (he can: Bow, Wand and Sword. and can not: Staff and Axe)
   */
  test("canEquip"){
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()
    val Hacha: Axe = new Axe()
    val Arco: Bow = new Bow()

    assertEquals(Kroos.canEquipWand(Varita),true)
    assertEquals(Kroos.canEquipSword(Espada),true)
    assertEquals(Kroos.canEquipBow(Arco),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Bow' , 'Wand' or 'Sword') on the character `Kroos`.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()
    val Arco: Bow = new Bow()

    assertEquals(Kroos.putWeapon(Varita),"The weapon was wear")
    assertEquals(Kroos.hasWeapon, Some(Varita))

    assertEquals(Kroos.putWeapon(Arco),"The weapon was wear")
    assertEquals(Kroos.hasWeapon, Some(Arco))

    assertEquals(Kroos.putWeapon(Espada),"The weapon was wear")
    assertEquals(Kroos.hasWeapon, Some(Espada))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Kroos'
   */
  test("dropWeapon"){
    val Varita: Wand = new Wand()
    Kroos.putWeapon(Varita)
    assertEquals(Kroos.hasWeapon, Some(Varita))

    Kroos.dropWeapon()
    assertEquals(Kroos.hasWeapon,None)
  }

  /**
   * Verifies that an exception is thrown when a Ninja character cannot equip a Staff.
   * This test checks if the character 'Kroos' attempts to equip a Staff, which is not allowed for Ninja characters.
   * The expected exception message is returned, indicating that Kroos cannot equip a Staff.
   */
  test("It should throw an exception if the Ninja cant equip a Staff"){
    val Baston: Staff = new Staff()
    assertEquals(Kroos.putWeapon(Baston),"The character: Kroos can't wear a Staff")
  }

  /**
   * Verifies that an exception is thrown when a Ninja character cannot equip an Axe.
   * This test checks if the character 'Kroos' attempts to equip an Axe, which is not allowed for Ninja characters.
   * The expected exception message is returned, indicating that Kroos cannot equip an Axe.
   */
  test("It should throw an exception if the Ninja cant equip an Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Kroos.putWeapon(Hacha),"The character: Kroos can't wear an Axe")
  }

  /**
   * Verifies that an exception is thrown when a Ninja character attempts to equip a foreign weapon.
   * This test checks if the character 'Alonso' tries to equip a Wand, and then 'Kroos' attempts to equip the same Wand,
   * the expected exception message is returned since the Wand 'Varita' already has an owner.
   */
  test("It should throw an exception if the Ninja cant equip a foreign weapon"){
    val Varita: Wand = new Wand()
    Alonso.putWeapon(Varita)

    assertEquals(Kroos.putWeapon(Varita),"The weapon: Varita already has an owner")
  }

}


