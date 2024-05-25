package controller

import model.party.Party
import model.playable.magic.WhiteMagican
import model.playable.Playable
import model.playable.common.{Ninja, Paladin}
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
class PartyTest extends FunSuite {
  var Team1: Party = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable
  var Vinicius: Playable = _
  var Bellingham : Playable = _


  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Paladin("Cristiano",0,50,50)
    Vinicius = new Ninja("Vini Jr")
    Bellingham = new WhiteMagican("Jude")
    Alexis = new WhiteMagican("Alexis")// - Kind: Mago Blanco // - Weapon: false

  }
  test("addCharacter") {
    assertEquals(Team1.addPlayable(Cristiano),"The allie was add successfully")
  }

  test("It should throw an exception if the Party cant add more than 3 players"){
    assertEquals(Team1.addPlayable(Cristiano),"The allie was add successfully")
    assertEquals(Team1.addPlayable(Vinicius),"The allie was add successfully")
    assertEquals(Team1.addPlayable(Bellingham),"The allie was add successfully")

    assertEquals(Team1.addPlayable(Alexis),"The Party cant add more than 3 players, is full")
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
    Alexis = new WhiteMagican("Alexis")
    Team1.addPlayable(Alexis) // Add that living character
    assertEquals(Team1.isDefeated, false) // Check that the team is alive (false)
  }





}
