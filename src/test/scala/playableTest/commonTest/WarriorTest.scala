package playableTest.commonTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.Warrior
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class WarriorTest extends FunSuite {
  var Casemiro: Playable = _
  var Busquets: Enemy = _
  var Ramos: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Casemiro = new Warrior("Casemiro")
    Ramos = new Warrior("Ramos",50,70,99)
    Busquets = new Enemy("Busquets")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Casemiro`) are considered equal.
   */
  test("equals") {
    assertEquals(Casemiro.equals(Casemiro),true)
    assertEquals(Casemiro.equals(Ramos),false)
    assertEquals(Casemiro.equals(Busquets),false)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the Warrior 'Casemiro' can Equip particular kind of weapon or not
   * (he can: Bow, Axe and Sword. and can not: Staff and Wand)
   */
  test("canEquip"){
    val Espada: Sword = new Sword()
    val Hacha: Axe = new Axe()
    val Arco: Bow = new Bow()

    assertEquals(Casemiro.canEquipSword(Espada),true)
    assertEquals(Casemiro.canEquipBow(Arco),true)
    assertEquals(Casemiro.canEquipAxe(Hacha),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon ('Bow' , 'Axe' or 'Sword') on the character 'Casemiro'.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Espada: Sword = new Sword()
    val Hacha: Axe = new Axe()
    val Arco: Bow = new Bow()

    assertEquals(Casemiro.putWeapon(Hacha), "The weapon was wear")
    assertEquals(Casemiro.hasWeapon, Some(Hacha))

    assertEquals(Casemiro.putWeapon(Arco), "The weapon was wear")
    assertEquals(Casemiro.hasWeapon, Some(Arco))

    assertEquals(Casemiro.putWeapon(Espada), "The weapon was wear")
    assertEquals(Casemiro.hasWeapon, Some(Espada))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Casemiro'
   */
  test("dropWeapon"){
    val Espada: Sword = new Sword()
    Casemiro.putWeapon(Espada)
    assertEquals(Casemiro.hasWeapon, Some(Espada))

    Casemiro.dropWeapon()
    assertEquals(Casemiro.hasWeapon,None)
  }

  test("It should throw an exception if the Paladin cant equip a Staff"){
    val Baston: Staff = new Staff()
    assertEquals(Casemiro.putWeapon(Baston),"The character: Casemiro can't wear a Staff")
  }


  test("It should throw an exception if the Paladin cant equip a Wand"){
    val Varita: Wand = new Wand()
    assertEquals(Casemiro.putWeapon(Varita),"The character: Casemiro can't wear a Wand")
  }

  test("It should throw an exception if the Warrior cant equip a foreign weapon"){
    val Espada: Sword = new Sword()
    Ramos.putWeapon(Espada)

    assertEquals(Casemiro.putWeapon(Espada),"The weapon: Espada already has owner")
  }

}
