import model.playable.{Character, MagicCharacter,Playable}
import munit.FunSuite
class MagicCharacterTest extends FunSuite {
  var Alexis: MagicCharacter = _ // We declare a variable Alexis of type MagicCharacter
  var Vidal: MagicCharacter = _ // We declare a variable Vidal of type MagicCharacter

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Magic Character class with the specified parameters:
    Alexis = new MagicCharacter("Alexis", 80, // - Name: Alexis // - Life: 80
                                      55, 65, // - Defence : 55 // - Weight: 65
                                      "Mago Blanco", false, 90) // - Kind: Mago Blanco // - Weapon: false
    // Creates a new instance of the Magic Character class with the specified parameters:
    Vidal = new MagicCharacter("Vidal", 90, // - Name: Vidal // - Life: 90
                                   100, 70, // - Defence : 100 // - Weight: 70
                                   "Mago Negro", true, 50) // - Kind: Mago Negro // - Weapon: true

  }
  test("equalsName") { // Test if the sayName method behaves correctly
    var name = Alexis.sayName() // Store the name of the character in the 'name' variable
    val expected: String = "Alexis" // Declare the variable for comparison
    assertEquals(name, expected) // Compare the results
  }


  test("NotEqualsName") { // Test if the names returned by the sayName method for two different characters are not equal
    var name1 = Alexis.sayName() // Store the name of the first character in the 'name1' variable
    var name2 = Vidal.sayName() // Store the name of the second character in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the two names are not equal
  }
  test("equalsLife") { // Test if the returned life value for a character matches the expected value
    var life = Alexis.sayLife() // Retrieve the life value of the character Alexis and store it in the 'life' variable
    var expected: Int = 80 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }
  test("NotEqualsLife") { // Test if the life values of two different characters are not equal
    var life1 = Alexis.sayLife() // Retrieve the life value of the character Alexis and store it in the 'life1' variable
    var life2 = Vidal.sayLife() // Retrieve the life value of the character Vidal and store it in the 'life2' variable
    assertNotEquals(life1, life2) // Assert that the life values of Alexis and Vidal are not equal
  }
  test("equalsDefence") { // Test if the returned defense value for a character matches the expected value
    var defense = Alexis.sayDefence() // Retrieve the defense value of the character Alexis and store it in the 'defense' variable
    var expected: Int = 55 // Define the expected defense value
    assertEquals(defense, expected) // Compare the actual defense value with the expected value
  }
  test("NotEqualsDefence") { // Test if the defense values of two different characters are not equal
    var defense1 = Alexis.sayDefence() // Retrieve the defense value of the character Alexis and store it in the 'defense1' variable
    var defense2 = Vidal.sayDefence() // Retrieve the defense value of the character Vidal and store it in the 'defense2' variable
    assertNotEquals(defense1, defense2) // Assert that the defense values of Alexis and Vidal are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for a character matches the expected value
    var weight = Alexis.sayWeight() // Retrieve the weight value of the character Alexis and store it in the 'weight' variable
    var expected: Int = 65 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different characters are not equal
    var weight1 = Alexis.sayWeight() // Retrieve the weight value of the character Alexis and store it in the 'weight1' variable
    var weight2 = Vidal.sayWeight() // Retrieve the weight value of the character Vidal and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Alexis and Vidal are not equal
  }

  test("haveWeapon") { // Test if the character Vidal has a weapon
    val hasWeapon = Vidal.havWeapon() // Check if the character Vidal has a weapon and store the result in the 'hasWeapon' variable
    var expected = true // Define the expected value indicating that Vidal has a weapon
    assertEquals(hasWeapon, expected) // Compare the actual result with the expected value
  }

  test("haveNotWeapon") { // Test if the character Alexis doesn't have a weapon
    val hasWeapon = Alexis.havWeapon() // Check if the character Alexis has a weapon and store the result in the 'hasWeapon' variable
    var expected = false // Define the expected value indicating that Alexis doesn't have a weapon
    assertEquals(hasWeapon, expected) // Compare the actual result with the expected value
  }

  test("equalsMana") { // Test if the returned mana value for a character matches the expected value
    var mana = Alexis.sayMana() // Retrieve the mana value of the character Alexis and store it in the 'mana' variable
    var expected: Int = 90 // Define the expected mana value
    assertEquals(mana, expected) // Compare the actual mana value with the expected value
  }

  test("NotEqualsMana") { // Test if the mana values of two different characters are not equal
    var mana1 = Alexis.sayMana() // Retrieve the mana value of the character Alexis and store it in the 'mana1' variable
    var mana2 = Vidal.sayMana() // Retrieve the mana value of the character Vidal and store it in the 'mana2' variable
    assertNotEquals(mana1, mana2) // Assert that the mana values of Alexis and Vidal are not equal
  }

  test("equalsMagicKind") { // Test if the returned magic kind for a character matches the expected value
    var magicKind = Alexis.sayKind() // Retrieve the magic kind of the character Alexis and store it in the 'magicKind' variable
    var expected: String = "Mago Blanco" // Define the expected magic kind
    assertEquals(magicKind, expected) // Compare the actual magic kind with the expected value
  }

  test("NotEqualsMagicKind") { // Test if the magic kinds of two different characters are not equal
    var magicKind1 = Alexis.sayKind() // Retrieve the magic kind of the character Alexis and store it in the 'magicKind1' variable
    var magicKind2 = Vidal.sayKind() // Retrieve the magic kind of the character Vidal and store it in the 'magicKind2' variable
    assertNotEquals(magicKind1, magicKind2) // Assert that the magic kinds of Alexis and Vidal are not equal
  }

  test("equalsMagicCharacter") { // Test if two references to the same magic character are equal
    val pmc: MagicCharacter = Alexis // Create a reference to the character Alexis and assign it to the variable 'pmc'
    var expected = Alexis // Define the expected value as the character Alexis
    assertEquals(pmc, expected) // Compare the actual reference with the expected value
  }

  test("NotEqualsMagicCharacter") { // Test if two references to different magic characters are not equal
    val pmc1: MagicCharacter = Alexis // Create a reference to the character Alexis and assign it to the variable 'pmc1'
    val pmc2: MagicCharacter = Vidal // Create a reference to the character Vidal and assign it to the variable 'pmc2'
    assertNotEquals(pmc1, pmc2) // Assert that the references to Alexis and Vidal are not equal
  }




}