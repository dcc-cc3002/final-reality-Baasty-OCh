package spellTest.dark

import model.nonplayable.Enemy
import model.playable.magic.BlackMagican
import model.spell.Spell
import model.spell.dark.Thunder
import model.weapons.magic.Staff
import munit.FunSuite

/**
 * A test suite for testing the functionality of the Thunder spell.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class ThunderTest extends FunSuite {

  /**
   * A variable representing the Thunder spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Thunder: Spell = _

  /**
   * A variable representing a Black Magician named Brahim.
   * This variable is initialized in the beforeEach method.
   */
  var Brahim: BlackMagican = _
  var Pedri: Enemy = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Thunder = new Thunder()
    Brahim = new BlackMagican("Brahim")
    Pedri = new Enemy("Pedri")
  }

  /**
   * Test case to check if the Thunder spell can be selected by the Black Magician Brahim.
   * This test verifies that the Thunder spell can be selected by Brahim.
   */
  test("canSelectedBy") {
    assertEquals(Thunder.canBeSelectedBy(Brahim), true)
  }
  test("Effect"){
    Brahim.putWeapon(new Staff())
    Brahim.selectSpell(Thunder)
    Thunder.Effect(Pedri,1)
    assertEquals(Pedri.getStatus,"Paralizado")
  }

}
