package weapons

import model.playable.Playable
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.WhiteMagican
import model.weapons.{AWeapon, Weapon}
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

class AWeaponTest extends FunSuite{
  var Tango: AWeapon = _
  var Jabulani: AWeapon = _
  var Cachaña: AWeapon = _
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
    Cachaña = new Bow()
    Azteca = new Staff()
    Telstar = new Wand()

  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for sword 'Tango', axe `Jabulani`, bow 'Cachaña',
   * staff 'Azteca' and wand 'Telstar' matches the expected value (Espada, Hacha, Arco, Baston, Varita)
   */
  test("getName") {
    assertEquals(Tango.getName, "Espada")
    assertEquals(Jabulani.getName, "Hacha")
    assertEquals(Cachaña.getName, "Arco")
    assertEquals(Azteca.getName, "Baston")
    assertEquals(Telstar.getName, "Varita")
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for an axe (`Hacha`) matches the expected value (`25`).
   */
  test("getWeight") {
    assertEquals(Tango.getWeight, 70)
    assertEquals(Jabulani.getWeight, 50)
    assertEquals(Cachaña.getWeight, 30)
    assertEquals(Azteca.getWeight, 70)
    assertEquals(Telstar.getWeight, 40)
  }

  /**
   * Test case for `getAttack` method.
   * This test verifies if the returned attack value for an axe (`Hacha`) matches the expected value (`50`).
   */
  test("getAttack") {
    assertEquals(Tango.getAttack, 70)
    assertEquals(Jabulani.getAttack, 50)
    assertEquals(Cachaña.getAttack, 40)
    assertEquals(Azteca.getAttack, 70)
    assertEquals(Telstar.getAttack, 50)

  }

  /**
   * Test case for `getOwner` method.
   * This test verifies if the returned owner character for an axe (`Tango`) matches the expected character (`Casemiro`).
   */
  test("getOwner") {
    assertEquals(Tango.getOwner, None)
    assertEquals(Jabulani.getOwner, None)
    assertEquals(Cachaña.getOwner, None)
    assertEquals(Azteca.getOwner, None)
    assertEquals(Telstar.getOwner, None)

  }

  /**
   * Test case for 'setOwner' method.
   * This test verifies if the returned owner character for an axe ('Tango') matches with the playable who was previous set ('Casemiro')
   */
  test("setOwner") {
    var Pele: Playable = new Paladin("Pele")
    var Maradona : Playable = new Ninja("Maradona")
    var Rossi: Playable = new Warrior("Rossi")
    var Zidane: Playable = new WhiteMagican("Zidane")


  }




}
