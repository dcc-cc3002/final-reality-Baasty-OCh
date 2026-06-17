package spellTest.light

import model.nonplayable.{Enemy, NonPlayable}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.light.Paralysis
import model.weapons.Weapon
import model.weapons.magic.Staff
import munit.FunSuite

/**
 * A test suite for testing the functionality of the Paralysis spell.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class ParalysisTest extends FunSuite {

  /**
   * A variable representing the Paralysis spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Paralysis: Spell = _

  /**
   * A variable representing a White Magician named Guler.
   * This variable is initialized in the beforeEach method.
   */
  var Guler: WhiteMagican = _
  var Yamal: NonPlayable = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Paralysis = new Paralysis()
    Guler = new WhiteMagican("Arda")
    Yamal = new Enemy("Yamal")
  }

  /**
   * Test case to check if the Paralysis spell can be selected by the White Magician Guler.
   * This test verifies that the Paralysis spell can be selected by Guler.
   */
  test("canSelectedBy") {
    assertEquals(Paralysis.canBeSelectedBy(Guler), true)
  }
  test("Effect"){
    val w: Weapon = new Staff()
    Guler.putWeapon(w)
    Guler.selectSpell(Paralysis)
    Guler.throwSpell(Yamal)
    assertEquals(Yamal.getStatus, "Paralyzed")

  }
}
