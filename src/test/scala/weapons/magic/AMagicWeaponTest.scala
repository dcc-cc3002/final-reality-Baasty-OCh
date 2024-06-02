package weapons.magic

import model.weapons.magic.{MagicWeapon, Staff, Wand}
import munit.FunSuite

/**
 * A test suite for testing the functionality of magic weapons.
 * This class extends FunSuite, providing a framework for writing and running tests.
 */
class AMagicWeaponTest extends FunSuite{
  var wand: MagicWeapon = _
  var staff: MagicWeapon = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    wand = new Wand()
    staff = new Staff()
  }

  /**
   * Test case for `getMAP` method.
   * This test verifies if the returned magic attack points value for a wand and staff  matches the expected value (30 and 40).
   */
  test("getMAP") {
    assertEquals(wand.getMAP, 30)
    assertEquals(staff.getMAP, 40)
  }

  /**
   * Verifies the behavior of the 'iAmMagic' method.
   * This test checks if the 'iAmMagic' method correctly identifies magical weapons.
   */
  test("iAmMagic"){
    assertEquals(wand.iAmMagic, true)
    assertEquals(staff.iAmMagic, true)
  }
}
