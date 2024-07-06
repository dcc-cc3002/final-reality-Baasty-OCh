package controller.states.player.magicPlayer

import controller.states.AGameState
import model.general.GameUnit
import controller.GameController
import controller.states.player.commonPlayer.WeaponState
import model.general.schedule.TurnSchedule
import model.spell.Spell
import model.weapons.Weapon
class WeaponMagicState(var ally: GameUnit, private var spell: Option[Spell], var entities : TurnSchedule) extends AGameState {
  var pj : GameUnit = ally
  var people: TurnSchedule = entities
  var choice: Int = 0
  //src.dropWeapon()

  def this(ally: GameUnit, entities: TurnSchedule) = {
    this(ally, None, entities)
  }

  private var selected: Option[Weapon] = None

  override def notify(controller: GameController) = {
    controller.notifyMagicPlayerUnitWeapons(pj)
  }

  override def handleInput(controller: GameController): Unit = {
    choice = controller.getNumericalInput()
    try {
      if (choice == 0 || choice == 6) {
        val w = controller.getWeapon(choice)
        pj.putWeapon(w)
        selected = Some(w)
      } else {
        val w = controller.getWeapon(choice - 1)
          pj.putWeapon(w)
          selected = Some(w)
          people.deletePlayer(pj)
          people.addPlayer(pj)
      }
    }
    catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }

  override def update(controller: GameController, input:Int = choice): Unit = {
    if (pj.arma.isEmpty) {
      controller.SetState(new WeaponMagicState(pj, spell, people))
      controller.notifyInvalidWeapon()
    }
    else if( spell.isDefined && spell.get.getName == "Healing"){
      input match{
        case 0 => controller.SetState(new ActionMagicState(pj, people)) // sacar con vista
        case 1 => controller.SetState(new WeaponMagicState(pj, spell, people)) //
        case 2 => controller.SetState(new WeaponMagicState(pj, spell, people)) // quizas estos 3 casos se puedan sacar
        case 3 => controller.SetState(new WeaponMagicState(pj, spell, people)) //
        case 4 => controller.SetState(new HealingState(pj, spell, people, selected))
        case 5 => controller.SetState(new HealingState(pj, spell, people, selected))
      }
    }
    else {
      input match {
        case 0 => controller.SetState(new ActionMagicState(pj, people)) // sacar con vista
        case 1 => controller.SetState(new TargetMagicState(pj, spell, people, selected)) // revisar test
        case 2 => controller.SetState(new TargetMagicState(pj, spell, people, selected))
        case 3 => controller.SetState(new WeaponMagicState(pj, spell, people))
        case 4 => controller.SetState(new TargetMagicState(pj, spell, people, selected))
        case 5 => controller.SetState(new TargetMagicState(pj, spell, people, selected))
        //case 6 => controller.state = new SpellState(pj,people)
        case 7 => controller.SetState(new WeaponMagicState(pj, people)) // que hace?
      }
    }
  }

  override def isWeaponMagicState(): Boolean = true

}