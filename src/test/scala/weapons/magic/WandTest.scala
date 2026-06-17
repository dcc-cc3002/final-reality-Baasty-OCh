package weapons.magic

import model.weapons.magic.{Staff, Wand}
import munit.FunSuite

/**
 * Test suite for the `Wand` class.
 * This class contains tests for various functionalities of the `Wand` class.
 */
class WandTest extends FunSuite {
  var Varita: Wand = _
  var Varita2: Wand = _
  var Baston: Staff = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Varita = new Wand()
    Varita2 = new Wand("Varita",100,100,50)
    Baston = new Staff()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same wand (`Barita`) are considered equal.
   */
  test("equals") {
    assertEquals(Varita.equals(Varita),true)
    assertEquals(Varita.equals(Varita2),false)
    assertEquals(Varita.equals(Baston),false)
  }
}
