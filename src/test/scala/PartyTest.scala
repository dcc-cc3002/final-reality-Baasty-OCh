import munit.FunSuite
import model.party.Party
import model.playable.{Playable,Paladin,Guerrero,Ninja,MagoBlanco,MagoNegro}
import model.nonplayable.{Enemy, AWeapon, Sword, Axe, Bow, Staff, Wand}
class PartyTest extends FunSuite {
  var Team1: Party = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable


  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Paladin("Cristiano",0,50,50,0,false)

    // Creates a new instance of the MagicCharacter class with the specified parameters:
    Alexis = new MagoBlanco("Alexis")// - Kind: Mago Blanco // - Weapon: false

  }
  test("addCharacter") { // Test the method to add a character
    Team1.addPlayable(Cristiano) // Add the character Cristiano
    val expected: Map[Any, Playable] = Map(Cristiano.getClass -> Cristiano) // The expected variable will be a map with the type and name of the character
    assertEquals(Team1.allies.toMap, expected) // Compare the result with the Map
  }

  test("isEmpty") { // Test if the team is initially empty
    var state: Boolean = Team1.isDefeated // Create a variable 'state' that stores the result of checking if a party is defeated
    assertEquals(state, true) // Compare the results
  }
  test("isDefeat") { // Test if a party is defeated or not
    Team1.addPlayable(Cristiano) // Add a character with zero health
    assertEquals(Team1.isDefeated, true) // Check if they are defeated or not (a team with no health is defeated) -> true
  }
  test("isNotDefeat") { // Test if a party is not defeated
    Alexis = new MagoBlanco("Alexis")
    Team1.addPlayable(Alexis) // Add that living character
    assertEquals(Team1.isDefeated, false) // Check that the team is alive (false)
  }





}
