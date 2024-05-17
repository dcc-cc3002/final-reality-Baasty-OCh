package model.controller

import model.playable.common.Paladin
import model.playable.magic.WhiteMagican
import model.playable.{APlayable, Playable}

import scala.collection.mutable
import scala.collection.mutable.{Map, Queue}

/** Class representing a turn schedule that implements the `Schedule` trait.
 *
 * This class manages the turn-based gameplay schedule for playable characters.
 * It keeps track of the action bars and turn order of the characters.
 */
class TurnSchedule extends Schedule {

  /** Map to store the action bars of playable characters.
   * The key is a Playable character, and the value is a tuple of (maximum action bar value, current action bar value).
   */
  val actionBar: Map[GameUnit, (Int, Int)] = Map()

  /** Queue to maintain the turn order of playable characters. */
  val turns: Queue[GameUnit] = Queue()

  /** Adds a playable character to the turn schedule.
   * @param pj The playable character to add.
   */
  def addPlayer(pj: GameUnit): Unit = {
    val maxActionBar = pj.getWeight
    var cntBar = 0
    actionBar.put(pj, (maxActionBar, cntBar))
  }

  /** Deletes a playable character from the turn schedule.
   * @param pj The playable character to delete.
   */
  def deletePlayer(pj: GameUnit): Unit = {
    if (actionBar.contains(pj)) {
      actionBar.remove(pj)
    }
  }

  /** Resets the action bar of a playable character to its initial state.
   * @param pj The playable character whose action bar to reset.
   *           buscar solucion mas sencilla
   */
  def resetActionBar(pj: GameUnit): Unit = {
    actionBar.get(pj).foreach {
      case (maxActionBar, _) =>
        actionBar.update(pj, (maxActionBar, 0))
    }
  }

  /** Fills the action bar of all playable characters in the schedule.
   * Increases the current action bar value by the specified amount and handles turn queueing.
   * @param n The amount to increase the action bar by for each playable character.
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

  /** Determines if a playable character from the specified queue can play.
   * Removes and returns the first playable character from the queue.
   * @param q The queue of playable characters.
   * @return The first playable character from the queue.
   */
  def CanPlay(q: mutable.Queue[GameUnit]): GameUnit = {
    val player1: GameUnit = q.head
    q.dequeue()
    player1
  }

}
