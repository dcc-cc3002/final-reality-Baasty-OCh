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
class NinjaTest extends FunSuite {
  var Kroos: Playable = _ // Declaration of a variable `Kroos` of type `Playable`.
  var Rakitic: Enemy = _ // Declaration of a variable `Rakitic` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Kroos` with new instances of `Ninja`.
    Kroos = new Ninja("Kroos")
    // Initialize `Rakitic` with new instances of `Enemy`.
    Rakitic = new Enemy("Rakitic")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Kroos`) are considered equal.
   */
  test("equals") {
    assertEquals(Kroos, Kroos)
  }


  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Kroos`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Kroos` and store it in the `name` variable.
    var name = Kroos.getName
    // Compare the actual name value (`name`) with the expected value ("Kroos").
    assertEquals(name, "Kroos")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Kroos` matches the expected value (`80`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Kroos` and store it in the `life` variable.
    var life = Kroos.getHp
    // Compare the actual health points value (`life`) with the expected value (`80`).
    assertEquals(life, 80)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Kroos` matches the expected value (`70`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Kroos` and store it in the `defense` variable.
    var defense = Kroos.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`70`).
    assertEquals(defense, 70)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Kroos` matches the expected value (`30`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Kroos` and store it in the `weight` variable.
    var weight = Kroos.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`30`).
    assertEquals(weight, 30)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Kroos` matches the expected value (`0`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Kroos` and store it in the `mana` variable.
    var mana = Kroos.getMana
    // Compare the actual mana value (`mana`) with the expected value (`0`).
    assertEquals(mana, 0)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Kroos` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Kroos.haveWeapon, None)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Bow`) on the character `Kroos`.
   */
  test("putWeapon") {
    // Create a new `Bow` instance (`Arco`) associated with `Kroos`.
    var Arco: Bow = new Bow(Kroos)
    // Equip the `Arco` weapon on the character `Kroos` using the `putWeapon` method.
    Kroos.putWeapon(Arco)
    // Verify if the character `Kroos` now has the `Arco` weapon equipped (returns `Some(Arco)`).
    assertEquals(Kroos.haveWeapon, Some(Arco))
  }

  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Rakitic`) when `Kroos` attacks with a `Bow`.
   */
  test("attackEnemy") {
    // Equip `Kroos` with a `Bow`.
    Kroos.putWeapon(new Bow(Kroos))

    // `Kroos` attacks `Rakitic` using the `attackEnemy` method and retrieves the inflicted damage (`damage`).
    val damage: Int = Kroos.attackEnemy(Rakitic)

    // Calculate the expected damage based on `Kroos`'s attack power (Bow's attack - `Rakitic`'s defense).
    val expectedDamage: Int = 40 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }


}


