package controller.states.commonPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon


////REGISTRO DE ARMAS ESTILO ENEMIES, ESO VA SOLUCIONAR TODO
class WeaponState (private val src: GameUnit,val people : TurnSchedule) extends AGameState {
  var choice : Int = 0


  src.dropWeapon()
  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitWeapons(src)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0){
        val w = src.weapons()(choice)
        src.putWeapon(w)
        selected = Some(w)
      }
      else{
        val w = src.weapons()(choice-1)
        if (w.getOwner().isEmpty){
          src.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(src)
          people.addPlayer(src)
        } else src.dropWeapon()
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (src.arma.isEmpty){
      controller.state = new WeaponState(src,people)
    }
    else {
      choice match {
        case 0 => controller.state = new ActionState (src, people)
        case 1 => controller.state = new TargetState (src, people)
        case 2 => controller.state = new TargetState (src, people)
        case 3 => controller.state = new TargetState (src, people)
        case 4 => controller.state = new WeaponState (src, people)
        case 5 => controller.state = new WeaponState (src, people)
        case 6 => controller.state = new WeaponState (src, people)
      }
    }
  }


}
