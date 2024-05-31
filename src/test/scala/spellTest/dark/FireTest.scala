package spellTest.dark

import model.playable.magic.BlackMagican
import model.spell.Spell
import model.spell.dark.Fire
import munit.FunSuite

class FireTest extends FunSuite{
  var Fire: Spell = _
  var Brahim: BlackMagican = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Fire = new Fire()
    Brahim = new BlackMagican("Brahim")
  }

  test("canSelectedBy"){
    assertEquals(Fire.canBeSelectedBy(Brahim),true) // resto de casos seran probados en flujo de select spell en clases de pj magicos
  }


}
