package playableTest.magicTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.magic.{AMagicPlayable, BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.Healing
import model.weapons.Weapon
import model.weapons.magic.{Staff, Wand}
import munit.{FunSuite, Slow}

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

  /**
   * Test case for 'hasEnoughMana' method.
   * This test verifies if the character has enough mana to use a selected spell.
   * It checks if the character BlackMagican `Kopa` with 100 mana can use the `Fire` spell
   * and if the character WhiteMagican `Gento` with 5 mana cannot use the `Healing` spell.
   */
  test("hasEnoughMana"){
    var Fire : Spell = new Fire()
    var Healing : Spell = new Healing()
    Kopa.setMana(100)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.hasEnoughMana, "It is Enough")

    Gento.setMana(5)
    Gento.selectSpell(Healing)
    assertEquals(Gento.hasEnoughMana, "The character Gento has not the enough mana to use the Spell")
  }

  /**
   * Test case for 'throwSpell' method.
   * This test verifies if the character can successfully throw the selected spell at a target.
   * It checks if the character BlackMagican `Kopa` with a `Staff` and `Fire` spell can throw the spell at the enemy `Laudrup`
   * and if the character WhiteMagican `Gento` with a `Wand` and `Healing` spell can throw the spell at `Kopa`.
   * Both cases are expected to return "nice spell".
   */
  test("throwSpell"){
    var Staff : Staff = new Staff()
    var Wand : Wand = new Wand()
    var Fire : Spell = new Fire()
    var Healing : Spell = new Healing()
    var Laudrup: Enemy = new Enemy("Laudrup")
    Kopa.putWeapon(Staff)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.throwSpell(Laudrup), "nice spell")

    Gento.putWeapon(Wand)
    Gento.selectSpell(Healing)
    assertEquals(Gento.throwSpell(Kopa), "nice spell")

  }

  /**
   * Test case for handling invalid spell targets.
   * This test verifies if the appropriate exception is thrown when a character tries to cast a spell on an invalid target.
   * It checks if the character BlackMagican `Kopa` with a `Staff` and `Fire` spell cannot cast the spell on `Gento`
   * and if the character WhiteMagican `Gento` with a `Wand` and `Healing` spell cannot cast the spell on `Laudrup`.
   * Both cases are expected to return "The spell can not act in that target".
   */
  test("It should throw an exception if the Magic Playable cant throw a spell on specific target"){
    var Staff : Staff = new Staff()
    var Wand : Wand = new Wand()
    var Fire : Spell = new Fire()
    var Healing : Spell = new Healing()
    var Laudrup: Enemy = new Enemy("Laudrup")
    Kopa.putWeapon(Staff)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.throwSpell(Gento), "The spell can not act in that target")

    Gento.putWeapon(Wand)
    Gento.selectSpell(Healing)
    assertEquals(Gento.throwSpell(Laudrup), "The spell can not act in that target")
  }


}
