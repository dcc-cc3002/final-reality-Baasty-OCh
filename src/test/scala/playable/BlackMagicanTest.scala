package playable

import exceptions.{InvalidputAxeException, InvalidputBowException}
import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.Enemy
import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.playable.{APlayable, Playable}
import munit.{FunSuite, Ignore, Slow}

/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class BlackMagicanTest extends FunSuite {
  var Modric: BlackMagican = _ // Declaration of a variable `Modric` of type `Playable`.
  var Iniesta: Enemy = _ // Declaration of a variable `Iniesta` of type `Enemy`.
  var James: BlackMagican = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Modric` with new instances of `Ninja`.
    Modric = new BlackMagican("Modric")
    James = new BlackMagican("James",50,60,80,21)
    // Initialize `Iniesta` with new instances of `Enemy`.
    Iniesta = new Enemy("Iniesta")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Modric`) are considered equal.
   */
  test("equals") {
    assertEquals(Modric.equals(Modric),true)
    assertEquals(Modric.equals(James),false)
    assertEquals(Modric.equals(Iniesta),false)

  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Modric`) matches the expected value.
   */
  test("getName") {
    assertEquals(Modric.getName, "Modric")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Modric` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    assertEquals(Modric.getHp, 90)
  }

  test("setHp"){
    Modric.setHp(45)

    assertEquals(Modric.getHp,45)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Modric` matches the expected value (`80`).
   */
  test("getDefencePoints") {
    assertEquals(Modric.getDp, 60)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Modric` matches the expected value (`60`).
   */
  test("getWeight") {
    assertEquals(Modric.getWeight, 50)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Modric` matches the expected value (`40`).
   */
  test("getMana") {
    assertEquals(Modric.getMana, 50)
  }

  /**
   * Test case for 'setMana' method.
   * This test verifies if the returned mana value for the character `Modric` matches the expected value (`90`).
   */
  test("setMana"){
    Modric.setMana(90)

    assertEquals(Modric.getMana,90)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Modric` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Modric.hasWeapon, None)
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
    val Hacha: Axe = new Axe()
    val Arco: Bow = new Bow()

    assertEquals(Modric.canEquipStaff(Baston),true)
    assertEquals(Modric.canEquipWand(Varita),true)
    assertEquals(Modric.canEquipSword(Espada),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Staff' , 'Wand' or 'Sword') on the character `Modric`.
   * And throw exceptions in other cases
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
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Iniesta`) when `Modric` attacks with a `Wand`.
   */
  test("attackEnemy") {
    Modric.putWeapon(new Wand())
    val damage: Int = Modric.attackEnemy(Iniesta)
    val expectedDamage: Int = 50 - 50

    assertEquals(damage, expectedDamage)
  }


  /**
   * Test case when a 'BlackMagican' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the BlackMagican 'Modric' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Modric.wasAttacked(45)

    assertEquals(Modric.getHp,45)

    Modric.wasAttacked(200)

    assertEquals(Modric.getHp,0)
  }

}

