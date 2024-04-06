import munit.FunSuite

class PlayableTest extends FunSuite{
  var Cristiano: Character = _
  var Messi: Character = _

  override def beforeEach(context: BeforeEach): Unit = {
    var Cristiano = Character()
    var Messi = Character()
  }

  test("equalsname"){
    val nombre = Cristiano.sayName("Cristiano")
    val expected = "Cristiano"
    assertEquals(nombre,expected)

  }


}
