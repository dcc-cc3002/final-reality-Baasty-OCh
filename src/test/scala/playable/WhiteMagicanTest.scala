package playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.Enemy
import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.WhiteMagican
import model.playable.{APlayable, Playable}
import munit.{FunSuite, Only}
/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class WhiteMagicanTest extends FunSuite {
  var Benzema: WhiteMagican = _ // Declaration of a variable `Benzema` of type `Playable`.
  var Ter_Stegen: Enemy = _ // Declaration of a variable `Ter_Stegen` of type `Enemy`.
  var Ozil: WhiteMagican = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Benzema = new WhiteMagican("Benzema")
    Ozil = new WhiteMagican("Ozil",55,90,32,90)
    Ter_Stegen = new Enemy("Ter_Stegen")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Benzema`) are considered equal.
   */
  test("equals") {
    assertEquals(Benzema.equals(Benzema),true)
    assertEquals(Benzema.equals(Ozil),false)
    assertEquals(Benzema.equals(Ter_Stegen),false)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Benzema`) matches the expected value.
   */
  test("getName") {
    assertEquals(Benzema.getName, "Benzema")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Benzema` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    assertEquals(Benzema.getHp, 100)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Benzema` matches the expected value (`80`).
   */
  test("getDefencePoints") {
    assertEquals(Benzema.getDp, 80)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Benzema` matches the expected value (`60`).
   */
  test("getWeight") {
    assertEquals(Benzema.getWeight, 60)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Benzema` matches the expected value (`40`).
   */
  test("getMana") {
    assertEquals(Benzema.getMana, 40)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Benzema` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Benzema.hasWeapon, None)
  }


  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the WhiteMagican 'Benzema' can Equip particular kind of weapon or not
   * (he can: Bow, Wand and Staff. and can not: Sword and Axe)
   */
  test("canEquip"){
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Arco: Bow = new Bow()

    assertEquals(Benzema.canEquipStaff(Baston),true)
    assertEquals(Benzema.canEquipWand(Varita),true)
    assertEquals(Benzema.canEquipBow(Arco),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon ('Bow' , 'Wand' or 'Staff') on the character 'Casemiro'.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Arco: Bow = new Bow()

    assertEquals(Benzema.putWeapon(Varita),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Varita))

    assertEquals(Benzema.putWeapon(Arco),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Arco))

    assertEquals(Benzema.putWeapon(Baston),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Baston))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Benzema'
   */
  test("dropWeapon"){
    val Arco: Bow = new Bow()
    Benzema.putWeapon(Arco)
    assertEquals(Benzema.hasWeapon, Some(Arco))

    Benzema.dropWeapon()
    assertEquals(Benzema.hasWeapon,None)
  }

  test("It should throw an exception if the Paladin cant equip a Sword"){
    val Espada: Sword = new Sword()
    assertEquals(Benzema.putWeapon(Espada),"The character: Benzema can't wear a Sword")
  }


  test("It should throw an exception if the Paladin cant equip a Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Benzema.putWeapon(Hacha),"The character: Benzema can't wear an Axe")
  }

  test("It should throw an exception if the WhiteMagican cant equip a foreign weapon"){
    val Arco: Bow = new Bow()
    Ozil.putWeapon(Arco)

    assertEquals(Benzema.putWeapon(Arco),"The weapon: Arco already has owner")
  }


  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Rakitic`) when `Modric` attacks with a `Bow`.
   */
  test("attackEnemy") {
    Benzema.putWeapon(new Staff())
    val damage: Int = Benzema.attack(Ter_Stegen)
    val expectedDamage: Int = 70 - 50

    assertEquals(damage, expectedDamage)
  }

  /**
   * Test case when a 'BlackMagican' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the BlackMagican 'Modric' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Benzema.wasAttacked(45)

    assertEquals(Benzema.getHp,55)

    Benzema.wasAttacked(200)

    assertEquals(Benzema.getHp,0)
  }


}
