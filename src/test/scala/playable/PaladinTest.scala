package playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.NonPlayable
import model.nonplayable.weapons.{Bow,Sword,Axe,Staff,Wand}
import model.nonplayable.Enemy
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Pique: Enemy = _ // Declaration of a variable `Pique` of type `Enemy`.
  var Bale: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Cristiano` with new instances of `Paladin`.
    Cristiano = new Paladin("Cristiano")
    Bale = new Paladin("Bale",25,34,56)
    // Initialize `Pique` with new instances of `Enemy`.
    Pique = new Enemy("Pique")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Cristiano`) are considered equal.
   */
  test("equals") {
    assertEquals(Cristiano.equals(Cristiano),true)
    assertEquals(Cristiano.equals(Bale),false)
    assertEquals(Cristiano.equals(Pique),false)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Cristiano`) matches the expected value.
   */
  test("getName") {
    assertEquals(Cristiano.getName, "Cristiano")
    assertEquals(Bale.getName,"Bale")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Cristiano` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    assertEquals(Cristiano.getHp, 100)
    assertEquals(Bale.getHp,25)
  }


  /**
   * Test case for `setMana` method.
   * This test verifies if the returned health points value for the characters `Cristiano` and 'Bale' matches the expected values (`125 and 250`).
   */
  test("setHp"){
    Cristiano.setHp(125)
    Bale.setHp(250)

    assertEquals(Cristiano.getHp,125)
    assertEquals(Bale.getHp,250)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Cristiano` matches the expected value (`75`).
   */
  test("getDefencePoints") {
    assertEquals(Cristiano.getDp, 75)
    assertEquals(Bale.getDp,34)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Cristiano` matches the expected value (`50`).
   */
  test("getWeight") {
    assertEquals(Cristiano.getWeight, 50)
    assertEquals(Bale.getWeight,56)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Cristiano` matches the expected value (`0`).
   */
  test("getMana") {
    assertEquals(Cristiano.getMana, 0)
    assertEquals(Bale.getMana,0)
  }

  /**
   * Test case for 'setMana' method.
   * This test verifies if the set mana method do 'nothing' in the amount of mana points in this character
   */
  test("setMana"){
    Cristiano.setMana(55)
    Bale.setMana(450)

    assertEquals(Cristiano.getMana,0)
    assertEquals(Bale.getMana,0)
  }
  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Cristiano` does not have a weapon (returns `None`).
   */
  test("HasWeapon") {
    assertEquals(Cristiano.hasWeapon, None)
    assertEquals(Bale.hasWeapon,None)
  }

  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Espada`) on the character `Cristiano`.
   */
  test("putWeapon") {
    var Espada: Sword = new Sword()
    var Hacha: Axe = new Axe()
    Cristiano.putWeapon(Espada)
    Bale.putWeapon(Hacha)

    assertEquals(Cristiano.hasWeapon, Some(Espada))
    assertEquals(Bale.hasWeapon,Some(Hacha))
  }

  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Pique`) when `Cristiano` attacks with a `Sword`.
   */
  test("attackEnemy") {
    Cristiano.putWeapon(new Sword())
    Bale.putWeapon((new Axe()))
    val damage: Int = Cristiano.attackEnemy(Pique)
    val damage2: Int = Bale.attackEnemy(Pique)
    val expectedDamage: Int = 70 - 50
    val expectedDamage2: Int = 0

    assertEquals(damage, expectedDamage)
    assertEquals(damage2,expectedDamage2)
  }


  /**
   * Test case when a 'Paladin' was attack by other entity
   * This test verifies if the 'wasAttacked' method inflicts the correct damage on the Paladin 'Cristiano' when is attacked by entity with 45 points of power
   * and when the power is 200
   */
  test("wasAttacked"){
    Cristiano.wasAttacked(45)

    assertEquals(Cristiano.getHp,55)

    Cristiano.wasAttacked(200)

    assertEquals(Cristiano.getHp,0)
  }


}


