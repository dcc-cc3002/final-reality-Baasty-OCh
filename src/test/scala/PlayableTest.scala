import munit.FunSuite
import model.playable.Playable
import model.playable.Character
class PlayableTest extends FunSuite{
  var Cristiano: Playable = _
  var Messi: Playable = _

  override def beforeEach(context: BeforeEach): Unit = {
     Cristiano = new Character()
     Messi  = new Character()
  }

  test("equalsName") {
    var nombre = Cristiano.sayName("Cristiano")
    val expected: String = "Cristiano"
    assertEquals(nombre, expected)
  }

    test("NotequalsName"){
      var nombre1 = Cristiano.sayName("Cristiano")
      var nombre2 = Messi.sayName("Messi")
      assertNotEquals(nombre1,nombre2)

  }


}
