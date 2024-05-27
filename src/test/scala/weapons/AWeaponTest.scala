package weapons

import model.playable.Playable
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.weapons.{AWeapon, Weapon}
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

class AWeaponTest extends FunSuite{
  var Tango: AWeapon = _
  var Jabulani: AWeapon = _
  var Cachanna: AWeapon = _
  var Azteca: AWeapon = _
  var Telstar: AWeapon = _


  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Tango = new Sword()
    Jabulani = new Axe()
    Cachanna = new Bow()
    Azteca = new Staff()
    Telstar = new Wand()

  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for sword 'Tango', axe `Jabulani`, bow 'Cachanna',
   * staff 'Azteca' and wand 'Telstar' matches the expected value (Espada, Hacha, Arco, Baston, Varita)
   */
  test("getName") {
    assertEquals(Tango.getName, "Espada")
    assertEquals(Jabulani.getName, "Hacha")
    assertEquals(Cachanna.getName, "Arco")
    assertEquals(Azteca.getName, "Baston")
    assertEquals(Telstar.getName, "Varita")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for sword 'Tango', axe `Jabulani`, bow 'Cachanna',
   * * staff 'Azteca' and wand 'Telstar' matches the expected values (70,50,30,70,40).
   */
  test("getWeight") {
    assertEquals(Tango.getWeight, 70)
    assertEquals(Jabulani.getWeight, 50)
    assertEquals(Cachanna.getWeight, 30)
    assertEquals(Azteca.getWeight, 70)
    assertEquals(Telstar.getWeight, 40)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for sword 'Tango', axe `Jabulani`, bow 'Cachanna',
   * * staff 'Azteca' and wand 'Telstar' matches the expected values (70,50,40,70,50).
   */
  test("getAttack") {
    assertEquals(Tango.getAttack, 70)
    assertEquals(Jabulani.getAttack, 50)
    assertEquals(Cachanna.getAttack, 40)
    assertEquals(Azteca.getAttack, 70)
    assertEquals(Telstar.getAttack, 50)

  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for sword 'Tango', axe `Jabulani`, bow 'Cachanna',
   * * staff 'Azteca' and wand 'Telstar' matches the expected values (None at the beginning)
   */
  test("getOwner") {
    assertEquals(Tango.getOwner, None)
    assertEquals(Jabulani.getOwner, None)
    assertEquals(Cachanna.getOwner, None)
    assertEquals(Azteca.getOwner, None)
    assertEquals(Telstar.getOwner, None)
  }

  /**
   * Test case for 'setOwner' method.
   * This test verifies if the returned owner character for sword 'Tango', axe `Jabulani`, bow 'Cachanna',
   * * staff 'Azteca' and wand 'Telstar' matches the expected values (Pele, Forlan, Zidane, Maradona and Mbappe)
   */
  test("setOwner") {
    var Pele: Playable = new Paladin("Pele")
    var Forlan: Playable = new Warrior("Forlan")
    var Zidane: Playable = new Ninja("Zidane")
    var Mbappe: Playable = new WhiteMagican("Mbappe")
    var Maradona : Playable = new BlackMagican("Maradona")

    Pele.putWeapon(Tango)        // Paladin + sword
    Forlan.putWeapon(Jabulani)   // Warrior + Axe
    Zidane.putWeapon(Cachanna)    // Ninja + Bow
    Maradona.putWeapon(Azteca)   // BlackMagican + Staff
    Mbappe.putWeapon(Telstar)    // WhiteMagican + Wand

    assertEquals(Tango.getOwner, Some(Pele))
    assertEquals(Jabulani.getOwner, Some(Forlan))
    assertEquals(Cachanna.getOwner, Some(Zidane))
    assertEquals(Azteca.getOwner, Some(Maradona))
    assertEquals(Telstar.getOwner, Some(Mbappe))
  }
}
