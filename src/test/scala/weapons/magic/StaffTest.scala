package weapons.magic


import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `Staff` class.
 * This class contains tests for various functionalities of the `Staff` class.
 */
class StaffTest extends FunSuite {
  var Baston: Staff = _
  var Baston2: Staff = _
  var Varita: Wand = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Baston  = new Staff()
    Baston2  = new Staff("Baston2",57,89,50)
    Varita  = new Wand()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same staff (`Baston`) are considered equal.
   */
  test("equals") {
    assertEquals(Baston.equals(Baston),true)
    assertEquals(Baston.equals(Baston2),false)
    assertEquals(Baston.equals(Varita),false)
  }
}

