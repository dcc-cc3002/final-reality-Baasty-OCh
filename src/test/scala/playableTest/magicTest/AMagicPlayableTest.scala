package playableTest.magicTest

import exceptions.spells.InvalidNoEnoughMana
import model.nonplayable.Enemy
import model.playable.magic.{AMagicPlayable, BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.dark.Fire
import model.spell.light.Healing
import model.weapons.Weapon
import model.weapons.common.{Bow, Sword}
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

  test("Style"){
    assertEquals(Kopa.Style(Kopa), "magicPlayable")
    assertEquals(Gento.Style(Gento), "magicPlayable")
  }


  test("IsMagic"){
    assertEquals(Kopa.IsMagic(Kopa), 2)
    assertEquals(Gento.IsMagic(Gento), 2)
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
    val Fire : Spell = new Fire()
    val Healing : Spell = new Healing()
    Kopa.setMana(100)
    Kopa.selectSpell(Fire)
    assert(Kopa.hasEnoughMana == "It is Enough")

    Gento.setMana(5)
    Gento.selectSpell(Healing)
    val thrown = intercept[InvalidNoEnoughMana] {
      Gento.hasEnoughMana
    }
    assert(thrown.getMessage == "The character Gento does not have enough mana to use the spell.")
  }

  /**
   * Verifies if a character has a magic weapon equipped.
   * This test checks if the characters 'Kopa' and 'Gento' have magic weapons equipped.
   * For 'Kopa', the test verifies if equipping a Staff or a Wand results in the character having a magic weapon.
   * For 'Gento', the test verifies if equipping a Staff or a Wand results in the character having a magic weapon.
   * The expected return value is "Yes" if the character has a magic weapon, and "The weapon is not magic" otherwise.
   */
  test("hasMagicWeapon"){
    val Staff: Weapon = new Staff()
    val Wand: Weapon = new Wand()
    val Sword: Weapon = new Sword()
    val Bow: Weapon = new Bow()
    Kopa.putWeapon(Staff)
    assertEquals(Kopa.hasMagicWeapon, "Yes")

    Kopa.putWeapon(Wand)
    assertEquals(Kopa.hasMagicWeapon, "Yes")

    Kopa.putWeapon(Sword)
    assertEquals(Kopa.hasMagicWeapon, "The weapon is not magic")

    Gento.putWeapon(Staff)
    assertEquals(Gento.hasMagicWeapon, "Yes")

    Gento.putWeapon(Wand)
    assertEquals(Gento.hasMagicWeapon, "Yes")

    Gento.putWeapon(Bow)
    assertEquals(Gento.hasMagicWeapon, "The weapon is not magic")
  }

  /**
   * Test case for 'throwSpell' method.
   * This test verifies if the character can successfully throw the selected spell at a target.
   * It checks if the character BlackMagican `Kopa` with a `Staff` and `Fire` spell can throw the spell at the enemy `Laudrup`
   * and if the character WhiteMagican `Gento` with a `Wand` and `Healing` spell can throw the spell at `Kopa`.
   * Both cases are expected to return "nice spell".
   */
  test("throwSpell"){
    val Staff : Staff = new Staff()
    val Wand : Wand = new Wand()
    val Fire : Spell = new Fire()
    val Healing : Spell = new Healing()
    val Laudrup: Enemy = new Enemy("Laudrup")
    Kopa.putWeapon(Staff)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.throwSpell(Laudrup), "Nice spell")

    Gento.putWeapon(Wand)
    Gento.selectSpell(Healing)
    assertEquals(Gento.throwSpell(Kopa), "Nice spell")
  }

  /**
   * Test case for handling invalid spell targets.
   * This test verifies if the appropriate exception is thrown when a character tries to cast a spell on an invalid target.
   * It checks if the character BlackMagican `Kopa` with a `Staff` and `Fire` spell cannot cast the spell on `Gento`
   * and if the character WhiteMagican `Gento` with a `Wand` and `Healing` spell cannot cast the spell on `Laudrup`.
   * Both cases are expected to return "The spell can not act in that target".
   */
  test("It should throw an exception if the Magic Playable cant throw a spell on specific target"){
    val Staff : Staff = new Staff()
    val Wand : Wand = new Wand()
    val Fire : Spell = new Fire()
    val Healing : Spell = new Healing()
    val Laudrup: Enemy = new Enemy("Laudrup")
    Kopa.putWeapon(Staff)
    Kopa.selectSpell(Fire)
    assertEquals(Kopa.throwSpell(Gento), "The spell cannot act on that target")

    Gento.putWeapon(Wand)
    Gento.selectSpell(Healing)
    assertEquals(Gento.throwSpell(Laudrup), "The spell cannot act on that target")
  }
}
