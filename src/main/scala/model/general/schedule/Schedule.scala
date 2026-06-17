package model.general.schedule

import model.general.GameUnit
import scala.collection.mutable

/** Trait that defines basic operations for managing a game schedule of Playable objects.
 * This trait provides methods to add players, delete players, reset a player's action bar,
 * fill the action bar of all players, and determine if any player in a given queue can play.
 */
trait Schedule {

  /** Adds a player to the game schedule.
   * @param pj The player (Playable) to be added.
   */
  def addPlayer(pj: GameUnit): Unit

  /** Deletes a player from the game schedule.
   * @param pj The player (Playable) to be deleted.
   */
  def deletePlayer(pj: GameUnit): Unit

  /** Resets the action bar of a player.
   * @param pj The player (Playable) whose action bar is to be reset.
   */
  def resetActionBar(pj: GameUnit): Unit

  /** Fills the action bar of all players in the game schedule.
   * @param n The value to add to each player's action bar.
   */
  def fillActionBar(n: Int): Unit

  /** Determines if any player in a given queue can play, if they have enough accumulated action.
   * @param q The queue of players (mutable.Queue[Playable]) to evaluate.
   * @return The first player in the queue (mutable.Queue[Playable]) who can play based on accumulated action, or `null` if none can play.
   */
  def CanPlay(q: mutable.Queue[GameUnit]): GameUnit

}

