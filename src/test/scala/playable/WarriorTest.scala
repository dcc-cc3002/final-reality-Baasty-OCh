package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class WarriorTest extends FunSuite {
  var Casemiro: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Busquets: Enemy = _ // Declaration of a variable `Busquets` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Casemiro` with new instances of `Warrior`.
    Casemiro = new Warrior("Casemiro")
    // Initialize `Busquets` with new instances of `Enemy`.
    Busquets = new Enemy("Busquets")
  }

}
