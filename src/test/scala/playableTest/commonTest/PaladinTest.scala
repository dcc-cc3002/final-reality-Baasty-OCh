package playableTest.commonTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.Paladin
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _
  var Pique: Enemy = _
  var Bale: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Paladin("Cristiano")
    Bale = new Paladin("Bale",25,34,56)
    Pique = new Enemy("Pique")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Cristiano`) are considered equal.
   */
  test("equals") {
    assertEquals(Cristiano.equals(Cristiano),true)
    assertEquals(Cristiano.equals(Bale),false)
    assertEquals(Cristiano.equals(Pique),false)
  }
  test("maxHp"){
    assertEquals(Cristiano.maxHp(),150)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the Paladin 'Cristiano' can Equip particular kind of weapon or not
   * (he can: Axe and Sword. and can not: Bow, Staff and Wand)
   */
  test("canEquip"){
    val Espada: Sword = new Sword()
    val Hacha: Axe = new Axe()

    assertEquals(Cristiano.canEquipSword(Espada),true)
    assertEquals(Cristiano.canEquipAxe(Hacha),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Axe' or 'Sword') on the character `Cristiano`.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Hacha: Axe = new Axe()
    val Espada: Sword = new Sword()

    assertEquals(Cristiano.putWeapon(Hacha),"The weapon was wear")
    assertEquals(Cristiano.hasWeapon, Some(Hacha))

    assertEquals(Cristiano.putWeapon(Espada),"The weapon was wear")
    assertEquals(Cristiano.hasWeapon, Some(Espada))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Cristiano'
   */
  test("dropWeapon"){
    val Hacha: Axe = new Axe()
    Cristiano.putWeapon(Hacha)
    assertEquals(Cristiano.hasWeapon, Some(Hacha))

    Cristiano.dropWeapon()
    assertEquals(Cristiano.hasWeapon,None)
  }

  /**
   * Verifies that an exception is thrown when a Paladin character cannot equip a Staff.
   * This test checks if the character 'Cristiano' attempts to equip a Staff, which is not allowed for Paladin characters.
   * The expected exception message is returned, indicating that Cristiano cannot equip a Staff.
   */
  test("It should throw an exception if the Paladin cant equip a Staff"){
    val Baston: Staff = new Staff()
    assertEquals(Cristiano.putWeapon(Baston),"The character: Cristiano can't wear a Staff")
  }

  /**
   * Verifies that an exception is thrown when a Paladin character cannot equip a Wand.
   * This test checks if the character 'Cristiano' attempts to equip a Wand, which is not allowed for Paladin characters.
   * The expected exception message is returned, indicating that Cristiano cannot equip a Wand.
   */
  test("It should throw an exception if the Paladin cant equip a Wand"){
    val Varita: Wand = new Wand()
    assertEquals(Cristiano.putWeapon(Varita),"The character: Cristiano can't wear a Wand")
  }

  /**
   * Verifies that an exception is thrown when a Paladin character cannot equip a Bow.
   * This test checks if the character 'Cristiano' attempts to equip a Bow, which is not allowed for Paladin characters.
   * The expected exception message is returned, indicating that Cristiano cannot equip a Bow.
   */
  test("It should throw an exception if the Paladin cant equip a Bow"){
    val Arco: Bow = new Bow()
    assertEquals(Cristiano.putWeapon(Arco),"The character: Cristiano can't wear a Bow")
  }

  /**
   * Verifies that an exception is thrown when a Paladin character attempts to equip a foreign weapon.
   * This test checks if the character 'Bale' tries to equip an Axe, and then 'Cristiano' attempts to equip the same Axe,
   * the expected exception message is returned since the Axe 'Hacha' already has an owner.
   */
  test("It should throw an exception if the Paladin cant equip a foreign weapon"){
    val Hacha: Axe = new Axe()
    Bale.putWeapon(Hacha)

    assertEquals(Cristiano.putWeapon(Hacha),"The weapon: Hacha already has an owner")
  }

}


