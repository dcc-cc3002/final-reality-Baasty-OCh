package spellTest.light

import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.light.Healing
import munit.FunSuite

class HealingTest extends FunSuite{
  var Healing: Spell = _
  var Guler: WhiteMagican = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Healing = new Healing()
    Guler = new WhiteMagican("Arda")
  }

  test("canSelectedBy"){
    assertEquals(Healing.canBeSelectedBy(Guler),true) // resto de casos seran probados en flujo de select spell en clases de pj magicos
  }

}
