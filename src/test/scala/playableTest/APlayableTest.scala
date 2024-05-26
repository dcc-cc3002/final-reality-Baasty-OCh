package playableTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import munit.FunSuite

class APlayableTest extends FunSuite{
  var Di_Stefano: Playable = _
  var Puskas: Playable = _
  var Gento: Playable = _
  var Amancio: Playable = _
  var Kopa: Playable = _
  var Cruyff: Enemy = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Di_Stefano = new Paladin("Di Stefano")
    Puskas = new Ninja("Puskas")
    Amancio = new Warrior("Amancio")
    Kopa = new BlackMagican("Kopa")
    Gento = new WhiteMagican("Gento")
    Cruyff = new Enemy("Cruyff")
    }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Di_Stefano`) matches the expected value.
   */
  test("getName") {
    assertEquals(Di_Stefano.getName, "Di Stefano")
    assertEquals(Puskas.getName, "Puskas")
    assertEquals(Amancio.getName,"Amancio")
    assertEquals(Kopa.getName,"Kopa")
    assertEquals(Gento.getName,"Gento")
  }

  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Di_Stefano` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    assertEquals(Di_Stefano.getHp, 100)
    assertEquals(Puskas.getHp, 80)
    assertEquals(Amancio.getHp, 120)
    assertEquals(Kopa.getHp, 90)
    assertEquals(Gento.getHp, 100)
  }

  /**
   *
   */
  test("setHp"){
    Di_Stefano.setHp(45)
    Puskas.setHp(45)
    Amancio.setHp(45)
    Kopa.setHp(45)
    Gento.setHp(45)

    assertEquals(Di_Stefano.getHp,45)
    assertEquals(Puskas.getHp,45)
    assertEquals(Amancio.getHp,45)
    assertEquals(Kopa.getHp,45)
    assertEquals(Gento.getHp,45)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Di_Stefano` matches the expected value (`75`).
   */
  test("getDefencePoints") {
    assertEquals(Di_Stefano.getDp, 75)
    assertEquals(Puskas.getDp, 70)
    assertEquals(Amancio.getDp, 100)
    assertEquals(Kopa.getDp, 60)
    assertEquals(Gento.getDp, 80)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Di_Stefano` matches the expected value (`50`).
   */
  test("getWeight") {
    assertEquals(Di_Stefano.getWeight, 50)
    assertEquals(Puskas.getWeight, 30)
    assertEquals(Amancio.getWeight, 70)
    assertEquals(Kopa.getWeight, 50)
    assertEquals(Gento.getWeight, 60)
  }

  /**
   * Test case for `hasWeapon` method.
   * This test verifies if the playable entity `Di_Stefano` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Di_Stefano.hasWeapon, None)
    assertEquals(Puskas.hasWeapon, None)
    assertEquals(Amancio.hasWeapon, None)
    assertEquals(Kopa.hasWeapon, None)
    assertEquals(Gento.hasWeapon, None)
  }

  /**
   * Test case when a 'Playable' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' when are attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Di_Stefano.wasAttacked(45)
    assertEquals(Di_Stefano.getHp,55)
    Di_Stefano.wasAttacked(200)
    assertEquals(Di_Stefano.getHp,0)

    Puskas.wasAttacked(45)
    assertEquals(Puskas.getHp,35)
    Puskas.wasAttacked(200)
    assertEquals(Puskas.getHp,0)

    Amancio.wasAttacked(45)
    assertEquals(Amancio.getHp,75)
    Amancio.wasAttacked(200)
    assertEquals(Amancio.getHp,0)

    Kopa.wasAttacked(45)
    assertEquals(Kopa.getHp,45)
    Kopa.wasAttacked(200)
    assertEquals(Kopa.getHp,0)

    Gento.wasAttacked(45)
    assertEquals(Gento.getHp,55)
    Gento.wasAttacked(200)
    assertEquals(Gento.getHp,0)
  }
}
