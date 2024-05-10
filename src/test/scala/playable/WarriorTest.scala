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

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Casemiro`) are considered equal.
   */
  test("equals") {
    assertEquals(Casemiro, Casemiro)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Casemiro`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Casemiro` and store it in the `name` variable.
    var name = Casemiro.getName
    // Compare the actual name value (`name`) with the expected value ("Casemiro").
    assertEquals(name, "Casemiro")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Casemiro` matches the expected value (`120`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Casemiro` and store it in the `life` variable.
    var life = Casemiro.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 120)
  }
  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Casemiro` matches the expected value (`100`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Casemiro` and store it in the `defense` variable.
    var defense = Casemiro.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`100`).
    assertEquals(defense, 100)
  }
}
