package spellTest.light

import model.nonplayable.Enemy
import model.playable.magic.WhiteMagican
import model.spell.Spell
import model.spell.light.Poison
import model.weapons.Weapon
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite


/**
 * A test suite for testing the functionality of the Poison spell.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class PoisonTest extends FunSuite {

  /**
   * A variable representing a Poison spell, which is a type of Spell.
   * This variable is initialized in the beforeEach method.
   */
  var Poison: Spell = _

  /**
   * A variable representing a White Magician named Guler.
   * This variable is initialized in the beforeEach method.
   */
  var Guler: WhiteMagican = _
  var Yamal: Enemy = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Poison = new Poison()
    Guler = new WhiteMagican("Arda")
    Yamal = new Enemy("Yamal")
  }

  /**
   * Test case to check if the Poison spell can be selected by the White Magician Guler.
   * This test verifies that the Poison spell can be selected by Guler.
   */
  test("canSelectedBy") {
    assertEquals(Poison.canBeSelectedBy(Guler), true)
  }
  test("Effect") {
    val w1: Weapon = new Staff()
    Guler.putWeapon(w1)
    Guler.selectSpell(Poison)
    Guler.throwSpell(Yamal)
    assertEquals(Yamal.getStatus, "Poisoned with Staff")
    val w2: Weapon = new Wand()
    Guler.putWeapon(w2)
    Guler.selectSpell(Poison)
    Guler.throwSpell(Yamal)
    assertEquals(Yamal.getStatus, "Poisoned with Wand")

  }
}

