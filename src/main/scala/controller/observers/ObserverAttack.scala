package controller.observers

import model.general.GameUnit
import model.spell.Spell
import view.GameView

/**
 * The ObserverAttack class is responsible for notifying the game view about different types of attacks.
 *
 * @constructor Creates an ObserverAttack with the specified game view.
 * @param view The GameView instance to be updated with attack notifications.
 */
class ObserverAttack(private val view: GameView) {

  /**
   * Notifies the view about a simple attack.
   *
   * @param src The GameUnit that initiates the attack.
   * @param dest The GameUnit that is the target of the attack.
   * @param dmg The amount of damage dealt by the attack.
   */
  def notifySimpleAttack(src: GameUnit, dest: GameUnit, dmg: Int): Unit = {
    view.displaySimpleAttack(src, dest, dmg)
  }

  /**
   * Notifies the view about a spell-based attack.
   *
   * @param src The GameUnit that initiates the attack.
   * @param dest The GameUnit that is the target of the attack.
   * @param sp The Spell being cast in the attack.
   * @param dmg The amount of damage dealt by the spell.
   */
  def notifySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell, dmg: Int): Unit = {
    view.displaySpellAttack(src, dest, sp, dmg)
  }

  /**
   * Notifies the view about a simple attack from an enemy.
   *
   * @param src The GameUnit that initiates the attack.
   * @param dest The GameUnit that is the target of the attack.
   * @param amount The amount of damage dealt by the enemy's attack.
   */
  def notifySimpleEnemyAttack(src: GameUnit, dest: GameUnit, amount: Int): Unit = {
    view.displaySimpleEnemyAttack(src, dest, amount)
  }

}


