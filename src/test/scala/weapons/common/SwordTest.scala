package weapons.common


import model.weapons.common.{Bow, Sword}
import munit.FunSuite

/**
 * Test suite for the `Sword` class.
 * This class contains tests for various functionalities of the `Sword` class.
 */
class SwordTest extends FunSuite {
  var Espada: Sword = _
  var Espada2: Sword = _
  var Arco: Bow = _

  /**
   * Set up the test environment before each test case.
   * This method is invoked before each test case (`test`) to initialize the test objects.
   * @param context The context provided by the test framework (`BeforeEach`).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Espada = new Sword()
    Espada2 = new Sword("Espada2", 40, 40)
    Arco = new Bow()
  }

  /**
   * Test case for `equals` method.
   * This test verifies if two references to the same sword (`Espada`) are considered equal.
   */
  test("equals") {
    assertEquals(Espada.equals(Espada), true)
    assertEquals(Espada.equals(Espada2), false)
    assertEquals(Espada.equals(Arco), false)
  }

}