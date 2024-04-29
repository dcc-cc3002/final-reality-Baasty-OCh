package playable
import model.playable.Playable
import model.playable.{MagoBlanco, MagoNegro}
import munit.FunSuite
class MagicCharacterTest extends FunSuite {
  var Alexis: Playable = _ // We declare a variable Alexis of type MagicCharacter
  var Vidal: Playable = _ // We declare a variable Vidal of type MagicCharacter
  var Medel : Playable = _

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Magic Character class with the specified parameters:
    Alexis = new MagoBlanco("Alexis")
    Vidal = new MagoNegro("Vidal")

  }
  test("equals") { // Test if two references to the same character are equal
    assertEquals(Vidal,Vidal)
    assertEquals(Alexis,Alexis)
  }

  test("NotEquals") { // Test if two references to different characters are not equal
  assertNotEquals(Vidal,Alexis)
  }

  test("SetName") { // Test if the sayName method behaves correctly
    var name = Alexis.getName // Store the name of the character in the 'name' variable
    val expected: String = "Alexis"
    assertEquals(name, expected)
  }

  test("NotEqualsName") { // Test if the names returned by the sayName method for two different characters are not equal
    var name1 = Alexis.getName // Store the name of the first character in the 'name1' variable
    var name2 = Vidal.getName // Store the name of the second character in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the two names are not equal
  }
  test("SetLife") { // Test if the returned life value for a character matches the expected value
    var life = Alexis.getHp // Retrieve the life value of the character Alexis and store it in the 'life' variable
    var expected: Int = 100 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }
  test("NotEqualsLife") { // Test if the life values of two different characters are not equal
    var life1 = Alexis.getHp // Retrieve the life value of the character Alexis and store it in the 'life1' variable
    var life2 = Vidal.getHp // Retrieve the life value of the character Vidal and store it in the 'life2' variable
    assertNotEquals(life1, life2) // Assert that the life values of Alexis and Vidal are not equal
  }

  test("SetDefense") { // Test if the returned life value for a character matches the expected value
    var life = Alexis.getDp // Retrieve the life value of the character Alexis and store it in the 'life' variable
    var expected: Int = 80 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }

  test("NotEqualsDefence") { // Test if the defense values of two different characters are not equal
    var defense1 = Alexis.getDp // Retrieve the defense value of the character Alexis and store it in the 'defense1' variable
    var defense2 = Vidal.getDp // Retrieve the defense value of the character Vidal and store it in the 'defense2' variable
    assertNotEquals(defense1, defense2) // Assert that the defense values of Alexis and Vidal are not equal
  }

  test("SetWeight") { // Test if the returned life value for a character matches the expected value
    var life = Alexis.getWeight // Retrieve the life value of the character Alexis and store it in the 'life' variable
    var expected: Int = 60 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different characters are not equal
    var weight1 = Alexis.getWeight // Retrieve the weight value of the character Alexis and store it in the 'weight1' variable
    var weight2 = Vidal.getWeight // Retrieve the weight value of the character Vidal and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Alexis and Vidal are not equal
  }

  test("SetMana") { // Test if the returned life value for a character matches the expected value
    var life = Alexis.getMana // Retrieve the life value of the character Alexis and store it in the 'life' variable
    var expected: Int = 40 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }
  test("checkWeapon"){
    assertEquals(Alexis.haveWeapon,false)
    assertEquals(Vidal.haveWeapon,false)
  }







}