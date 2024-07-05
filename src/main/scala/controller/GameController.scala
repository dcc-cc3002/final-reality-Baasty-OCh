package controller

import model.general.GameModel
import states.{GameState, InitialPlayerState, SurrenderState, TurnState}
import observers._
import model.general.GameUnit
import model.nonplayable.Enemy
import model.playable.common.{Ninja, Paladin, Warrior}
import model.playable.magic.{BlackMagican, WhiteMagican}
import model.spell.Spell

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import controller.states.enemy.{InitialEnemyState, TargetEnemyState}
import model.general.schedule.TurnSchedule
import model.weapons.Weapon
import view.GameView

class GameController(private val model: GameModel, private val view: GameView) {

  private var _state: GameState = null
  private val ai = new Random()
  private val attackObs = new ArrayBuffer[ObserverAttack].empty
  private var _WhiteFlag = false
  def WhiteFlag(): Boolean = _WhiteFlag

  init()


  private def init(): Unit = {
    notifyInitMessage()
    attackObs += new ObserverAttack(view)
    model.init(this)
    val start: GameState = new TurnState(model.participants)
    this.SetState(start)
    //TurnoDe(model._participantes)
  }
  private def checkFinished(): Unit = {
    if (win()) {
      view.displayVictory()
    } else if (lose()) {
      view.displayPlayerUnits(model.allies)
      view.displayDefeat()
    }
  }

  def hasFinished(): Boolean = {
    win() || (lose())
  }

  def handleInput(): Unit = {
    state.handleInput(this)
  }

  def update(): Unit = {
    state.update(this,this.state.choice)
    checkFinished()
    view.render()
  }

  def state: GameState = _state
  def SetState(other: GameState): Unit = {
    _state =  other
    _state.notify(this)
  }

  def getNumericalInput(): Int = {
    view.getNumericalInput()
  }

  def getEnemy(choice: Int): GameUnit = {
    val u = model.enemies.buff(choice)
    u
  }
  def getWeapon(choice: Int): Weapon = {
    val w = model._weapons(choice)
    w
  }

  def getAlly(choice: Int): GameUnit ={
    val u = model.allies.buff(choice)
    u
  }


  def TurnoDe(x: GameUnit): Int = {
    val mode = x.Style(x)
    if (mode == "playable" || mode == "magicPlayable"){2}
    else 1
  }

  def getAITarget(): GameUnit = {
    var choice = ai.nextInt(model.allies.buff.length)
    while(model.allies.buff(choice).getHp == 0) {
      choice = ai.nextInt(model.allies.buff.length)
    }
    model.allies.buff(choice)
  }

  def registerAllyUnit(gUnit: GameUnit) = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
    model.participants.addPlayer(gUnit)
    model.allies.addGameUnit(gUnit)
  }


  def registerEnemyUnit(gUnit: GameUnit) = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
    model.participants.addPlayer(gUnit)
    model.enemies.addGameUnit(gUnit)
  }


  def registerWeapon(wUnit: Weapon) = {
    for (o <- attackObs) {
      wUnit.registerAttackObserver(o)
    }
    model.addWeapon(Some(wUnit))
  }

  def notifyInitMessage() = {
    view.displayInitMessage()
  }

  def notifyReportMessage() = {
    view.displayReportMessage(model.allies,model.enemies)
  }


  def notifyMagicReportMessage() = {
    view.displayMagicReportMessage(model.allies,model.enemies)
  }

  def notifyPlayerStart(pj:GameUnit) = {
    view.displayPlayerStart(pj)
  }

  def notifyEnemyStart(pj:GameUnit) = {
    view.displayEnemyStart(pj)
  }

  def notifyPlayerUnits() = {
    view.displayPlayerUnits(model.allies)
  }

  def notifySurrenderMessage(coward: GameUnit) = {
    view.displaySurrender(coward)
  }

  def notifyInvalidWeapon(): Unit ={
    view.displayInvalidWeaponMessage()
  }

  def notifyInvalidTarget(): Unit = {
    view.displayInvalidTargetMessage()
  }
  def notifyInvalidSpell(): Unit = {
    view.displayInvalidSpellMessage()
  }

  def notifyMagicPlayerAction() = {
    view.displayMagicPlayerAction()
  }

  def notifyPlayerAction(): Unit = {
    view.displayPlayerAction()
  }

  def notifyPlayerTarget() = {
    view.displayPlayerTarget(model.enemies)
  }
  def notifyMagicPlayerTarget() = {
    view.displayMagicPlayerTarget(model.enemies)
  }
  def notifyEnemyStatus(pUnit:GameUnit) = {
    view.displayEnemyStatus(pUnit)
  }
  def notifyHealingTarget() = {
    view.displayHealingTarget(model.allies)
  }

  def notifyPlayerUnitSpells(pUnit: GameUnit) = {
    view.displayPlayerUnitSpells(pUnit.spells())
  }
  def notifyPlayerUnitWeapons(pUnit: GameUnit) = {
    view.displayPlayerUnitWeapons(pUnit.weapons())
  }

  def notifyMagicPlayerUnitWeapons(pUnit: GameUnit) = {
    view.displayMagicPlayerUnitWeapons(pUnit.weapons())
  }

  def notifyError(s: String) = {
    view.displayNotifyError(s)
  }




  def notifyAllyChoose(pUnit: GameUnit) = {
    view.displayUnitInfo(pUnit)
  }

  def notifyErrorNoEnergy() = {
    view.displayErrorNoEnergy()
  }

  def notifyErrorInvalidOption(choice: Int) = {
    view.displayErrorInvalidOption(choice)
  }


  def win(): Boolean = {
    model.enemies.isDefeated()
  }

  def lose(): Boolean = {
    (model.allies.isDefeated())
  }

  def PutWhiteFlag(): Unit = {
    model.allies.setAllHpToZero()
    _WhiteFlag = true
  }
}
