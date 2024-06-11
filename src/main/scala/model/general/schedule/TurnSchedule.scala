package model.general.schedule

import model.general.GameUnit
import model.playable.Playable

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}

/** Class representing a turn schedule that implements the `Schedule` trait.
 * This class manages the turn-based gameplay schedule for players (characters and enemies).
 * It keeps track of the action bars and turn order of the players (characters and enemies).
 */
class TurnSchedule extends Schedule {

  /** Map to store the action bars of players (characters and enemies).
   * The key is a Playable character, and the value is a tuple of (maximum action bar value, current action bar value).
   */
  val actionBar: Map[GameUnit, (Int, Int)] = Map()

  /** Queue to maintain the turn order of players (characters and enemies). */
  val turns: Queue[GameUnit] = Queue()

  /** Adds a players (characters and enemies) to the turn schedule.
   * @param pj The players (characters and enemies) to add.
   */
  def addPlayer(pj: GameUnit): Unit = {
    val weaponWeight = pj.arma.map(_.getWeight).getOrElse(0)
    val maxActionBar = pj.getWeight + (if ((weaponWeight * 0.5).toInt % 2 == 1) (weaponWeight * 0.5 + 1).toInt
    else (weaponWeight * 0.5).toInt)
    var cntBar = 0
    actionBar.put(pj, (maxActionBar, cntBar))
  }

  /** Deletes a players (characters and enemies) from the turn schedule.
   * @param pj The players (characters and enemies) to delete.
   */
  def deletePlayer(pj: GameUnit): Unit = {
    if (actionBar.contains(pj)) {
      actionBar.remove(pj)
    }
  }

  /** Resets the action bar of a players (characters and enemies) to its initial state.
   * @param pj The players (characters and enemies) whose action bar to reset.
   *           buscar solucion mas sencilla
   */
  def resetActionBar(pj: GameUnit): Unit = {
    actionBar.get(pj).foreach {
      case (maxActionBar, _) =>
        actionBar.update(pj, (maxActionBar, 0))
    }
  }

  /** Fills the action bar of all players (characters and enemies) in the schedule.
   * Increases the current action bar value by the specified amount and handles turn queueing.
   * @param n The amount to increase the action bar by for each players (characters and enemies).
   */
  def fillActionBar(n: Int): Unit = {
    actionBar.keys.foreach { key =>
      val (maxActionBar, cntBar) = actionBar.getOrElse(key, (0, 0))
      val newCntBar = cntBar + n
      actionBar.update(key, (maxActionBar, newCntBar))
      if (newCntBar >= maxActionBar) {
        turns.enqueue(key)
        actionBar.update(key, (maxActionBar, 0))
      }
    }
  }


  /** Determines if a players (characters and enemies) from the specified queue can play.
   * Removes and returns the first players (characters and enemies) from the queue.
   * @param q The queue of players (characters and enemies).
   * @return The first players (characters and enemies) from the queue.
   */
  def CanPlay(q: mutable.Queue[GameUnit]): GameUnit = {
    val player1: GameUnit = q.head
    q.dequeue()
    player1
  }

}
