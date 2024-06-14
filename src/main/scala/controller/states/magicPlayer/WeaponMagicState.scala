package controller.states.magicPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import controller.states.commonPlayer.WeaponState
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon
class WeaponMagicState(private val src: GameUnit, private var spell: Option[Spell], val people : TurnSchedule) extends AGameState {
  var choice: Int = 0
  src.dropWeapon()
  def this(src:GameUnit, t : TurnSchedule) = {
    this(src,None, t)
  }

  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyMagicPlayerUnitWeapons(src)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0 || choice == 6){
        val w = src.weapons()(choice)
        src.putWeapon(w)
        selected = Some(w)
      } else {
        val w = src.weapons()(choice - 1)
        if (w.getOwner().isEmpty){
          src.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(src)
          people.addPlayer(src)
        } else choice = 7
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (src.arma.isEmpty) {
      controller.state = new WeaponState(src,people)
    }
    else {
      choice match{
        case 0 => controller.state = new ActionMagicState(src,people)
        case 1 => controller.state = new TargetMagicState(src,spell, people)
        case 2 => controller.state = new TargetMagicState(src,spell, people)
        case 3 => controller.state = new WeaponMagicState(src,spell, people)
        case 4 => controller.state = new TargetMagicState(src,spell, people)
        case 5 => controller.state = new TargetMagicState(src,spell, people)
        case 6 => controller.state = new SpellState(src,people)
        case 7 => controller.state = new WeaponState(src, people)
      }
    }
  }
}
