package nonplayable.weapons

import model.nonplayable.weapons.Staff
import model.nonplayable.NonPlayable
import model.playable.Playable
import model.nonplayable.weapons.Bow
import munit.FunSuite

/**
 * Test suite for the `Staff` class.
 * This class contains tests for various functionalities of the `Staff` class.
 */
class StaffTest extends FunSuite {
  var Baston: Bow = _ // Declaration of a variable `Baston` of type `Bow`.
  var Benzema: Playable = _ // Declaration of a variable `Benzema` of type `Playable`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the `Bow` class with the specified parameters:
    Baston = new Bow(Benzema) // - Name: Baston // - Weight: 25 // - Attack: 50 // - Owner: Modric
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same staff (`Baston`) are considered equal.
   */
  test("equals") {
    assertEquals(Baston, Baston)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a staff (`Baston`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the staff `Baston` and store it in the `name2` variable.
    var name2 = Baston.getName
    // Compare the actual name value (`name2`) with the expected value ("Baston").
    assertEquals(name2, "Baston")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for a staff (`Baston`) matches the expected value (`25`).
   */
  test("getWeight") {
    // Retrieve the weight value of the staff `Baston` and store it in the `weight` variable.
    var weight = Baston.getWeight
    // Define the expected weight value.
    var expected: Int = 25
    // Compare the actual weight value (`weight`) with the expected value (`expected`).
    assertEquals(weight, expected)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for a staff (`Baston`) matches the expected value (`50`).
   */
  test("getAttack") {
    // Retrieve the attack value of the staff `Baston` and store it in the `attack` variable.
    var attack = Baston.getAttack
    // Define the expected attack value.
    var expected: Int = 50
    // Compare the actual attack value (`attack`) with the expected value (`expected`).
    assertEquals(attack, expected)
  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for a staff (`Baston`) matches the expected character (`Benzema`).
   */
  test("getOwner") {
    // Retrieve the owner character of the staff `Baston` and store it in the `owner` variable.
    var owner: Any = Baston.getOwner
    // Define the expected owner character.
    var expected: Playable = Benzema
    // Compare the actual owner character (`owner`) with the expected character (`expected`).
    assertEquals(owner, expected)
  }

  /**
   * Test case for `getMAP` method.
   * This test verifies if the returned magic attack points value for a staff (`Baston`) matches the expected value (`0`).
   */
  test("getMAP") {
    assertEquals(Baston.getMAP, 0)
  }
}

