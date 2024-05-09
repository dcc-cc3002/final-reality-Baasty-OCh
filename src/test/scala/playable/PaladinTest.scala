package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class PaladinTest extends FunSuite {
  var Cristiano: Playable = _ // Declaration of a variable `Cristiano` of type `Playable`.
  var Pele: Playable = _ // Declaration of a variable `Pele` of type `Playable`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Cristiano` and `Pele` with new instances of `Paladin`.
    Cristiano = new Paladin("Cristiano")
    Pele = new Paladin("Pele", 30, 50, 90, 0)
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Cristiano`) are considered equal.
   */
  test("equals") {
    assertEquals(Cristiano, Cristiano)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Cristiano`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Cristiano` and store it in the `name` variable.
    var name = Cristiano.getName
    // Compare the actual name value (`name`) with the expected value ("Cristiano").
    assertEquals(name, "Cristiano")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Cristiano` matches the expected value (`100`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Cristiano` and store it in the `life` variable.
    var life = Cristiano.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 100)
  }

  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Cristiano` matches the expected value (`75`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Cristiano` and store it in the `defense` variable.
    var defense = Cristiano.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`75`).
    assertEquals(defense, 75)
  }

  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Cristiano` matches the expected value (`50`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Cristiano` and store it in the `weight` variable.
    var weight = Cristiano.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`50`).
    assertEquals(weight, 50)
  }

  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Cristiano` matches the expected value (`0`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Cristiano` and store it in the `mana` variable.
    var mana = Cristiano.getMana
    // Compare the actual mana value (`mana`) with the expected value (`0`).
    assertEquals(mana, 0)
  }

  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Cristiano` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Cristiano.haveWeapon, None)
  }
  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Espada`) on the character `Cristiano`.
   */
  test("putWeapon") {
    // Create a new `Sword` instance (`Espada`) associated with `Cristiano`.
    var Espada: Sword = new Sword(Cristiano)
    // Equip the `Espada` weapon on the character `Cristiano` using the `putWeapon` method.
    Cristiano.putWeapon(Espada)
    // Verify if the character `Cristiano` now has the `Espada` weapon equipped (returns `Some(Espada)`).
    assertEquals(Cristiano.haveWeapon, Some(Espada))
  }






}


