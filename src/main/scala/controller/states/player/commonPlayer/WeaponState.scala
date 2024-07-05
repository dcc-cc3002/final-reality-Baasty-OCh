package controller.states.player.commonPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon


////REGISTRO DE ARMAS ESTILO ENEMIES, ESO VA SOLUCIONAR TODO
class WeaponState (var ally: GameUnit, var entities: TurnSchedule) extends AGameState {
  var pj: GameUnit = ally
  var people: TurnSchedule = entities
  var choice : Int = 0
  pj.dropWeapon()
  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitWeapons(pj)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0){
        val w = controller.getWeapon(choice)
        pj.putWeapon(w)
        selected = Some(w)
      }
      else{
        val w = controller.getWeapon(choice-1)
        if (w.getOwner().isEmpty){
          pj.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(pj)
          people.addPlayer(pj)
        } else pj.dropWeapon()
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    if (pj.arma.isEmpty){
      controller.SetState(new WeaponState(pj,people))
      controller.notifyInvalidWeapon()
    }
    else {
      input match {
        case 0 => controller.SetState(new ActionState (pj, people)) // eliminar este caso , sera facil cuando corra la vista
        case 1 => controller.SetState(new TargetState (pj, people))
        case 2 => controller.SetState(new TargetState (pj, people))
        case 3 => controller.SetState(new TargetState (pj, people))
        case 4 => controller.SetState(new WeaponState (pj, people))
        case 5 => controller.SetState(new WeaponState (pj, people))
        case 6 => controller.SetState(new WeaponState (pj, people))
      }
    }
  }


}
