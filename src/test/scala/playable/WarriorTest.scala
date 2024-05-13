package playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.weapons.{Bow,Sword,Axe,Staff,Wand}
import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class WarriorTest extends FunSuite {
  var Casemiro: Playable = _ // Declaration of a variable `Casemiro` of type `Playable`.
  var Busquets: Enemy = _ // Declaration of a variable `Busquets` of type `Enemy`.
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
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Casemiro`) matches the expected value.
   */
  test("getName") {
    assertEquals(Casemiro.getName, "Casemiro")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Casemiro` matches the expected value (`120`).
   */
  test("getHealthPoints") {
    assertEquals(Casemiro.getHp, 120)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Casemiro` matches the expected value (`100`).
   */
  test("getDefencePoints") {
    assertEquals(Casemiro.getDp, 100)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Casemiro` matches the expected value (`70`).
   */
  test("getWeight") {
    assertEquals(Casemiro.getWeight, 70)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Casemiro` matches the expected value (`0`).
   */
  test("getMana") {
    assertEquals(Casemiro.getMana, 0)
  }

  /**
   * Test case for 'setMana' method.
   * This test verifies if the set mana method do 'nothing' in the amount of mana points in this character
   */
  test("setMana"){
    Casemiro.setMana(55)

    assertEquals(Casemiro.getMana,0)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Casemiro` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Casemiro.hasWeapon, None)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Axe`) on the character `Casemiro`.
   */
  test("putWeapon") {
    var Hacha: Axe = new Axe(Casemiro)
    Casemiro.putWeapon(Hacha)

    assertEquals(Casemiro.hasWeapon, Some(Hacha))
  }

  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Busquets`) when `Casemiro` attacks with a `Axe`.
   */
  test("attackEnemy") {
    Casemiro.putWeapon(new Axe(Casemiro))
    val damage: Int = Casemiro.attackEnemy(Busquets)
    val expectedDamage: Int = 50 - 50

    assertEquals(damage, expectedDamage)
  }

  /**
   * Test case when a 'Warrior' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Warrior 'Casemiro' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Casemiro.wasAttacked(45)

    assertEquals(Casemiro.getHp,75)

    Casemiro.wasAttacked(200)

    assertEquals(Casemiro.getHp,0)
  }


}
