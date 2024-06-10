package playableTest.magicTest

import model.nonplayable.Enemy
import model.playable.magic.WhiteMagican
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class WhiteMagicanTest extends FunSuite {
  var Benzema: WhiteMagican = _
  var Ter_Stegen: Enemy = _
  var Ozil: WhiteMagican = _
  var Suarez: Enemy = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Benzema = new WhiteMagican("Benzema")
    Ozil = new WhiteMagican("Ozil",55,90,32,90)
    Ter_Stegen = new Enemy("Ter_Stegen")
    Suarez = new Enemy("Suarez",250,500,50,50) // enemy with ridiculous defense
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Benzema`) are considered equal.
   */
  test("equals") {
    assertEquals(Benzema.equals(Benzema),true)
    assertEquals(Benzema.equals(Ozil),false)
    assertEquals(Benzema.equals(Ter_Stegen),false)
  }

  /**
   * Test case for 'canEquip' methods.
   * This test verifies if the WhiteMagican 'Benzema' can Equip particular kind of weapon or not
   * (he can: Bow, Wand and Staff. and can not: Sword and Axe)
   */
  test("canEquip"){
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Arco: Bow = new Bow()

    assertEquals(Benzema.canEquipStaff(Baston),true)
    assertEquals(Benzema.canEquipWand(Varita),true)
    assertEquals(Benzema.canEquipBow(Arco),true)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon ('Bow' , 'Wand' or 'Staff') on the character 'Casemiro'.
   * And throw exceptions in other cases
   */
  test("putWeapon") {
    val Baston: Staff = new Staff()
    val Varita: Wand = new Wand()
    val Arco: Bow = new Bow()

    assertEquals(Benzema.putWeapon(Varita),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Varita))

    assertEquals(Benzema.putWeapon(Arco),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Arco))

    assertEquals(Benzema.putWeapon(Baston),"The weapon was wear")
    assertEquals(Benzema.hasWeapon, Some(Baston))
  }

  /**
   * Test case for 'dropWeapon' method.
   * This test verifies if the 'dropWeapon' method successfully remove a weapon on the character 'Benzema'
   */
  test("dropWeapon"){
    val Arco: Bow = new Bow()
    Benzema.putWeapon(Arco)
    assertEquals(Benzema.hasWeapon, Some(Arco))

    Benzema.dropWeapon()
    assertEquals(Benzema.hasWeapon,None)
  }

  /**
   * Verifies that an exception is thrown when a whiteMagican character cannot equip a Sword.
   * This test checks if the character 'Benzema' cannot equip a Sword, the expected exception message is returned.
   */
  test("It should throw an exception if the WhiteMagican cant equip a Sword"){
    val Espada: Sword = new Sword()
    assertEquals(Benzema.putWeapon(Espada),"The character: Benzema can't wear a Sword")
  }

  /**
   * Verifies that an exception is thrown when a WhiteMagican character cannot equip an Axe.
   * This test checks if the character 'Benzema' cannot equip an Axe, the expected exception message is returned.
   */
  test("It should throw an exception if the whiteMagican cant equip a Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Benzema.putWeapon(Hacha),"The character: Benzema can't wear an Axe")
  }

  /**
   * Verifies that an exception is thrown when a WhiteMagican character cannot equip a foreign weapon.
   * This test checks if the character 'Benzema' tries to equip a Bow, which is a foreign weapon ('Ozil' is the owner),
   * the expected exception message is returned since the weapon 'Arco' already has an owner.
   */
  test("It should throw an exception if the WhiteMagican cant equip a foreign weapon"){
    val Arco: Bow = new Bow()
    Ozil.putWeapon(Arco)

    assertEquals(Benzema.putWeapon(Arco),"The weapon: Arco already has an owner")
  }

  /**
   * Test case for attack method.
   * This test verifies if the `attack` method inflicts the correct damage on the enemy (`Ter_Stegen`)
   * when `Benzema` attacks with a `Wand`.
   * also verifies if the 'attack' method inflicts zero damage
   * when the defense points of enemy are greater than the attack points of  WhiteMagican
   */
  test("attack") {
    val Baston: Staff = new Staff()
    Benzema.putWeapon(Baston)

    assertEquals(Benzema.attack(Ter_Stegen), "The enemy was attacked")
    assertEquals(Benzema.attack(Suarez), "The enemy was attacked, but the damage is not enough")
  }

  /**
   * Verifies that an exception is thrown when a WhiteMagican character attempts to attack another ally game unit.
   * This test checks if the character 'Benzema' equipped with a Staff attempts to attack the character 'Ozil', who is also an ally.
   * The expected exception message is returned, indicating that Benzema cannot attack an ally.
   */
  test("It should throw an exception if the WhiteMagican cant attack game unit (Playable)"){
    val Baston: Staff = new Staff()
    Benzema.putWeapon(Baston)

    assertEquals(Benzema.attack(Ozil), "The character: Benzema can't attack an ally")
  }

  /**
   * Test case for selecting spells by the character.
   * This test checks if the character 'Benzema' can successfully select different types of spells such as Healing, Paralysis, and Poison.
   * The expected message indicating successful spell selection is returned for each spell.
   */
  test("SelectSpell"){
    var Healing : Spell = new Healing()
    var Paralysis : Spell = new Paralysis()
    var Poison : Spell = new Poison()

    assertEquals(Benzema.selectSpell(Healing), "The spell was selected")
    assertEquals(Benzema.selectSpell(Paralysis), "The spell was selected")
    assertEquals(Benzema.selectSpell(Poison), "The spell was selected")
  }

  /**
   * Verifies that an exception is thrown when a WhiteMagican character attempts to select a Fire spell.
   * This test checks if the character 'Benzema' attempts to select a Fire spell, which is not allowed for WhiteMagican characters.
   * The expected exception message is returned, indicating that Benzema cannot select a Fire Spell.
   */
  test("It should throw an exception if the WhiteMagican cant select Fire Spell"){
    var Fire : Spell = new Fire()
    assertEquals(Benzema.selectSpell(Fire), "The character Benzema can't select a Fire Spell")
  }

  /**
   * Verifies that an exception is thrown when a WhiteMagican character attempts to select a Thunder spell.
   * This test checks if the character 'Benzema' attempts to select a Thunder spell, which is not allowed for WhiteMagican characters.
   * The expected exception message is returned, indicating that Benzema cannot select a Thunder Spell.
   */
  test("It should throw an exception if the WhiteMagican cant select Thunder Spell"){
    var Thunder : Spell = new Thunder()
    assertEquals(Benzema.selectSpell(Thunder), "The character Benzema can't select a Thunder Spell")
  }





}
