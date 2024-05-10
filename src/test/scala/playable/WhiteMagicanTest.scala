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
}
