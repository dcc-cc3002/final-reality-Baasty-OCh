package spellTest.light

import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.light.Paralysis
import munit.FunSuite

class ParalysisTest extends FunSuite{
  var Paralysis : Spell = _
  var Guler : WhiteMagican = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Paralysis = new Paralysis()
    Guler = new WhiteMagican("Arda")
  }
  test("canSelectedBy"){
    assertEquals(Paralysis.canBeSelectedBy(Guler),true) // resto de casos seran probados en flujo de select spell en clases de pj magicos
  }


}
