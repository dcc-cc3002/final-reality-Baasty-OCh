package weapons.common


import model.weapons.common.{Axe, Bow}
import munit.FunSuite

/**
 * Test suite for the `Bow` class.
 * This class contains tests for various functionalities of the `Bow` class.
 */
class BowTest extends FunSuite {
  var Arco: Bow = _ // Declaration of a variable `Arco` of type `Bow`.
  var Arco2: Bow = _
  var Hacha: Axe = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Arco = new Bow()
    Arco2 = new Bow("Arco2",80,80)
    Hacha = new Axe()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same bow (`Arco`) are considered equal.
   */
  test("equals") {
    assertEquals(Arco.equals(Arco),true)
    assertEquals(Arco.equals(Arco2),false)
    assertEquals(Arco.equals(Hacha),false)
  }

}

