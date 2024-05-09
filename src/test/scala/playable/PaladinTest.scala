package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Pele: Playable = _ // Declaration of a variable `Pele` of type `Playable`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Cristiano` and `Pele` with new instances of `Paladin`.
    Cristiano = new Paladin("Cristiano")
    Pele = new Paladin("Pele", 30, 50, 90, 0)
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
  test("getHealthPoints") {
    // Retrieve the name value of the character `Cristiano` and store it in the `name` variable.
    var life = Cristiano.getHp
    // Compare the actual name value (`name`) with the expected value ("Cristiano").
    assertEquals(life, 100)
  }
  test("getDefencePoints") { // Test if the returned defense value for a character matches the expected value
    var defense = Cristiano.getDp // Retrieve the defense value of the character Cristiano and store it in the 'defense' variable
    assertEquals(defense, 75) // Compare the actual defense value with the expected value
    }


}


