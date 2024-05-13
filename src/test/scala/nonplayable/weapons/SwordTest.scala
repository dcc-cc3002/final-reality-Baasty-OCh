package nonplayable.weapons

import model.nonplayable.weapons.Sword
import model.nonplayable.NonPlayable
import model.playable.Playable
import model.nonplayable.weapons.Bow
import munit.FunSuite

/**
 * Test suite for the `Sword` class.
 * This class contains tests for various functionalities of the `Sword` class.
 */
class SwordTest extends FunSuite {
  var Espada: Sword = _ // Declaration of a variable `Espada` of type `Bow`.
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Espada2: Sword = _
  var Arco: Bow = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the `Bow` class with the specified parameters:
    Espada = new Sword() // - Name: Espada // - Weight: 25 // - Attack: 50 // - Owner: Modric
    Espada2 = new Sword("Espada2",40,40,0)
    Arco = new Bow()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same sword (`Espada`) are considered equal.
   */
  test("equals") {
    assertEquals(Espada.equals(Espada),true)
    assertEquals(Espada.equals(Espada2),false)
    assertEquals(Espada.equals(Arco), false)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a sword (`Espada`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the sword `Espada` and store it in the `name2` variable.
    var name2 = Espada.getName
    // Compare the actual name value (`name2`) with the expected value ("Espada").
    assertEquals(name2, "Espada")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for a sword (`Espada`) matches the expected value (`25`).
   */
  test("getWeight") {
    // Retrieve the weight value of the sword `Espada` and store it in the `weight` variable.
    var weight = Espada.getWeight
    // Define the expected weight value.
    var expected: Int = 70
    // Compare the actual weight value (`weight`) with the expected value (`expected`).
    assertEquals(weight, expected)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for a sword (`Espada`) matches the expected value (`50`).
   */
  test("getAttack") {
    // Retrieve the attack value of the sword `Espada` and store it in the `attack` variable.
    var attack = Espada.getAttack
    // Define the expected attack value.
    var expected: Int = 70
    // Compare the actual attack value (`attack`) with the expected value (`expected`).
    assertEquals(attack, expected)
  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for a sword (`Espada`) matches the expected character (`Cristiano`).
   */
  test("getOwner") {
    // Retrieve the owner character of the sword `Espada` and store it in the `owner` variable.
    var owner: Any = Espada.getOwner
    // Define the expected owner character.
    // Compare the actual owner character (`owner`) with the expected character (`expected`).
    assertEquals(owner, None)
  }

  /**
   * Test case for `getMAP` method.
   * This test verifies if the returned magic attack points value for a sword (`Espada`) matches the expected value (`0`).
   */
  test("getMAP") {
    assertEquals(Espada.getMAP, 0)
  }
}

