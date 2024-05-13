package nonplayable.weapons

import model.nonplayable.weapons.{Axe, Bow, Sword}
import model.nonplayable.NonPlayable
import model.playable.{Playable, Warrior}
import munit.FunSuite

/**
 * Test suite for the `Axe` class.
 * This class contains tests for various functionalities of the `Axe` class.
 */
class AxeTest extends FunSuite {
  var Hacha: Axe = _ // Declaration of a variable `Hacha` of type `Axe`.
  var Casemiro: Playable = _ // Declaration of a variable `Casemiro` of type `Playable`.
  var Isco: Playable = _
  var Hacha2: Axe = _
  var Espada: Sword = _
  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the `Axe` class with the specified parameters:
    Hacha = new Axe() // - Name: Hacha // - Weight: 25 // - Attack: 50 // - Owner: Modric
    Hacha2 = new Axe("Hacha2", 50,50,0)
    Espada = new Sword()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same axe (`Hacha`) are considered equal.
   */
  test("equals") {
    assertEquals(Hacha.equals(Hacha),true)
    assertEquals(Hacha.equals(Hacha2),false)
    assertEquals(Hacha.equals(Espada),false)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for an axe (`Hacha`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the axe `Hacha` and store it in the `name2` variable.
    var name2 = Hacha.getName
    // Compare the actual name value (`name2`) with the expected value ("Hacha").
    assertEquals(name2, "Hacha")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for an axe (`Hacha`) matches the expected value (`25`).
   */
  test("getWeight") {
    // Retrieve the weight value of the axe `Hacha` and store it in the `weight` variable.
    var weight = Hacha.getWeight
    // Define the expected weight value.
    var expected: Int = 50
    // Compare the actual weight value (`weight`) with the expected value (`expected`).
    assertEquals(weight, expected)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for an axe (`Hacha`) matches the expected value (`50`).
   */
  test("getAttack") {
    // Retrieve the attack value of the axe `Hacha` and store it in the `attack` variable.
    var attack = Hacha.getAttack
    // Define the expected attack value.
    var expected: Int = 50
    // Compare the actual attack value (`attack`) with the expected value (`expected`).
    assertEquals(attack, expected)
  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for an axe (`Hacha`) matches the expected character (`Casemiro`).
   */
  test("getOwner") {
    // Retrieve the owner character of the axe `Hacha` and store it in the `owner` variable.
    var owner: Any = Hacha.getOwner
    // Define the expected owner character.
    var expected: Playable = Casemiro
    // Compare the actual owner character (`owner`) with the expected character (`expected`).
    assertEquals(owner, expected)
  }

  /**
   * Test case for `getMAP` method.
   * This test verifies if the returned magic attack points value for an axe (`Hacha`) matches the expected value (`0`).
   */
  test("getMAP") {
    assertEquals(Hacha.getMAP, 0)
  }
}

