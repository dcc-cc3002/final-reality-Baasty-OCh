package weapons.common


import model.weapons.common.{Axe, Sword}
import munit.FunSuite

/**
 * Test suite for the `Axe` class.
 * This class contains tests for various functionalities of the `Axe` class.
 */
class AxeTest extends FunSuite {
  var Hacha: Axe = _
  var Hacha2: Axe = _
  var Espada: Sword = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   *
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Hacha = new Axe()
    Hacha2 = new Axe("Hacha2", 50,50)
    Espada = new Sword()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same axe (`Hacha`) are considered equal.
   */
  test("equals") {
    assertEquals(Hacha.equals(Hacha),true)
    assertEquals(Hacha.equals(Hacha2),false)
    assertEquals(Hacha.equals(Espada),false)
  }

}

