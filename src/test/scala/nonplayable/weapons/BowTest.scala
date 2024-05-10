package nonplayable.weapons

import model.nonplayable.weapons.Axe
import model.nonplayable.NonPlayable
import model.playable.Playable
import model.nonplayable.weapons.Bow
import munit.FunSuite

/**
 * Test suite for the `Bow` class.
 * This class contains tests for various functionalities of the `Bow` class.
 */
class BowTest extends FunSuite {
  var Arco: Bow = _ // Declaration of a variable `Arco` of type `Bow`.
  var Kroos: Playable = _ // Declaration of a variable `Kroos` of type `Playable`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the `Bow` class with the specified parameters:
    Arco = new Bow(Kroos) // - Name: Arco // - Weight: 25 // - Attack: 50 // - Owner: Modric
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same bow (`Arco`) are considered equal.
   */
  test("equals") {
    assertEquals(Arco, Arco)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a bow (`Arco`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the bow `Arco` and store it in the `name2` variable.
    var name2 = Arco.getName
    // Compare the actual name value (`name2`) with the expected value ("Arco").
    assertEquals(name2, "Arco")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for a bow (`Arco`) matches the expected value (`25`).
   */
  test("getWeight") {
    // Retrieve the weight value of the bow `Arco` and store it in the `weight` variable.
    var weight = Arco.getWeight
    // Define the expected weight value.
    var expected: Int = 25
    // Compare the actual weight value (`weight`) with the expected value (`expected`).
    assertEquals(weight, expected)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for a bow (`Arco`) matches the expected value (`50`).
   */
  test("getAttack") {
    // Retrieve the attack value of the bow `Arco` and store it in the `attack` variable.
    var attack = Arco.getAttack
    // Define the expected attack value.
    var expected: Int = 50
    // Compare the actual attack value (`attack`) with the expected value (`expected`).
    assertEquals(attack, expected)
  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for a bow (`Arco`) matches the expected character (`Kroos`).
   */
  test("getOwner") {
    // Retrieve the owner character of the bow `Arco` and store it in the `owner` variable.
    var owner: Any = Arco.getOwner
    // Define the expected owner character.
    var expected: Playable = Kroos
    // Compare the actual owner character (`owner`) with the expected character (`expected`).
    assertEquals(owner, expected)
  }

  /**
   * Test case for `getMAP` method.
   * This test verifies if the returned magic attack points value for a bow (`Arco`) matches the expected value (`0`).
   */
  test("getMAP") {
    assertEquals(Arco.getMAP, 0)
  }
}

