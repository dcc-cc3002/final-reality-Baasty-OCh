package playable
import model.playable.Playable
import model.playable.{APlayable, Guerrero, Paladin,Ninja}
import munit.FunSuite
class CharacterTest extends FunSuite {
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Character
  var Casemiro: Playable = _ // We declare a variable Messi of type Character
  var Messi: Playable = _ // We declare a variable Messi of type Character

  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Paladin("Cristiano")
    Casemiro = new Guerrero("Casemiro")
    Messi = new Ninja("Messi")

  }
  test("equals") { // Test if two references to the same character are equal
    assertEquals(Cristiano, Cristiano)
    assertEquals(Messi, Messi)
    assertEquals(Casemiro,Casemiro)
  }

  test("NotEquals") { // Test if two references to different characters are not equal
    assertNotEquals(Messi, Cristiano)
    assertNotEquals(Messi, Casemiro)
    assertNotEquals(Casemiro, Cristiano)
  }

  test("setName") { // Test if the returned name value for a character matches the expected value
    var name = Cristiano.getName // Retrieve the name value of the character Cristiano and store it in the 'name' variable
    var name2 = Messi.getName
    var name3 = Casemiro.getName
    assertEquals(name, "Cristiano") // Compare the actual name value with the expected value
    assertEquals(name2, "Messi")
    assertEquals(name3, "Casemiro")
  }

  test("NotEqualsName") { // Test if the name values of two different characters are not equal
    var name1 = Cristiano.getName // Retrieve the name value of the character Cristiano and store it in the 'name1' variable
    var name2 = Messi.getName // Retrieve the name value of the character Messi and store it in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the name values of Cristiano and Messi are not equal
  }

  test("equalsLife") { // Test if the returned life value for a character matches the expected value
    var life = Cristiano.getHp // Retrieve the life value of the character Cristiano and store it in the 'life' variable
    var life2 = Messi.getHp
    var life3 = Casemiro.getHp
    assertEquals(life, 100) // Compare the actual life value with the expected value
    assertEquals(life2, 80)
    assertEquals(life3, 120)
  }

  test("NotEqualsLife") { // Test if the life values of two different characters are not equal
    var life1 = Cristiano.getHp // Retrieve the life value of the character Cristiano and store it in the 'life1' variable
    var life2 = Messi.getHp // Retrieve the life value of the character Messi and store it in the 'life2' variable
    assertNotEquals(life1, life2) // Assert that the life values of Cristiano and Messi are not equal
  }
  test("equalsDefence") { // Test if the returned defense value for a character matches the expected value
    var defense = Cristiano.getDp // Retrieve the defense value of the character Cristiano and store it in the 'defense' variable
    var defense2 = Messi.getDp
    var defense3 = Casemiro.getDp
    assertEquals(defense, 75) // Compare the actual defense value with the expected value
    assertEquals(defense2, 70)
    assertEquals(defense3, 100)
  }

  test("NotEqualsDefence") { // Test if the defense values of two different characters are not equal
    var defense1 = Cristiano.getDp // Retrieve the defense value of the character Cristiano and store it in the 'defense1' variable
    var defense2 = Messi.getDp // Retrieve the defense value of the character Messi and store it in the 'defense2' variable
    assertNotEquals(defense1, defense2) // Assert that the defense values of Cristiano and Messi are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for a character matches the expected value
    var weight = Cristiano.getWeight // Retrieve the weight value of the character Cristiano and store it in the 'weight' variable
    var weight2 = Messi.getWeight
    var weight3 = Casemiro.getWeight// Define the expected weight value
    assertEquals(weight, 50) // Compare the actual weight value with the expected value
    assertEquals(weight2, 30)
    assertEquals(weight3, 70)
  }

  test("NotEqualsWeight") { // Test if the weight values of two different characters are not equal
    var weight1 = Cristiano.getWeight // Retrieve the weight value of the character Cristiano and store it in the 'weight1' variable
    var weight2 = Messi.getWeight // Retrieve the weight value of the character Messi and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Cristiano and Messi are not equal
  }

  test("zeroMana") { // Test if the returned kind value for a character matches the expected value
    var mana = Cristiano.getMana // Retrieve the kind value of the character Cristiano and store it in the 'kind' variable
    var mana2 = Messi.getMana
    var mana3 = Casemiro.getMana
    var expected: Int = 0 // Define the expected kind value
    assertEquals(mana, expected) // Compare the actual kind value with the expected value
    assertEquals(mana2, expected)
    assertEquals(mana3, expected)
  }
  test("checkWeapon"){
    assertEquals(Cristiano.haveWeapon,false)
    assertEquals(Messi.haveWeapon,false)
    assertEquals(Casemiro.haveWeapon,false)
  }



}