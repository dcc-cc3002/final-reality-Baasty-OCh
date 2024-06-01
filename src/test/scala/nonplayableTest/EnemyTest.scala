package nonplayableTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.Paladin
import munit.FunSuite
/**
 * Test suite for the Enemy class.
 *
 * This suite contains tests for the Enemy class, which represents enemy game units.
 * It includes tests for methods such as equals, setName, setWeight, setAttack, setDefencePoints, attack, and wasInjure.
 */
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _ // We declare a variable Neymar of type Enemy
  var Pedro : Enemy = _  // We declare a variable Bale of type Enemy
  var Cristiano: Playable = _

  /**
   * Sets up the test environment before each test case.
   *
   * This method creates instances of the Enemy class with specific parameters:
   * - Neymar: Name - Neymar, Weight - 60, Attack - 90, Life - 70, Defence - 30
   * - Pedro: Name - Pedro, Weight - 40, Attack - 1, Life - 55, Defence - 1
   * It also creates an instance of the Paladin class named Cristiano.
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Neymar = new Enemy("Neymar")
    Pedro = new Enemy("Pedro",40,1,55,1)
    Cristiano= new Paladin("Cristiano")
  }

  /**
   * Test case for the 'equals' method.
   *
   * This test verifies the equality comparison functionality of the Enemy class.
   * It checks if Neymar is equal to itself, Pedro, and Cristiano, and returns true, false, false respectively.
   */
  test("equals") {
    assertEquals(Neymar.equals(Neymar),true)
    assertEquals(Neymar.equals(Pedro),false)
    assertEquals(Neymar.equals(Cristiano),false)
  }

  /**
   * Test case for the 'setName' method.
   *
   * This test verifies the functionality of the setName method by checking if the name of Neymar is set correctly.
   */
  test("setName") {
    assertEquals(Neymar.getName, "Neymar")
  }

  /**
   * Test case for the 'setWeight' method.
   *
   * This test verifies the functionality of the setWeight method by checking if the weight of Neymar is set correctly.
   */
  test("setWeight") {
    assertEquals(Neymar.getWeight, 50)
  }

  /**
   * Test case for the 'setAttack' method.
   *
   * This test verifies the functionality of the setAttack method by checking if the attack of Neymar is set correctly.
   */
  test("setAttack") {
    assertEquals(Neymar.getAttack, 80)
  }

  /**
   * Test case for the 'setDefencePoints' method.
   *
   * This test verifies the functionality of the setDefencePoints method by checking if the defence points of Neymar are set correctly.
   */
  test("setDefencePoints"){
    assertEquals(Neymar.getDp,50)
  }

  /**
   * Test case for the 'attack' method.
   *
   * This test checks the attack functionality of Neymar and Pedro against a playable game unit.
   * It verifies if the target was attacked successfully and if the damage was not enough in Pedro's case.
   */
  test("attack"){
    assertEquals(Neymar.attack(Cristiano), "The target was Attack")
    assertEquals(Pedro.attack(Cristiano),"The enemy was Attack, but the damage is not enough")
  }

  /**
   * Test case for verifying if an exception is thrown when Neymar attacks a game unit.
   *
   * This test checks if Neymar attempts to attack Pedro, who is an ally.
   * The expected exception message is returned since Neymar cannot attack allies.
   */
  test("It should throw an exception if the Enemy Neymar cant attack game unit"){
    assertEquals(Neymar.attack(Pedro), "The character: Neymar can't attack an Allie")
  }

  /**
   * Test case for the 'wasInjure' method.
   *
   * This test checks the functionality of the wasInjure method by simulating Neymar being attacked with different damage values.
   * It verifies if Neymar's life points decrease correctly after being attacked.
   */
  test("wasInjure"){
    Neymar.wasAttacked(25)
    assertEquals(Neymar.getLife,225)
    Neymar.wasAttacked(300)
    assertEquals(Neymar.getLife,0)
  }
}




