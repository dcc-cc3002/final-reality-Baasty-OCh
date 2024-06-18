package controller.states.magicPlayer

import controller.GameController
import controller.states.commonPlayer.{TargetState, WeaponState}
import controller.states.{AGameState, GameState, SurrenderState, UnitState}
import model.general.GameUnit
import model.general.schedule.TurnSchedule

class ActionMagicState(private val ally: GameUnit, val people : TurnSchedule) extends AGameState {
  private var selected: Option[GameState] = None

  override def notify(controller: GameController): Unit = {
    controller.notifyMagicPlayerAction()
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    if (ally.arma.isDefined || ally.spell.isDefined){ // tiene arma?
      choice match {
        case 0 => selected = Some(new SurrenderState())
        case 1 => selected = Some(new TargetMagicState(ally,people, ally.arma))
        case 2 => selected = Some(new SpellState(ally,people))
        case 3 => selected = Some(new WeaponMagicState(ally,people))
        case 4 => selected = Some(new SpellState(ally,people))
      }
    } else {
      choice match {
        case 0 => selected = Some(new SurrenderState())
        case 1 => selected = Some(new WeaponMagicState(ally,people))
        case 2 => selected = Some(new SpellState(ally,people))
        case 3 => selected = Some(new WeaponMagicState(ally,people))
        case 4 => selected = Some(new SpellState(ally,people))
        case _ => controller.notifyErrorInvalidOption(choice)
      }
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = selected.get
  }
}
