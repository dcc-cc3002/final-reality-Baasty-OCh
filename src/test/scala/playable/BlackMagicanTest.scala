package playable

import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Sword, Wand}
import model.playable.{APlayable, BlackMagican, Ninja, Paladin, Playable, Warrior, WhiteMagican}
import munit.FunSuite

/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class BlackMagicanTest extends FunSuite {
  var Modric: Playable = _ // Declaration of a variable `Modric` of type `Playable`.
  var Iniesta: Enemy = _ // Declaration of a variable `Iniesta` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Modric` with new instances of `Ninja`.
    Modric = new BlackMagican("Modric")
    // Initialize `Iniesta` with new instances of `Enemy`.
    Iniesta = new Enemy("Iniesta")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Modric`) are considered equal.
   */
  test("equals") {
    assertEquals(Modric, Modric)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Modric`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Modric` and store it in the `name` variable.
    var name = Modric.getName
    // Compare the actual name value (`name`) with the expected value ("Modric").
    assertEquals(name, "Modric")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Modric` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Modric` and store it in the `life` variable.
    var life = Modric.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 90)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Modric` matches the expected value (`80`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Modric` and store it in the `defense` variable.
    var defense = Modric.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`80`).
    assertEquals(defense, 60)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Modric` matches the expected value (`60`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Modric` and store it in the `weight` variable.
    var weight = Modric.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`60`).
    assertEquals(weight, 50)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Modric` matches the expected value (`40`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Modric` and store it in the `mana` variable.
    var mana = Modric.getMana
    // Compare the actual mana value (`mana`) with the expected value (`40`).
    assertEquals(mana, 50)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Modric` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Modric.haveWeapon, None)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Wand`) on the character `Modric`.
   */
  test("putWeapon") {
    // Create a new `Wand` instance (`Baston`) associated with `Modric`.
    var Baston: Wand = new Wand(Modric)
    // Equip the `Baston` weapon on the character `Modric` using the `putWeapon` method.
    Modric.putWeapon(Baston)
    // Verify if the character `Modric` now has the `Baston` weapon equipped (returns `Some(Baston)`).
    assertEquals(Modric.haveWeapon, Some(Baston))
  }

  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Iniesta`) when `Modric` attacks with a `Wand`.
   */
  test("attackEnemy") {
    // Equip `Modric` with a `Wand`.
    Modric.putWeapon(new Wand(Modric))

    // `Modric` attacks `Iniesta` using the `attackEnemy` method and retrieves the inflicted damage (`daño`).
    val damage: Int = Modric.attackEnemy(Iniesta)

    // Calculate the expected damage based on `Modric`'s attack power (Baston's attack - `Iniesta`'s defense).
    val expectedDamage: Int = 50 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }

  /**
   * Test case for `wasAttacked` method.
   * This test verifies the behavior of the `wasAttacked` method in response to inflicted damage on the character `Modric`.
   */
  test("wasAttacked") {
    // Verify if `Modric`'s health points (`getHp`) decrease correctly after receiving 25 damage.
    assertEquals(Modric.wasAttacked(25).getHp, 65) // 90 health points - 25 damage -> 65 health points

    // Verify if `Modric`'s health points (`getHp`) become 0 after receiving 100 damage (exceeds total health).
    assertEquals(Modric.wasAttacked(100).getHp, 0) // 90 health points - 100 damage -> 0 health points
  }
}

