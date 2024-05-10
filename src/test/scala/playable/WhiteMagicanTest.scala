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

}
