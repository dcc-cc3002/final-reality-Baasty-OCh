package spellTest

import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}
import munit.FunSuite

/**
 * A test suite for testing various spell functionalities.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class ASpellTest extends FunSuite {

  /**
   * A variable representing the Fire spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Fire: Spell = _

  /**
   * A variable representing the Thunder spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Thunder: Spell = _

  /**
   * A variable representing the Healing spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Healing: Spell = _

  /**
   * A variable representing the Paralysis spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Paralysis: Spell = _

  /**
   * A variable representing the Poison spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Poison: Spell = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Fire = new Fire()
    Thunder = new Thunder()
    Healing = new Healing()
    Paralysis = new Paralysis()
    Poison = new Poison()
  }

  /**
   * Test case to check the cost of various spells.
   * This test verifies that the cost of each spell is correctly returned by the getCost method.
   */
  test("getCost") {
    assertEquals(Fire.getCost, 15)
    assertEquals(Thunder.getCost, 20)
    assertEquals(Healing.getCost, 15)
    assertEquals(Paralysis.getCost, 25)
    assertEquals(Poison.getCost, 30)
  }
}
