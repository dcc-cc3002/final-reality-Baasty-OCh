package spellTest.dark

import model.playable.magic.BlackMagican
import model.spell.Spell
import model.spell.dark.Fire
import munit.FunSuite

/**
 * A test suite for testing the functionality of the Fire spell.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class FireTest extends FunSuite {

  /**
   * A variable representing the Fire spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Fire: Spell = _

  /**
   * A variable representing a Black Magician named Brahim.
   * This variable is initialized in the beforeEach method.
   */
  var Brahim: BlackMagican = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Fire = new Fire()
    Brahim = new BlackMagican("Brahim")
  }

  /**
   * Test case to check if the Fire spell can be selected by the Black Magician Brahim.
   * This test verifies that the Fire spell can be selected by Brahim.
   */
  test("canSelectedBy") {
    assertEquals(Fire.canBeSelectedBy(Brahim), true)
  }

}
