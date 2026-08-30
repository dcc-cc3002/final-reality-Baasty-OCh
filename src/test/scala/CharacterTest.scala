import munit.FunSuite
import model.playable.{Character, MagicCharacter, Playable}
class CharacterTest extends FunSuite {
  var Cristiano: Character = _ // We declare a variable Cristiano of type Character
  var Messi: Character = _ // We declare a variable Messi of type Character

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Character("Cristiano",100,50 // - Name: Cristiano // - Life: 100 // - Defence : 50
                             ,70,"Paladin",false) // - Weight: 70 // - Kind: Paladin // - Weapon: false
    // Creates a new instance of the Character class with the specified parameters:
    Messi = new Character("Messi",90,40, // - Name: Messi // - Life: 90 // - Defence : 40
                         60,"Guerrero",true) // - Weight: 60 // - Kind: Guerrero // - Weapon: true

  }
  test("equals") { // Test if two references to the same character are equal
    val character: Character = Cristiano // Create a reference to the character Cristiano and assign it to the variable 'character'
    var expected = Cristiano // Define the expected value as the character Cristiano
    assertEquals(character, expected) // Compare the actual reference with the expected value
  }

  test("NotEquals") { // Test if two references to different characters are not equal
    val character1: Character = Cristiano // Create a reference to the character Cristiano and assign it to the variable 'character1'
    val character2: Character = Messi // Create a reference to the character Messi and assign it to the variable 'character2'
    assertNotEquals(character1, character2) // Assert that the references to Cristiano and Messi are not equal
  }

  test("equalsName") { // Test if the returned name value for a character matches the expected value
    var name = Cristiano.sayName() // Retrieve the name value of the character Cristiano and store it in the 'name' variable
    val expected: String = "Cristiano" // Define the expected name value
    assertEquals(name, expected) // Compare the actual name value with the expected value
  }

  test("NotEqualsName") { // Test if the name values of two different characters are not equal
    var name1 = Cristiano.sayName() // Retrieve the name value of the character Cristiano and store it in the 'name1' variable
    var name2 = Messi.sayName() // Retrieve the name value of the character Messi and store it in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the name values of Cristiano and Messi are not equal
  }

  test("equalsLife") { // Test if the returned life value for a character matches the expected value
    var life = Cristiano.sayLife() // Retrieve the life value of the character Cristiano and store it in the 'life' variable
    var expected: Int = 100 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }

  test("NotEqualsLife") { // Test if the life values of two different characters are not equal
    var life1 = Cristiano.sayLife() // Retrieve the life value of the character Cristiano and store it in the 'life1' variable
    var life2 = Messi.sayLife() // Retrieve the life value of the character Messi and store it in the 'life2' variable
    assertNotEquals(life1, life2) // Assert that the life values of Cristiano and Messi are not equal
  }
  test("equalsDefence") { // Test if the returned defense value for a character matches the expected value
    var defense = Cristiano.sayDefence() // Retrieve the defense value of the character Cristiano and store it in the 'defense' variable
    var expected: Int = 50 // Define the expected defense value
    assertEquals(defense, expected) // Compare the actual defense value with the expected value
  }

  test("NotEqualsDefence") { // Test if the defense values of two different characters are not equal
    var defense1 = Cristiano.sayDefence() // Retrieve the defense value of the character Cristiano and store it in the 'defense1' variable
    var defense2 = Messi.sayDefence() // Retrieve the defense value of the character Messi and store it in the 'defense2' variable
    assertNotEquals(defense1, defense2) // Assert that the defense values of Cristiano and Messi are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for a character matches the expected value
    var weight = Cristiano.sayWeight() // Retrieve the weight value of the character Cristiano and store it in the 'weight' variable
    var expected: Int = 70 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different characters are not equal
    var weight1 = Cristiano.sayWeight() // Retrieve the weight value of the character Cristiano and store it in the 'weight1' variable
    var weight2 = Messi.sayWeight() // Retrieve the weight value of the character Messi and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Cristiano and Messi are not equal
  }

  test("equalsKind") { // Test if the returned kind value for a character matches the expected value
    var kind = Cristiano.sayKind() // Retrieve the kind value of the character Cristiano and store it in the 'kind' variable
    var expected: String = "Paladin" // Define the expected kind value
    assertEquals(kind, expected) // Compare the actual kind value with the expected value
  }

  test("NotEqualsKind") { // Test if the kind values of two different characters are not equal
    var kind1 = Cristiano.sayKind() // Retrieve the kind value of the character Cristiano and store it in the 'kind1' variable
    var kind2 = Messi.sayKind() // Retrieve the kind value of the character Messi and store it in the 'kind2' variable
    assertNotEquals(kind1, kind2) // Assert that the kind values of Cristiano and Messi are not equal
  }

  test("haveWeapon") { // Test if the character Messi has a weapon
    val hasWeapon = Messi.havWeapon() // Check if the character Messi has a weapon and store the result in the 'hasWeapon' variable
    var expected = true // Define the expected value indicating that Messi has a weapon
    assertEquals(hasWeapon, expected) // Compare the actual result with the expected value
  }

  test("haveNotWeapon") { // Test if the character Cristiano doesn't have a weapon
    val hasWeapon = Cristiano.havWeapon() // Check if the character Cristiano has a weapon and store the result in the 'hasWeapon' variable
    var expected = false // Define the expected value indicating that Cristiano doesn't have a weapon
    assertEquals(hasWeapon, expected) // Compare the actual result with the expected value
  }


}