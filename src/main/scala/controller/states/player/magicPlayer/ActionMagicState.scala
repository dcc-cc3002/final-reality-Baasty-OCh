package controller.states.player.magicPlayer

import controller.GameController
import controller.states.player.commonPlayer.{TargetState, WeaponState}
import controller.states.player.{SurrenderState, UnitState}
import controller.states.{AGameState, GameState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class ActionMagicState(var ally: GameUnit, var entities : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0

  override def isActionMagicState(): Boolean = true
  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
  }

  override def update(controller: GameController, input: Int = choice): Unit = {
    if (pj.arma.isDefined || pj.spell.isDefined){ // has Weapon or Spell
      input match {
        case 0 => controller.SetState(new SurrenderState(pj,people))
        case 1 => controller.SetState(new TargetMagicState(pj,people, pj.arma))
        case 2 => controller.SetState(new SpellState(pj,people))
        case 3 => controller.SetState(new WeaponMagicState(pj,people))
        case 4 => controller.SetState(new SpellState(pj,people))
      }
    } else {
      input match {
        case 0 => controller.SetState(new SurrenderState(pj,people))
        case 1 => controller.SetState(new WeaponMagicState(pj,people))
        case 2 => controller.SetState(new SpellState(pj,people))
        case 3 => controller.SetState(new WeaponMagicState(pj,people))
        case 4 => controller.SetState(new SpellState(pj,people))
        case _ => controller.notifyErrorInvalidOption(choice)
      }
    }
  }
}
