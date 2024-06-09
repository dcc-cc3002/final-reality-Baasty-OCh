package controller.observers
import model.general.GameUnit
import model.spell.Spell
import model.view.GameView

class ObserverAttack(private val view: GameView) {

  def notifySimpleAttack(src: GameUnit, dest: GameUnit, dmg: Int) = {
    view.displaySimpleAttack(src, dest, dmg)
  }

  def notifySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell, dmg: Int) = {
    view.displaySpellAttack(src, dest, sp, dmg)
  }

}

