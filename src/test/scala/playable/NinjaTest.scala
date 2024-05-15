package playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.weapons.{Bow,Sword,Axe,Staff,Wand}
import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite

/**
 * Test suite for the `Ninja` class.
 * This class contains tests for various functionalities of the `Ninja` class.
 */
class NinjaTest extends FunSuite {
  var Kroos: Playable = _ // Declaration of a variable `Kroos` of type `Playable`.
  var Rakitic: Enemy = _ // Declaration of a variable `Rakitic` of type `Enemy`.
  var Alonso: Playable = _ // Declaration of a variable `Alonso` of type `Playable`.

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

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Kroos`) matches the expected value.
   */
  test("getName") {
    assertEquals(Kroos.getName, "Kroos")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Kroos` matches the expected value (`80`).
   */
  test("getHealthPoints") {
    assertEquals(Kroos.getHp, 80)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Kroos` matches the expected value (`70`).
   */
  test("getDefencePoints") {
    assertEquals(Kroos.getDp, 70)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Kroos` matches the expected value (`30`).
   */
  test("getWeight") {
    assertEquals(Kroos.getWeight, 30)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Kroos` matches the expected value (`0`).
   */
  test("getMana") {
    assertEquals(Kroos.getMana, 0)
  }

  /**
   * Test case for 'setMana' method.
   * This test verifies if the set mana method do 'nothing' in the amount of mana points in this character
   */
  test("setMana"){
    Kroos.setMana(55)

    assertEquals(Kroos.getMana,0)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Kroos` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Kroos.hasWeapon, None)
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

    assertEquals(Kroos.canEquip(Baston),false)
    assertEquals(Kroos.canEquip(Varita),true)
    assertEquals(Kroos.canEquip(Espada),true)
    assertEquals(Kroos.canEquip(Arco),true)
    assertEquals(Kroos.canEquip(Hacha),false)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Bow' , 'Wand' or 'Sword') on the character `Kroos`.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()
    val Hacha: Axe = new Axe()
    val Arco: Bow = new Bow()

    Kroos.putWeapon(Varita)
    assertEquals(Kroos.hasWeapon, Some(Varita))

    Kroos.putWeapon(Arco)
    assertEquals(Kroos.hasWeapon, Some(Arco))

    Kroos.putWeapon(Espada)
    assertEquals(Kroos.hasWeapon, Some(Espada))

    try {
      Kroos.putWeapon(Hacha)
    } catch {
      case e: Exception => println(e.getMessage)
    }
    try {
      Kroos.putWeapon(Baston)
    } catch {
      case e: Exception => println(e.getMessage)
    }
  }


  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Rakitic`) when `Kroos` attacks with a `Bow`.
   */
  test("attackEnemy") {
    Kroos.putWeapon(new Bow())
    val damage: Int = Kroos.attackEnemy(Rakitic)
    val expectedDamage: Int = 40 - 50

    assertEquals(damage, expectedDamage)
  }


  /**
   * Test case when a 'Ninja' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Ninja 'Kroos' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Kroos.wasAttacked(45)

    assertEquals(Kroos.getHp,35)

    Kroos.wasAttacked(200)

    assertEquals(Kroos.getHp,0)
  }
}


