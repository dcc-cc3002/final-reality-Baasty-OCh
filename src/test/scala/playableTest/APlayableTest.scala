package playableTest

import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

/**
 * Test suite for the abstract class `APlayable` and its subclasses.
 * This suite verifies the behavior of playable characters in the game.
 */
class APlayableTest extends FunSuite {
  var Di_Stefano: Playable = _
  var Puskas: Playable = _
  var Amancio: Playable = _
  var Kopa: Playable = _
  var Gento: Playable = _
  var Puyol: Enemy = _
  var Iniesta: Enemy = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Di_Stefano = new Paladin("Di Stefano")
    Puskas = new Ninja("Puskas")
    Amancio = new Warrior("Amancio")
    Kopa = new BlackMagican("Kopa")
    Gento = new WhiteMagican("Gento")
    Iniesta = new Enemy("Iniesta",250,1,50,50, "Healthy")
    Puyol = new Enemy("Puyol",250,500,50,50, "Healthy") // enemy with ridiculous defense
    }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' matches the
   * expected values (Di Stefano, Puskas,
   * Amancio, Kopa, Gento).
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
   * This test verifies if the returned health points (`hp`) value for the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' matches the expected values (100,80,120,90,100).
   */
  test("getHealthPoints") {
    assertEquals(Di_Stefano.getHp, 150)
    assertEquals(Puskas.getHp, 100)
    assertEquals(Amancio.getHp, 200)
    assertEquals(Kopa.getHp, 90)
    assertEquals(Gento.getHp, 100)
  }

  /**
   * Test case for 'setHp' method.
   * This test verifies if the method actually update the health points of the character Paladin 'Di_Stefano', Ninja 'Puskas',
   * * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' to value (45)
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
   * This test verifies if the returned defense points (`dp`) value for the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' matches the expected values (75,70,100,60,80).
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
   * This test verifies if the returned weight value for the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' matches the expected values (50,30,70,50,60).
   */
  test("getWeight") {
    assertEquals(Di_Stefano.getWeight, 50)
    assertEquals(Puskas.getWeight, 30)
    assertEquals(Amancio.getWeight, 70)
    assertEquals(Kopa.getWeight, 50)
    assertEquals(Gento.getWeight, 60)
  }


  test("Style"){
    assertEquals(Di_Stefano.Style(Di_Stefano), "playable")
    assertEquals(Puskas.Style(Puskas), "playable")
    assertEquals(Amancio.Style(Amancio), "playable")
  }

  test("IsMagic"){
    assertEquals(Di_Stefano.IsMagic(Di_Stefano), 0)
    assertEquals(Puskas.IsMagic(Puskas), 0)
    assertEquals(Amancio.IsMagic(Amancio), 0)

  }

  /**
   * Test case for `hasWeapon` method.
   * This test verifies if the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento'  do not have a weapon (returns None`).
   */
  test("HasWeapon") {
    assertEquals(Di_Stefano.hasWeapon, None)
    assertEquals(Puskas.hasWeapon, None)
    assertEquals(Amancio.hasWeapon, None)
    assertEquals(Kopa.hasWeapon, None)
    assertEquals(Gento.hasWeapon, None)
  }

  test("ArrayOfWeapons"){
    assertEquals(Di_Stefano.weapons(),ArrayBuffer(Di_Stefano.Bow,
                 Di_Stefano.Sword,Di_Stefano.Axe,Di_Stefano.Staff,Di_Stefano.Wand))

    assertEquals(Kopa.weapons(),ArrayBuffer(Kopa.Bow,
      Kopa.Sword,Kopa.Axe,Kopa.Staff,Kopa.Wand))

    assertEquals(Amancio.weapons(),ArrayBuffer(Amancio.Bow,
      Amancio.Sword,Amancio.Axe,Amancio.Staff,Amancio.Wand))

    assertEquals(Puskas.weapons(),ArrayBuffer(Puskas.Bow,
      Puskas.Sword,Puskas.Axe,Puskas.Staff,Puskas.Wand))

    assertEquals(Gento.weapons(),ArrayBuffer(Gento.Bow,
      Gento.Sword,Gento.Axe,Gento.Staff,Gento.Wand))

  }

  /**
   * Test case when a 'Playable' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Paladin 'Di_Stefano', Ninja 'Puskas',
   * Warrior 'Amancio', BlackMagican 'Kopa', and WhiteMagican 'Gento' when are attacked by entity with 45 points of power
   * and when the power is 200 */
  test("wasAttacked"){
    Di_Stefano.wasAttacked(45)
    assertEquals(Di_Stefano.getHp,105)
    Di_Stefano.wasAttacked(200)
    assertEquals(Di_Stefano.getHp,0)

    Puskas.wasAttacked(45)
    assertEquals(Puskas.getHp,55)
    Puskas.wasAttacked(200)
    assertEquals(Puskas.getHp,0)

    Amancio.wasAttacked(45)
    assertEquals(Amancio.getHp,155)
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

  test("getAttack") {
    val Staff: Staff = new Staff()
    val Wand: Wand = new Wand()
    val Sword: Sword = new Sword()
    val Bow: Bow = new Bow()
    val Axe: Axe = new Axe()

    Gento.putWeapon(Wand)
    assertEquals(Gento.getAttack,50)

    Kopa.putWeapon(Staff)
    assertEquals(Kopa.getAttack,70)

    Di_Stefano.putWeapon(Sword)
    assertEquals(Di_Stefano.getAttack,70)

    Puskas.putWeapon(Bow)
    assertEquals(Puskas.getAttack,40)

    Amancio.putWeapon(Axe)
    assertEquals(Amancio.getAttack,50)
  }

  /**
   * Test case for the 'attack' method.
   * This test checks the attack functionality of different characters against enemy game units.
   * Each character equips a different weapon (Staff, Wand, Sword, Bow, Axe) and attacks enemy units (Iniesta and Puyol).
   * The expected result is "The enemy was Attack" if the attack is successful, and "The enemy was Attack,
   * but the damage is not enough" if the attack is not strong enough to defeat the enemy. */
  test("attack") {
    val Staff: Staff = new Staff()
    val Wand: Wand = new Wand()
    val Sword: Sword = new Sword()
    val Bow: Bow = new Bow()
    val Axe: Axe = new Axe()

    Gento.putWeapon(Wand)
    assertEquals(Gento.attack(Iniesta),"The enemy was attacked")
    assertEquals(Gento.attack(Puyol),"The enemy was attacked, but the damage is not enough")

    Kopa.putWeapon(Staff)
    assertEquals(Kopa.attack(Iniesta),"The enemy was attacked")
    assertEquals(Kopa.attack(Puyol),"The enemy was attacked, but the damage is not enough")

    Di_Stefano.putWeapon(Sword)
    assertEquals(Di_Stefano.attack(Iniesta),"The enemy was attacked")
    assertEquals(Di_Stefano.attack(Puyol),"The enemy was attacked, but the damage is not enough")

    Puskas.putWeapon(Bow)
    assertEquals(Puskas.attack(Iniesta),"The enemy was attacked")
    assertEquals(Puskas.attack(Puyol),"The enemy was attacked, but the damage is not enough")

    Amancio.putWeapon(Axe)
    assertEquals(Amancio.attack(Iniesta),"The enemy was attacked")
    assertEquals(Amancio.attack(Puyol),"The enemy was attacked, but the damage is not enough")
  }
  test("getStatus"){
    assertEquals(Gento.getStatus,"Healthy")
    assertEquals(Kopa.getStatus,"Healthy")
    assertEquals(Di_Stefano.getStatus,"Healthy")
    assertEquals(Puskas.getStatus,"Healthy")
    assertEquals(Amancio.getStatus,"Healthy")
  }
  test("iAmMagic"){
    assertEquals(Di_Stefano.IAmMagic(),0)
    assertEquals(Puskas.IAmMagic(),0)
    assertEquals(Amancio.IAmMagic(),0)
  }
  test("selectSpell"){
    assertEquals(Di_Stefano.selectSpell(new Fire()),"nothing")
    assertEquals(Puskas.selectSpell(new Fire()),"nothing")
    assertEquals(Amancio.selectSpell(new Fire()),"nothing")
  }
  test("throwSpell"){
    assertEquals(Di_Stefano.throwSpell(Kopa),"nothing")
    assertEquals(Puskas.throwSpell(Kopa),"nothing")
    assertEquals(Amancio.throwSpell(Kopa),"nothing")
  }
  test("spells array"){
    /*println(Gento.spells())
    val expectedSpells = ArrayBuffer(
      new Healing,
      new Paralysis,
      new Poison,
      new Fire,
      new Thunder
    )
    assertEquals(Gento.spells().map(_.getName), expectedSpells.map(_.getName))
    */assertEquals(Puskas.spells(),ArrayBuffer.empty[Spell])
   }
}
