package spellTest.dark

import model.nonplayable.Enemy
import model.playable.magic.BlackMagican
import model.spell.Spell
import model.spell.dark.Fire
import model.weapons.magic.{Staff, Wand}
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
  var Pedri: Enemy = _

  /**
   * Sets up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Fire = new Fire()
    Brahim = new BlackMagican("Brahim")
    Pedri = new Enemy(("Pedri"))
  }

  /**
   * Test case to check if the Fire spell can be selected by the Black Magician Brahim.
   * This test verifies that the Fire spell can be selected by Brahim.
   */
  test("canSelectedBy") {
    assertEquals(Fire.canBeSelectedBy(Brahim), true)
  }
  test("Effect with Wand"){
    Brahim.putWeapon(new Wand())
    Brahim.selectSpell(Fire)
    Fire.Effect(Pedri,1)
    assertEquals(Pedri.getStatus,"Quemado con Varita")
  }
  test("Effect with Staff"){
    Brahim.putWeapon(new Staff())
    Brahim.selectSpell(Fire)
    Fire.Effect(Pedri,1)
    assertEquals(Pedri.getStatus,"Quemado con Baston")
  }

}
