package playableTest.magicTest

import model.nonplayable.Enemy
import model.playable.magic.WhiteMagican
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
/**
 * Test suite for the `WhiteMagican` class.
 * This class contains tests for various functionalities of the `WhiteMagican` class.
 */
class WhiteMagicanTest extends FunSuite {
  var Benzema: WhiteMagican = _ // Declaration of a variable `Benzema` of type `Playable`.
  var Ter_Stegen: Enemy = _ // Declaration of a variable `Ter_Stegen` of type `Enemy`.
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
    Suarez = new Enemy("Suarez",50,50,250,500) // enemy with ridiculous defense
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

  test("It should throw an exception if the Paladin cant equip a Sword"){
    val Espada: Sword = new Sword()
    assertEquals(Benzema.putWeapon(Espada),"The character: Benzema can't wear a Sword")
  }


  test("It should throw an exception if the Paladin cant equip a Axe"){
    val Hacha: Axe = new Axe()
    assertEquals(Benzema.putWeapon(Hacha),"The character: Benzema can't wear an Axe")
  }

  test("It should throw an exception if the WhiteMagican cant equip a foreign weapon"){
    val Arco: Bow = new Bow()
    Ozil.putWeapon(Arco)

    assertEquals(Benzema.putWeapon(Arco),"The weapon: Arco already has owner")
  }

  /**
   * Test case for attack method.
   * This test verifies if the `attack` method inflicts the correct damage on the enemy (`Ter_Stegen`) when `Benzema` attacks with a `Wand`.
   * also verifies if the 'attack' method inflicts zero damage when the defense poitns of enemy are higher than the attack points of Black Magican
   */
  test("attack") {
    val Baston: Staff = new Staff()
    Benzema.putWeapon(Baston)

    assertEquals(Benzema.attack(Ter_Stegen),"The enemy was Attack")
    assertEquals(Benzema.attack(Suarez),"The enemy was Attack, but the damage is not enough")
  }

  test("It should throw an exception if the BlackMagican cant attack game unit"){
    val Baston: Staff = new Staff()
    Benzema.putWeapon(Baston)

    assertEquals(Benzema.attack(Ozil), "The character: Benzema can't attack an Allie")
  }



}
