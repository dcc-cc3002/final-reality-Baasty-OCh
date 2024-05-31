package spellTest.light

import model.playable.magic.WhiteMagican
import model.spell.Spell
import model.spell.light.Poison
import munit.FunSuite


class PoisonTest extends  FunSuite{
  var Poison : Spell = _
  var Guler : WhiteMagican = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Poison = new Poison()
    Guler = new WhiteMagican("Arda")
  }
  test("canSelectedBy"){
    assertEquals(Poison.canBeSelectedBy(Guler),true)
  }
}
