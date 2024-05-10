package playable

import model.nonplayable.weapons.{AWeapon, Axe}
import model.nonplayable.{Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Pique: Enemy = _ // Declaration of a variable `Pique` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Cristiano` with new instances of `Paladin`.
    Cristiano = new Paladin("Cristiano")
    // Initialize `Pique` with new instances of `Enemy`.
    Pique = new Enemy("Pique")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Cristiano`) are considered equal.
   */
  test("equals") {
    assertEquals(Cristiano, Cristiano)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Cristiano`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Cristiano` and store it in the `name` variable.
    var name = Cristiano.getName
    // Compare the actual name value (`name`) with the expected value ("Cristiano").
    assertEquals(name, "Cristiano")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Cristiano` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Cristiano` and store it in the `life` variable.
    var life = Cristiano.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 100)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Cristiano` matches the expected value (`75`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Cristiano` and store it in the `defense` variable.
    var defense = Cristiano.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`75`).
    assertEquals(defense, 75)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Cristiano` matches the expected value (`50`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Cristiano` and store it in the `weight` variable.
    var weight = Cristiano.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`50`).
    assertEquals(weight, 50)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Cristiano` matches the expected value (`0`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Cristiano` and store it in the `mana` variable.
    var mana = Cristiano.getMana
    // Compare the actual mana value (`mana`) with the expected value (`0`).
    assertEquals(mana, 0)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Cristiano` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Cristiano.haveWeapon, None)
  }
  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Espada`) on the character `Cristiano`.
   */
  test("putWeapon") {
    // Create a new `Sword` instance (`Espada`) associated with `Cristiano`.
    var Espada: Sword = new Sword(Cristiano)
    // Equip the `Espada` weapon on the character `Cristiano` using the `putWeapon` method.
    Cristiano.putWeapon(Espada)
    // Verify if the character `Cristiano` now has the `Espada` weapon equipped (returns `Some(Espada)`).
    assertEquals(Cristiano.haveWeapon, Some(Espada))
  }
  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Pique`) when `Cristiano` attacks with a `Sword`.
   */
  test("attackEnemy") {
    // Equip `Cristiano` with a `Sword`.
    Cristiano.putWeapon(new Sword())

    // `Cristiano` attacks `Pique` using the `attackEnemy` method and retrieves the inflicted damage (`daño`).
    val damage: Int = Cristiano.attackEnemy(Pique)

    // Calculate the expected damage based on `Cristiano`'s attack power (Sword's attack - `Pique`'s defense).
    val expectedDamage: Int = 70 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }
  /**
   * Test case for `wasAttacked` method.
   * This test verifies the behavior of the `wasAttacked` method in response to inflicted damage on the character `Cristiano`.
   */
  test("wasAttacked") {
    // Verify if `Cristiano`'s health points (`getHp`) decrease correctly after receiving 25 damage.
    assertEquals(Cristiano.wasAttacked(25).getHp, 75) // 100 health points - 25 damage -> 75 health points

    // Verify if `Cristiano`'s health points (`getHp`) become 0 after receiving 125 damage (exceeds total health).
    assertEquals(Cristiano.wasAttacked(125).getHp, 0) // 100 health points - 125 damage -> 0 health points
  }

}


