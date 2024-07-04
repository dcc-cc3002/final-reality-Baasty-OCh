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
  //src.dropWeapon()

  def this(src: GameUnit, t: TurnSchedule) = {
    this(src, None, t)
  }

  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyMagicPlayerUnitWeapons(src)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0 || choice == 6) {
        val w = controller.getWeapon(choice)
        src.putWeapon(w)
        selected = Some(w)
      } else {
        val w = controller.getWeapon(choice - 1)
          src.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(src)
          people.addPlayer(src)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController): Unit = {
    if (src.arma.isEmpty) {
      controller.SetState(new WeaponMagicState(src, spell, people))
    }
    else if( spell.isDefined && spell.get.getName == "Healing"){
      choice match{
        case 0 => controller.SetState(new ActionMagicState(src, people))
        case 1 => controller.SetState(new WeaponMagicState(src, spell, people))
        case 2 => controller.SetState(new WeaponMagicState(src, spell, people))
        case 3 => controller.SetState(new WeaponMagicState(src, spell, people))
        case 4 => controller.SetState(new HealingState(src, spell, people, selected))
        case 5 => controller.SetState(new HealingState(src, spell, people, selected))
      }
    }
    else {
      choice match {
        case 0 => controller.SetState(new ActionMagicState(src, people))
        case 1 => controller.SetState(new TargetMagicState(src, spell, people, selected))
        case 2 => controller.SetState(new TargetMagicState(src, spell, people, selected))
        case 3 => controller.SetState(new WeaponMagicState(src, spell, people))
        case 4 => controller.SetState(new TargetMagicState(src, spell, people, selected))
        case 5 => controller.SetState(new TargetMagicState(src, spell, people, selected))
        //case 6 => controller.state = new SpellState(src,people)
        case 7 => controller.SetState(new WeaponMagicState(src, people))
      }
    }
  }

}