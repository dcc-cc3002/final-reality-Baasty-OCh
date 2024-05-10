package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class NinjaTest extends FunSuite {
  var Modric: Playable = _ // Declaration of a variable `Modric` of type `Playable`.
  var Rakitic: Enemy = _ // Declaration of a variable `Rakitic` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Modric` with new instances of `Ninja`.
    Modric = new Ninja("Modric")
    // Initialize `Rakitic` with new instances of `Enemy`.
    Rakitic = new Enemy("Rakitic")
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
  }  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Modric` matches the expected value (`80`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Modric` and store it in the `life` variable.
    var life = Modric.getHp
    // Compare the actual health points value (`life`) with the expected value (`80`).
    assertEquals(life, 80)
  }
  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Modric` matches the expected value (`70`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Modric` and store it in the `defense` variable.
    var defense = Modric.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`70`).
    assertEquals(defense, 70)
  }
  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Modric` matches the expected value (`30`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Modric` and store it in the `weight` variable.
    var weight = Modric.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`30`).
    assertEquals(weight, 30)
  }
  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Modric` matches the expected value (`0`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Modric` and store it in the `mana` variable.
    var mana = Modric.getMana
    // Compare the actual mana value (`mana`) with the expected value (`0`).
    assertEquals(mana, 0)
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
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Bow`) on the character `Modric`.
   */
  test("putWeapon") {
    // Create a new `Bow` instance (`Arco`) associated with `Modric`.
    var Arco: Bow = new Bow(Modric)
    // Equip the `Arco` weapon on the character `Modric` using the `putWeapon` method.
    Modric.putWeapon(Arco)
    // Verify if the character `Modric` now has the `Arco` weapon equipped (returns `Some(Arco)`).
    assertEquals(Modric.haveWeapon, Some(Arco))
  }
  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Rakitic`) when `Modric` attacks with a `Bow`.
   */
  test("attackEnemy") {
    // Equip `Modric` with a `Bow`.
    Modric.putWeapon(new Bow(Modric))

    // `Modric` attacks `Rakitic` using the `attackEnemy` method and retrieves the inflicted damage (`daño`).
    val damage: Int = Modric.attackEnemy(Rakitic)

    // Calculate the expected damage based on `Modric`'s attack power (Bow's attack - `Rakitic`'s defense).
    val expectedDamage: Int = 40 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }
  /**
   * Test case for `wasAttacked` method.
   * This test verifies the behavior of the `wasAttacked` method in response to inflicted damage on the character `Modric`.
   */
  test("wasAttacked") {
    // Verify if `Modric`'s health points (`getHp`) decrease correctly after receiving 5 damage.
    assertEquals(Modric.wasAttacked(5).getHp, 75) // 80 health points - 5 damage -> 75 health points

    // Verify if `Modric`'s health points (`getHp`) become 0 after receiving 100 damage (exceeds total health).
    assertEquals(Modric.wasAttacked(100).getHp, 0) // 80 health points - 100 damage -> 0 health points
  }
}

