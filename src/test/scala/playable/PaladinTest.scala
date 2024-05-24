package playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.Enemy
import model.nonplayable.weapons.common.{Axe, Bow, Sword}
import model.nonplayable.weapons.magic.{Staff, Wand}
import model.playable.Playable
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.APlayable
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Pique: Enemy = _ // Declaration of a variable `Pique` of type `Enemy`.
  var Bale: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Cristiano` with new instances of `Paladin`.
    Cristiano = new Paladin("Cristiano")
    Bale = new Paladin("Bale",25,34,56)
    // Initialize `Pique` with new instances of `Enemy`.
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

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Cristiano`) matches the expected value.
   */
  test("getName") {
    assertEquals(Cristiano.getName, "Cristiano")
    assertEquals(Bale.getName,"Bale")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Cristiano` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    assertEquals(Cristiano.getHp, 100)
    assertEquals(Bale.getHp,25)
  }


  /**
   * Test case for `setMana` method.
   * This test verifies if the returned health points value for the characters `Cristiano` and 'Bale' matches the expected values (`125 and 250`).
   */
  test("setHp"){
    Cristiano.setHp(125)
    Bale.setHp(250)

    assertEquals(Cristiano.getHp,125)
    assertEquals(Bale.getHp,250)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Cristiano` matches the expected value (`75`).
   */
  test("getDefencePoints") {
    assertEquals(Cristiano.getDp, 75)
    assertEquals(Bale.getDp,34)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Cristiano` matches the expected value (`50`).
   */
  test("getWeight") {
    assertEquals(Cristiano.getWeight, 50)
    assertEquals(Bale.getWeight,56)
  }


  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Cristiano` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Cristiano.hasWeapon, None)
    assertEquals(Bale.hasWeapon,None)
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


  test("It should throw an exception if the Paladin cant equip a Staff"){
    val Baston: Staff = new Staff()
    assertEquals(Cristiano.putWeapon(Baston),"The character: Cristiano can't wear a Staff")
  }

  test("It should throw an exception if the Paladin cant equip a Wand"){
    val Varita: Wand = new Wand()
    assertEquals(Cristiano.putWeapon(Varita),"The character: Cristiano can't wear a Wand")
  }

  test("It should throw an exception if the Paladin cant equip a Bow"){
    val Arco: Bow = new Bow()
    assertEquals(Cristiano.putWeapon(Arco),"The character: Cristiano can't wear a Bow")
  }

  test("It should throw an exception if the Paladin cant equip a foreign weapon"){
    val Hacha: Axe = new Axe()
    Bale.putWeapon(Hacha)

    assertEquals(Cristiano.putWeapon(Hacha),"The weapon: Hacha already has owner")
  }


  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Pique`) when `Cristiano` attacks with a `Sword`.
   */
  test("attackEnemy") {
    Cristiano.putWeapon(new Sword())
    Bale.putWeapon((new Axe()))
    val damage: Int = Cristiano.attackEnemy(Pique)
    val damage2: Int = Bale.attackEnemy(Pique)
    val expectedDamage: Int = 70 - 50
    val expectedDamage2: Int = 0

    assertEquals(damage, expectedDamage)
    assertEquals(damage2,expectedDamage2)
  }


  /**
   * Test case when a 'Paladin' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Paladin 'Cristiano' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Cristiano.wasAttacked(45)

    assertEquals(Cristiano.getHp,55)

    Cristiano.wasAttacked(200)

    assertEquals(Cristiano.getHp,0)
  }


}


