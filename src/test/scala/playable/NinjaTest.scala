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




}

