package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
/**
 * Test suite for the `Paladin` class.
 * This class contains tests for various functionalities of the `Paladin` class.
 */
class WarriorTest extends FunSuite {
  var Casemiro: Playable = _ // Declaration of a variable `Casemiro` of type `Playable`.
  var Busquets: Enemy = _ // Declaration of a variable `Busquets` of type `Enemy`.

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    // Initialize `Casemiro` with new instances of `Warrior`.
    Casemiro = new Warrior("Casemiro")
    // Initialize `Busquets` with new instances of `Enemy`.
    Busquets = new Enemy("Busquets")
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same character (`Casemiro`) are considered equal.
   */
  test("equals") {
    assertEquals(Casemiro, Casemiro)
  }

  /**
   * Test case for `getName` method.
   * This test verifies if the returned name value for a character (`Casemiro`) matches the expected value.
   */
  test("getName") {
    // Retrieve the name value of the character `Casemiro` and store it in the `name` variable.
    var name = Casemiro.getName
    // Compare the actual name value (`name`) with the expected value ("Casemiro").
    assertEquals(name, "Casemiro")
  }
  /**
   * Test case for `getHp` method.
   * This test verifies if the returned health points (`hp`) value for the character `Casemiro` matches the expected value (`120`).
   */
  test("getHealthPoints") {
    // Retrieve the health points (`hp`) value of the character `Casemiro` and store it in the `life` variable.
    var life = Casemiro.getHp
    // Compare the actual health points value (`life`) with the expected value (`100`).
    assertEquals(life, 120)
  }
  /**
   * Test case for `getDp` method.
   * This test verifies if the returned defense points (`dp`) value for the character `Casemiro` matches the expected value (`100`).
   */
  test("getDefencePoints") {
    // Retrieve the defense points (`dp`) value of the character `Casemiro` and store it in the `defense` variable.
    var defense = Casemiro.getDp
    // Compare the actual defense points value (`defense`) with the expected value (`100`).
    assertEquals(defense, 100)
  }
  /**
   * Test case for `getWeight` method.
   * This test verifies if the returned weight value for the character `Casemiro` matches the expected value (`70`).
   */
  test("getWeight") {
    // Retrieve the weight value of the character `Casemiro` and store it in the `weight` variable.
    var weight = Casemiro.getWeight
    // Compare the actual weight value (`weight`) with the expected value (`70`).
    assertEquals(weight, 70)
  }
  /**
   * Test case for `getMana` method.
   * This test verifies if the returned mana value for the character `Casemiro` matches the expected value (`0`).
   */
  test("getMana") {
    // Retrieve the mana value of the character `Casemiro` and store it in the `mana` variable.
    var mana = Casemiro.getMana
    // Compare the actual mana value (`mana`) with the expected value (`0`).
    assertEquals(mana, 0)
  }
  /**
   * Test case for `haveWeapon` method.
   * This test verifies if the playable entity `Casemiro` does not have a weapon (returns `None`).
   */
  test("HaveWeapon") {
    assertEquals(Casemiro.haveWeapon, None)
  }
  /**
   * Test case for `putWeapon` method.
   * This test verifies if the `putWeapon` method successfully equips a weapon (`Axe`) on the character `Casemiro`.
   */
  test("putWeapon") {
    // Create a new `Sword` instance (`Espada`) associated with `Cristiano`.
    var Hacha: Axe = new Axe(Casemiro)
    // Equip the `Hacha` weapon on the character `Casemiro` using the `putWeapon` method.
    Casemiro.putWeapon(Hacha)
    // Verify if the character `Casemiro` now has the `Hacha` weapon equipped (returns `Some(Hacha)`).
    assertEquals(Casemiro.haveWeapon, Some(Hacha))
  }  /**
   * Test case for `attackEnemy` method.
   * This test verifies if the `attackEnemy` method inflicts the correct damage on the enemy (`Busquets`) when `Casemiro` attacks with a `Axe`.
   */
  test("attackEnemy") {
    // Equip `Casemiro` with a `Axe`.
    Casemiro.putWeapon(new Axe())

    // `Casemiro` attacks `Busquets` using the `attackEnemy` method and retrieves the inflicted damage (`daño`).
    val damage: Int = Casemiro.attackEnemy(Busquets)

    // Calculate the expected damage based on `Casemiro`'s attack power (Axe's attack - `Busquets`'s defense).
    val expectedDamage: Int = 50 - 50

    // Verify if the inflicted damage (`damage`) matches the expected damage (`expectedDamage`).
    assertEquals(damage, expectedDamage)
  }  /**
   * Test case for `wasAttacked` method.
   * This test verifies the behavior of the `wasAttacked` method in response to inflicted damage on the character `Casemiro`.
   */
  test("wasAttacked") {
    // Verify if `Casemiro`'s health points (`getHp`) decrease correctly after receiving 45 damage.
    assertEquals(Casemiro.wasAttacked(45).getHp, 75) // 120 health points - 45 damage -> 75 health points

    // Verify if `Casemiro`'s health points (`getHp`) become 0 after receiving 145 damage (exceeds total health).
    assertEquals(Casemiro.wasAttacked(145).getHp, 0) // 120 health points - 145 damage -> 0 health points
  }
}
