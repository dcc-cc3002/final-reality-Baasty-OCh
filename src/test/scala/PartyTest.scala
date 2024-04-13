import munit.FunSuite
import model.party.Party
import model.playable.{Character,MagicCharacter,Playable}
import model.nonplayable.{Enemy,Weapon,MagicWeapon}
class PartyTest extends FunSuite {
  var Team1: Party = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable


  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Character("Cristiano",0, // - Name: Cristiano // - Life: 0
                                       50,70, // - Defence : 50 // - Weight: 70
                                       "Paladin",false)  // - Kind: Paladin // - Weapon: false

    // Creates a new instance of the MagicCharacter class with the specified parameters:
    Alexis = new MagicCharacter("Alexis", 0, // - Name: Alexis // - Life: 0
                                    55, 65, // - Defence : 55 // - Weight: 65
                                    "Mago Blanco", false, 90) // - Kind: Mago Blanco // - Weapon: false

  }
  test("addCharacter") { // Test the method to add a character
    Team1.addPlayable(Cristiano) // Add the character Cristiano
    val expected: Map[String, Playable] = Map("Paladin" -> Cristiano) // The expected variable will be a map with the type and name of the character
    assertEquals(Team1.allies.toMap, expected) // Compare the result with the Map
  }

  test("addMagicCharacter") { // Test if the method also works for adding a magic character
    Team1.addPlayable(Alexis) // Add a magic character, Alexis
    val expected: Map[String, Playable] = Map("Mago Blanco" -> Alexis) // The expected variable will be a map with the type and name of the character
    assertEquals(Team1.allies.toMap, expected) // Compare the result with the Map
  }

  test("isEmpty") { // Test if the team is initially empty
    var state: Boolean = Team1.isDefeated // Create a variable 'state' that stores the result of checking if a party is defeated
    assertEquals(state, true) // Compare the results
  }
  test("isDefeat") { // Test if a party is defeated or not
    Team1.addPlayable(Cristiano) // Add a character with zero health
    Team1.addPlayable(Alexis) // Add a magic character with zero health
    assertEquals(Team1.isDefeated, true) // Check if they are defeated or not (a team with no health is defeated) -> true
  }
  test("isNotDefeat") { // Test if a party is not defeated
    Team1.addPlayable(Cristiano) // Add a character with zero health
    Alexis = new MagicCharacter("Alexis", 100, 90, 10, "Mago Blanco", false, 50) // Create a magic character with health not equal to zero
    Team1.addPlayable(Alexis) // Add that living character
    assertEquals(Team1.isDefeated, false) // Check that the team is alive (false)
  }





}
