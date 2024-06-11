package controller

import model.general.GameModel
import states.{GameState, InitialPlayerState}
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
import model.view.GameView

class GameController(private val model: GameModel, private val view: GameView) {

  private var _state: GameState = null
  private val ai = new Random()
  private val attackObs = new ArrayBuffer[ObserverAttack].empty
  init()


  private def init(): Unit = {
    notifyInitMessage()
    attackObs += new ObserverAttack(view)
    model.init(this)
    state = new InitialPlayerState()
    //TurnoDe(model._participantes)
  }
  private def checkFinished(): Unit = {
    if (win()) {
      view.displayVictory()
    } else if (lose()) {
      view.displayDefeat()
    }
  }

  def hasFinished(): Boolean = {
    win() || lose()
  }

  def handleInput(): Unit = {
    state.handleInput(this)
  }

  def update(): Unit = {
    state.update(this)
    checkFinished()
    view.render()
  }

  def state: GameState = _state
  def state_=(other: GameState): Unit = {
    _state =  other
    _state.notify(this)
  }

  def getNumericalInput(): Int = {
    view.getNumericalInput()
  }

  def getAlly(choice: Int): GameUnit = {
    val u = model.allies.buff(choice)
    notifyAllyChoose(u)
    u
  }

  def getEnemy(choice: Int): GameUnit = {
    val u = model.enemies.buff(choice)
    u
  }

  def getAIUnit(): GameUnit = {
    var choice = ai.nextInt(model.enemies.buff.length)
    while(model.enemies.buff(choice).getHp == 0) {
      choice = ai.nextInt(model.enemies.buff.length)
    }
    model.enemies.buff(choice)
  }

  def getAIChoice(u: GameUnit): GameState = {
    new TargetEnemyState(u)
  }

  def calcTurns(t:TurnSchedule): GameUnit ={
    while(t.turns.isEmpty){
      t.fillActionBar(30)
    }
    val src: GameUnit = t.turns.head
    t.turns.enqueue(src)
    src
  }
  def TurnoDe(t:TurnSchedule): GameState = {
    val jugador = calcTurns(t)
    val mode = jugador.Juega(jugador)
    if (mode == "playable"){new InitialPlayerState()}
    else new InitialEnemyState()
  }

  def getAITarget(): GameUnit = {
    var choice = ai.nextInt(model.allies.buff.length)
    while(model.allies.buff(choice).getHp == 0) {
      choice = ai.nextInt(model.allies.buff.length)
    }
    model.allies.buff(choice)
  }
/*
  def getAISpell(u: GameUnit): Ability = {
    val spells = u.spells()
    var choice = ai.nextInt(spells.length)
    while(!u.canUse(spells(choice))) {
      choice = ai.nextInt(spells.length)
    }
    spells(choice)
  }
*/
  def registerUnit(gUnit: GameUnit) = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
  }

  def notifyInitMessage() = {
    view.displayInitMessage()
  }

  def notifyPlayerStart() = {
    view.displayPlayerStart()
  }

  def notifyEnemyStart() = {
    view.displayEnemyStart()
  }

  def notifyPlayerUnits() = {
    view.displayPlayerUnits(model.allies)
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

  def notifyPlayerUnitSpells(pUnit: GameUnit) = {
    view.displayPlayerUnitSpells(pUnit.spells())
  }
  def notifyPlayerUnitWeapons(pUnit: GameUnit) = {
    view.displayPlayerUnitWeapons(pUnit.weapons())
  }

  def notifyMagicPlayerUnitWeapons(pUnit: GameUnit) = {
    view.displayMagicPlayerUnitWeapons(pUnit.weapons())
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
    model.allies.isDefeated()
  }

}
