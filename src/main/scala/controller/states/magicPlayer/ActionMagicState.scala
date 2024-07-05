package controller.states.magicPlayer

import controller.GameController
import controller.states.commonPlayer.{TargetState, WeaponState}
import controller.states.{AGameState, GameState, SurrenderState, UnitState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class ActionMagicState(var ally: GameUnit, var entities : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0

  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    if (pj.arma.isDefined || pj.spell.isDefined){ // has Weapon or Spell
      choice match {
        case 0 => selected = Some(new SurrenderState(pj,people))
        case 1 => selected = Some(new TargetMagicState(pj,people, pj.arma))
        case 2 => selected = Some(new SpellState(pj,people))
        case 3 => selected = Some(new WeaponMagicState(pj,people))
        case 4 => selected = Some(new SpellState(pj,people))
      }
    } else {
      choice match {
        case 0 => selected = Some(new SurrenderState(pj,people))
        case 1 => selected = Some(new WeaponMagicState(pj,people))
        case 2 => selected = Some(new SpellState(pj,people))
        case 3 => selected = Some(new WeaponMagicState(pj,people))
        case 4 => selected = Some(new SpellState(pj,people))
        case _ => controller.notifyErrorInvalidOption(choice)
      }
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.SetState(selected.get)
  }
}
