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
    Modric = new Warrior("Modric")
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

}

