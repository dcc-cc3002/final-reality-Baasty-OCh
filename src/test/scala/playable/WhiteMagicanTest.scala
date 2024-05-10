package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.{APlayable, Ninja, Paladin, Playable, Warrior, WhiteMagican}
import munit.FunSuite
/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class WhiteMagicanTest extends FunSuite {
  var Benzema: Playable = _ // Declaration of a variable `Benzema` of type `Playable`.
  var Ter_Stegen: Enemy = _ // Declaration of a variable `Ter_Stegen` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Modric` with new instances of `Ninja`.
    Benzema = new WhiteMagican("Benzema")
    // Initialize `Ter_Stegen` with new instances of `Enemy`.
    Ter_Stegen = new Enemy("Ter_Stegen")
  }
  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Benzema`) are considered equal.
   */
  test("equals") {
    assertEquals(Benzema, Benzema)
  }
  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Benzema`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Benzema` and store it in the `name` variable.
    var name = Benzema.getName
    // Compare the actual name value (`name`) with the expected value ("Benzema").
    assertEquals(name, "Benzema")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Benzema` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Benzema` and store it in the `life` variable.
    var life = Benzema.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 100)
  }
  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Benzema` matches the expected value (`80`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Benzema` and store it in the `defense` variable.
    var defense = Benzema.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`80`).
    assertEquals(defense, 80)
  }
  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Benzema` matches the expected value (`60`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Benzema` and store it in the `weight` variable.
    var weight = Benzema.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`60`).
    assertEquals(weight, 60)
  }
  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Benzema` matches the expected value (`40`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Benzema` and store it in the `mana` variable.
    var mana = Benzema.getMana
    // Compare the actual mana value (`mana`) with the expected value (`40`).
    assertEquals(mana, 40)
  }
  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Benzema` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Benzema.haveWeapon, None)
  }
  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Staff`) on the character `Benzema`.
   */
  test("putWeapon") {
    // Create a new `Staff` instance (`Baston`) associated with `Benzema`.
    var Baston: Staff = new Staff(Benzema)
    // Equip the `Arco` weapon on the character `Benzema` using the `putWeapon` method.
    Benzema.putWeapon(Baston)
    // Verify if the character `Benzema` now has the `Baston` weapon equipped (returns `Some(Baston)`).
    assertEquals(Benzema.haveWeapon, Some(Baston))
  }
  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Rakitic`) when `Modric` attacks with a `Bow`.
   */
  test("attackEnemy") {
    // Equip `Benzema` with a `Staff`.
    Benzema.putWeapon(new Staff(Benzema))

    // `Benzema` attacks `Ter_Stegen` using the `attackEnemy` method and retrieves the inflicted damage (`daño`).
    val damage: Int = Benzema.attackEnemy(Ter_Stegen)

    // Calculate the expected damage based on `Benzema`'s attack power (Baston's attack - `Ter_Stegen`'s defense).
    val expectedDamage: Int = 70 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }

}
