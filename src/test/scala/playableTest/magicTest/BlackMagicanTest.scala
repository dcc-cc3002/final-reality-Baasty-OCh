package playableTest.magicTest

import model.nonplayable.Enemy
import model.playable.magic.BlackMagican
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}

import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `BlackMagican` class.
 * This class contains tests for various functionalities of the `BlackMagican` class.
 */
class BlackMagicanTest extends FunSuite {
  var Modric: BlackMagican = _
  var Iniesta: Enemy = _
  var James: BlackMagican = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Modric = new BlackMagican("Modric")
    James = new BlackMagican("James",50,60,80,21)
    Iniesta = new Enemy("Iniesta")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Modric`) are considered equal.
   * false in other case.
   */
  test("equals") {
    assertEquals(Modric.equals(Modric),true)
    assertEquals(Modric.equals(James),false)
    assertEquals(Modric.equals(Iniesta),false)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the BlackMagican 'Modric' can Equip particular kind of weapon or not
   * (he can: Staff, Wand and Sword. and can not: Bow and Axe)
   */
  test("canEquip"){
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()

    assertEquals(Modric.canEquipStaff(Baston),true)
    assertEquals(Modric.canEquipWand(Varita),true)
    assertEquals(Modric.canEquipSword(Espada),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Staff' , 'Wand' or 'Sword') on the
   * BlackMagican `Modric`.
   */
  test("putWeapon") {
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Espada: Sword = new Sword()

    assertEquals(Modric.putWeapon(Baston), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Baston))

    assertEquals(Modric.putWeapon(Varita), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Varita))

    assertEquals(Modric.putWeapon(Espada), "The weapon was wear")
    assertEquals(Modric.hasWeapon, Some(Espada))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Modric'
   */
  test("dropWeapon"){
    val Baston: Staff = new Staff()
    Modric.putWeapon(Baston)
    assertEquals(Modric.hasWeapon, Some(Baston))

    Modric.dropWeapon()
    assertEquals(Modric.hasWeapon,None)
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character cannot equip an Axe.
   * This test checks if the character 'Modric' attempts to equip an Axe, which is not allowed for BlackMagican characters.
   * The expected exception message is returned, indicating that Modric cannot equip an Axe.
   */
  test("It should throw an exception if the BlackMagican cant equip an Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Modric.putWeapon(Hacha),"The character: Modric can't wear an Axe")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character cannot equip a Bow.
   * This test checks if the character 'Modric' attempts to equip a Bow, which is not allowed for BlackMagican characters.
   * The expected exception message is returned, indicating that Modric cannot equip a Bow.
   */
  test("It should throw an exception if the BlackMagican cant equip a Bow"){
    val Arco: Bow = new Bow()
    assertEquals(Modric.putWeapon(Arco),"The character: Modric can't wear a Bow")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character attempts to equip a foreign weapon.
   * This test checks if the character 'James' tries to equip a Staff, and then 'Modric' attempts to equip the same Staff,
   * the expected exception message is returned since the Staff 'Baston' already has an owner.
   */
  test("It should throw an exception if the BlackMagican cant equip a foreign weapon"){
    val Baston: Staff = new Staff()
    James.putWeapon(Baston)

    assertEquals(Modric.putWeapon(Baston),"The weapon: Baston already has an owner")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character attempts to attack another ally game unit.
   * This test checks if the character 'Modric' equipped with a Staff attempts to attack the character 'James', who is also an ally.
   * The expected exception message is returned, indicating that Modric cannot attack an ally.
   */
  test("It should throw an exception if the BlackMagican cant attack game unit"){
    val Baston: Staff = new Staff()
    Modric.putWeapon(Baston)

    assertEquals(Modric.attack(James), "The character: Modric can't attack an ally")
  }

  /**
   * Test case for selecting spells by the character.
   * This test checks if the character 'Modric' can successfully select different types of spells such as Fire and Thunder.
   * The expected message indicating successful spell selection is returned for each spell.
   */
  test("SelectSpell"){
    var Fire : Spell = new Fire()
    var Thunder : Spell = new Thunder()

    assertEquals(Modric.selectSpell(Fire), "The spell was selected")
    assertEquals(Modric.selectSpell(Thunder), "The spell was selected")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character attempts to select a Healing spell.
   * This test checks if the character 'Modric' attempts to select a Healing spell, which is not allowed for BlackMagican characters.
   * The expected exception message is returned, indicating that Modric cannot select a Healing Spell.
   */
  test("It should throw an exception if the BlackMagican cant select Healing Spell"){
    var Healing : Spell = new Healing()
    assertEquals(Modric.selectSpell(Healing), "The character Modric can't select a Healing Spell")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character attempts to select a Paralysis spell.
   * This test checks if the character 'Modric' attempts to select a Paralysis spell, which is not allowed for BlackMagican characters.
   * The expected exception message is returned, indicating that Modric cannot select a Paralysis Spell.
   */
  test("It should throw an exception if the BlackMagican cant select Paralysis Spell"){
    var Paralysis : Spell = new Paralysis()
    assertEquals(Modric.selectSpell(Paralysis), "The character Modric can't select a Paralysis Spell")
  }

  /**
   * Verifies that an exception is thrown when a BlackMagican character attempts to select a Poison spell.
   * This test checks if the character 'Modric' attempts to select a Poison spell, which is not allowed for BlackMagican characters.
   * The expected exception message is returned, indicating that Modric cannot select a Poison Spell.
   */
  test("It should throw an exception if the BlackMagican cant select Poison Spell"){
    var Poison : Spell = new Poison()
    assertEquals(Modric.selectSpell(Poison), "The character Modric can't select a Poison Spell")
  }

}

