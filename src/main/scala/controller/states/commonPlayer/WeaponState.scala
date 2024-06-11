package controller.states.commonPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon
class WeaponState (private val src: GameUnit, private var spell: Option[Spell],val people : TurnSchedule) extends AGameState {
  var choice : Int = 0
  def this(src:GameUnit,t:TurnSchedule) = {
    this(src,None,t)
  }

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
        src.putWeapon(w)
        selected = Some(w)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    choice match {
      case 0 => controller.state = new ActionState (src, people)
      case 1 => controller.state = new TargetState (src, people)
      case 2 => controller.state = new TargetState (src, people)
      case 3 => controller.state = new TargetState (src, people)
    }
  }


}
