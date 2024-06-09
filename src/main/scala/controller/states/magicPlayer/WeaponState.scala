package controller.states.magicPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import model.weapons.Weapon
class WeaponState (private val src: GameUnit) extends AGameState {
  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyPlayerUnitWeapons(src)
  }

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      val w = src.weapons()(choice-1)
      src.putWeapon(w)
      selected = Some(w)
    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(src)
  }
}
