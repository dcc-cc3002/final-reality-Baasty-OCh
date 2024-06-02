package spellTest.light

import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.light.Healing
import munit.FunSuite

/**
 * A test suite for testing the functionality of the Healing spell.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class HealingTest extends FunSuite {

  /**
   * A variable representing the Healing spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Healing: Spell = _

  /**
   * A variable representing a White Magician named Guler.
   * This variable is initialized in the beforeEach method.
   */
  var Guler: WhiteMagican = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Healing = new Healing()
    Guler = new WhiteMagican("Arda")
  }

  /**
   * Test case to check if the Healing spell can be selected by the White Magician Guler.
   * This test verifies that the Healing spell can be selected by Guler.
   */
  test("canSelectedBy") {
    assertEquals(Healing.canBeSelectedBy(Guler), true)
  }

}
