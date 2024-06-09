package generalTest

import model.general.GameUnit
import model.general.schedule.TurnSchedule
import model.playable.common.{Paladin, Warrior}
import model.playable.magic.WhiteMagican
import munit.FunSuite
import scala.collection.mutable

/**
 * Test suite for the TurnSchedule class.
 * This class contains unit tests for the TurnSchedule class, which manages the turn order
 * and action bars for game units during gameplay. It utilizes the munit.FunSuite framework
 * for organizing and running tests.
 */
class TurnScheduleTest extends FunSuite {
  var Team1: TurnSchedule = _
  var Cristiano: GameUnit = _
  var Alexis: GameUnit = _
  var Messi: GameUnit = _

  /**
   * Set up the test environment before each test case.
   * This method initializes the TurnSchedule and GameUnit instances before each test is run.
   * It ensures a fresh setup for each test case to maintain test isolation and reliability.
   * @param context The context provided by the test framework (BeforeEach).
   */
  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new TurnSchedule()
    Cristiano = new Paladin("Cristiano", 0, 50, 50)
    Alexis = new WhiteMagican("Alexis")
    Messi = new Warrior("Messi")
  }

  /**
   * Test case to verify the addition of a player to the TurnSchedule.
   * This test adds a player to the TurnSchedule and checks if the player is added correctly
   * with the expected initial action bar values.
   */
  test("addPlayer") {
    Team1.addPlayer(Cristiano)
    val expected: Map[GameUnit, (50, 0)] = Map(Cristiano -> (50, 0))

    assertEquals(Team1.actionBar.toMap, expected)
  }

  /**
   * Test case to check if the TurnSchedule's action bar is initially empty.
   * This test verifies that the action bar is empty when no players have been added to the TurnSchedule.
   */
  test("isEmpty") {
    assertEquals(Team1.actionBar.isEmpty, true)
  }

  /**
   * Test case to verify the deletion of a player from the TurnSchedule.
   * This test adds a player to the TurnSchedule, ensures the action bar is not empty, then
   * deletes the player and checks if the action bar is empty again.
   */
  test("deletePlayer") {
    Team1.addPlayer(Cristiano)
    assertEquals(Team1.actionBar.isEmpty, false)

    Team1.deletePlayer(Cristiano)
    assertEquals(Team1.actionBar.isEmpty, true)
  }

  /**
   * Test case to verify filling the action bar for multiple players.
   * This test adds multiple players to the TurnSchedule, fills their action bars, and checks
   * if the action bar values are updated correctly.
   */
  test("fillActionBar") {
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(12)
    val expected: Map[GameUnit, (Int, Int)] = Map(Cristiano -> (50, 12), Alexis -> (60, 12))

    assertEquals(Team1.actionBar.toMap, expected)
  }

  /**
   * Test case to verify resetting the action bar for a specific player.
   * This test adds multiple players to the TurnSchedule, fills their action bars, resets the
   * action bar for one player, and checks if the action bar values are updated correctly.
   */
  test("resetActionBar") {
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(12)
    Team1.resetActionBar(Cristiano)
    val expected: Map[GameUnit, (Int, Int)] = Map(Cristiano -> (50, 0), Alexis -> (60, 12))

    assertEquals(Team1.actionBar.toMap, expected)
  }

  /**
   * Test case to verify the turn order of players.
   * This test adds multiple players to the TurnSchedule, fills their action bars, and checks
   * if the turn order queue is updated correctly.
   */
  test("Turns") {
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(55)
    Team1.fillActionBar(20)
    val expected: mutable.Queue[GameUnit] = mutable.Queue(Cristiano, Alexis)

    assertEquals(Team1.turns, expected)
  }

  /**
   * Test case to verify if players can take turns.
   * This test adds multiple players to the TurnSchedule, fills their action bars, and checks
   * if the correct player is returned as able to take their turn.
   */
  test("canPlay") {
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(55)
    Team1.fillActionBar(20)
    val expected: GameUnit = Team1.CanPlay(Team1.turns)
    val expected2: GameUnit = Team1.CanPlay(Team1.turns)

    assertEquals(Cristiano, expected)
    assertEquals(Alexis, expected2)
  }

}
