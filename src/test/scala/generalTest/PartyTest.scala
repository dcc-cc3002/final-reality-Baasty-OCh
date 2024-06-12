package generalTest

import model.general.party.Party
import model.playable.magic.WhiteMagican
import model.playable.Playable
import model.playable.common.{Ninja, Paladin}
import munit.FunSuite

/**
 * Test suite for the Party class.
 * This class contains unit tests for the Party class, which manages a group of playable characters.
 * It utilizes the munit.FunSuite framework for organizing and running tests.
 */
class PartyTest extends FunSuite {
  var Team1: Party = _
  var Cristiano: Playable = _
  var Alexis: Playable = _
  var Vinicius: Playable = _
  var Bellingham: Playable = _

  /**
   * Set up the test environment before each test case.
   * This method initializes the Party and Playable instances before each test is run.
   * It ensures a fresh setup for each test case to maintain test isolation and reliability.
   *
   * @param context The context provided by the test framework (BeforeEach).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party()
    Cristiano = new Paladin("Cristiano", 0, 50, 50)
    Vinicius = new Ninja("Vini Jr")
    Bellingham = new WhiteMagican("Jude")
    Alexis = new WhiteMagican("Alexis")
  }

  /**
   * Test case to verify adding a playable character to the Party.
   * This test adds a playable character to the Party and checks if the character is added successfully.
   */
  test("addCharacter") {
    assertEquals(Team1.addGameUnit(Cristiano), "The unit was added successfully.")
  }

  /**
   * Test case to verify that adding more than three players to the Party throws an exception.
   * This test adds three playable characters to the Party and checks if adding a fourth character
   * throws an exception indicating that the Party is full.
   */
  test("It should throw an exception if the Party cant added more than 3 players") {
    assertEquals(Team1.addGameUnit(Cristiano), "The unit was added successfully.")
    assertEquals(Team1.addGameUnit(Vinicius), "The unit was added successfully.")
    assertEquals(Team1.addGameUnit(Bellingham), "The unit was added successfully.")

    assertEquals(Team1.addGameUnit(Alexis), "The party cannot add more than 3 players; it is full.")
  }

  /**
   * Test case to verify if the Party is initially empty.
   * This test checks the initial state of the Party to verify if it is empty.
   */
  test("isEmpty") {
    val state: Boolean = Team1.isDefeated
    assertEquals(state, true)
  }

  /**
   * Test case to verify if the Party is defeated after adding a playable character.
   * This test adds a playable character to the Party and checks if the Party is still considered defeated.
   */
  test("isDefeat") {
    Team1.addGameUnit(Cristiano)
    assertEquals(Team1.isDefeated, true)
  }

  /**
   * Test case to verify if the Party is not defeated after adding a non-defeated playable character.
   * This test adds a non-defeated playable character to the Party and checks if the Party is not considered defeated.
   */
  test("isNotDefeat") {
    Alexis = new WhiteMagican("Alexis")
    Team1.addGameUnit(Alexis)
    assertEquals(Team1.isDefeated, false)
  }
}
