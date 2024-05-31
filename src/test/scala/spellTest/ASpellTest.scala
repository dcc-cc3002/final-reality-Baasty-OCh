package spellTest

import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}
import munit.FunSuite

class ASpellTest extends FunSuite{
  var Fire: Spell = _
  var Thunder: Spell = _
  var Healing: Spell = _
  var Paralysis: Spell = _
  var Poison: Spell = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Fire = new Fire()
    Thunder = new Thunder()
    Healing = new Healing()
    Paralysis = new Paralysis()
    Poison = new Poison()
  }

  test("getCost"){
    assertEquals(Fire.getCost,15)
    assertEquals(Thunder.getCost,20)
    assertEquals(Healing.getCost,15)
    assertEquals(Paralysis.getCost,25)
    assertEquals(Poison.getCost,30)
  }

}
