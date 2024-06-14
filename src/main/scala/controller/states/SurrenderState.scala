package controller.states

import controller.GameController
import exceptions.InvalidSurrenderException
import exceptions.weapons.InvalidPutWeaponException
import model.general.GameUnit

class SurrenderState() extends AGameState {
  var abandono: Boolean = false

  override def notify(controller: GameController): Unit = {
    controller.notifySurrenderMessage()
  }
  override def update(controller: GameController): Unit = {
    controller.abandonaste()
    throw new InvalidSurrenderException
  }

}
