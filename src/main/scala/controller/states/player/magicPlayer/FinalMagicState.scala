package controller.states.player.magicPlayer

import controller.states.{AGameState, TurnState}
import model.general.GameUnit
import model.spell.Spell
import controller.GameController
import model.general.schedule.TurnSchedule
import model.weapons.Weapon

/**
 * Final state representing the end of a magic action for a player unit.
 *
 * @param ally The player unit performing the magic action.
 * @param target The target unit of the magic action.
 * @param spell The spell being used, if any.
 * @param entities The turn schedule containing game entities.
 * @param weapon The weapon being used, if any.
 */
class FinalMagicState(var ally: GameUnit, private val target: GameUnit,
                      var spell: Option[Spell], var entities: TurnSchedule,
                      var weapon: Option[Weapon]) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0

  /**
   * Updates the game state to execute the magic action and transition to the next turn state.
   *
   * @param controller The game controller handling the game logic.
   * @param input Unused input parameter.
   */
  override def update(controller: GameController, input: Int = choice): Unit = {
    if (spell.isDefined) {
      pj.throwSpell(target)
    } else {
      pj.attack(target)
    }
    controller.SetState(new TurnState(people))
  }

  /**
   * Checks if the state represents the final magic action state.
   *
   * @return `true` since this state represents the final magic action state.
   */
  override def isFinalMagicState(): Boolean = true
}
