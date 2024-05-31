package playableTest.magicTest

import model.playable.Playable
import model.playable.magic.{AMagicPlayable, BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.weapons.Weapon
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

class AMagicPlayableTest extends FunSuite{
  var Kopa: AMagicPlayable = _
  var Gento: AMagicPlayable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {

    Kopa = new BlackMagican("Kopa")
    Gento = new WhiteMagican("Gento")
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character BlackMagican `Kopa` and WhiteMagican 'Gento'
   * matches the expected values (50,40).
   */
  test("getMana") {
    assertEquals(Kopa.getMana, 50)
    assertEquals(Gento.getMana, 40)
  }

  /**
   * Test case for 'setMana' method.
   * This test verifies if the returned mana value for the character BlackMagican `Kopa` and WhiteMagican 'Gento'
   * matches the expected value (90).
   */
  test("setMana"){
    Kopa.setMana(90)
    Gento.setMana(90)

    assertEquals(Kopa.getMana,90)
    assertEquals(Gento.getMana,90)
  }

  test("hasSpell"){
    assertEquals(Kopa.hasSpell, None)
    assertEquals(Gento.hasSpell, None)
  }

  test("hasEnoughMana"){
    var Fire : Spell = new Fire()
    var Thunder : Spell = new Thunder()
    Kopa.setMana(100)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.hasEnoughMana, "It is Enough")

    Gento.setMana(5)
    Gento.selectSpell(Thunder)
    assertEquals(Gento.hasEnoughMana, "The character Gento has not the enough mana to use the Spell")
  }

  test("checkMana"){
    var Fire : Spell = new Fire()
    var Thunder : Spell = new Thunder()
    Kopa.setMana(100)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.checkMana, true)
  }


}
