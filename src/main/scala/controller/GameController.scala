package controller

import model.general.GameModel
import states.{GameState, TurnState}
import observers._
import model.general.GameUnit
import model.weapons.Weapon
import view.GameView

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Controller class that manages game logic and interaction between the model and view.
 *
 * @param model The game model containing game data.
 * @param view The game view responsible for displaying the game state.
 */
class GameController(private val model: GameModel, private val view: GameView) {

  private var _state: GameState = null
  private val ai = new Random()
  private val attackObs = new ArrayBuffer[ObserverAttack].empty
  private var _WhiteFlag = false

  /**
   * Initializes the game controller, sets up observers, and initializes the game state.
   */
  private def init(): Unit = {
    notifyInitMessage()
    attackObs += new ObserverAttack(view)
    model.init(this)
    val start: GameState = new TurnState(model.participants)
    this.SetState(start)
  }

  init()

  /**
   * Retrieves the current state of the white flag.
   *
   * @return `true` if the white flag is raised; otherwise `false`.
   */
  def WhiteFlags(): Boolean = _WhiteFlag


  /**
   * Checks if the game has finished (either the player has won or lost).
   *
   * @return `true` if the game has finished, otherwise `false`.
   */
  def hasFinished(): Boolean = {
    win() || lose()
  }

  /**
   * Checks if the game has finished (either the player has won or lost) and updates the view accordingly.
   */
  private def checkFinished(): Unit = {
    if (win()) {
      view.displayVictory()
    } else if (lose()) {
      view.displayPlayerUnits(model.allies)
      view.displayDefeat()
    }
  }

  /**
   * Retrieves the current game state.
   *
   * @return The current game state.
   */
  def state: GameState = _state


  /**
   * Handles player input based on the current game state.
   */
  def handleInput(): Unit = {
    state.handleInput(this)
  }

  /**
   * Updates the game state, checks if the game has finished, and renders the updated view.
   */
  def update(): Unit = {
    state.update(this, this.state.choice)
    checkFinished()
    view.render()
  }

  /**
   * Sets the current game state.
   *
   * @param other The new game state to set.
   */
  def SetState(other: GameState): Unit = {
    _state = other
    _state.notify(this)
  }

  /**
   * Retrieves numerical input from the view.
   *
   * @return The numerical input received from the view.
   */
  def getNumericalInput(): Int = {
    view.getNumericalInput()
  }

  /**
   * Retrieves an enemy unit based on the player's choice.
   *
   * @param choice The index of the chosen enemy unit.
   * @return The chosen enemy unit.
   */
  def getEnemy(choice: Int): GameUnit = {
    model.enemies.buff(choice)
  }

  /**
   * Retrieves a weapon based on the player's choice.
   *
   * @param choice The index of the chosen weapon.
   * @return The chosen weapon.
   */
  def getWeapon(choice: Int): Weapon = {
    model._weapons(choice)
  }

  /**
   * Retrieves an ally unit based on the player's choice.
   *
   * @param choice The index of the chosen ally unit.
   * @return The chosen ally unit.
   */
  def getAlly(choice: Int): GameUnit = {
    model.allies.buff(choice)
  }

  /**
   * Determines the turn mode of a game unit.
   *
   * @param x The game unit to determine the turn mode for.
   * @return `2` if the unit's style is "playable" or "magicPlayable", otherwise `1`.
   */
  def TurnoDe(x: GameUnit): Int = {
    val mode = x.Style(x)
    if (mode == "playable" || mode == "magicPlayable") 2
    else 1
  }

  /**
   * Retrieves an AI target for the current turn.
   *
   * @return The AI-chosen target game unit.
   */
  def getAITarget(): GameUnit = {
    var choice = ai.nextInt(model.allies.buff.length)
    while (model.allies.buff(choice).getHp == 0) {
      choice = ai.nextInt(model.allies.buff.length)
    }
    model.allies.buff(choice)
  }

  /**
   * Registers an ally unit to the game controller and model.
   *
   * @param gUnit The ally unit to register.
   */
  def registerAllyUnit(gUnit: GameUnit): Unit = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
    model.participants.addPlayer(gUnit)
    model.allies.addGameUnit(gUnit)
  }

  /**
   * Registers an enemy unit to the game controller and model.
   *
   * @param gUnit The enemy unit to register.
   */
  def registerEnemyUnit(gUnit: GameUnit): Unit = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
    model.participants.addPlayer(gUnit)
    model.enemies.addGameUnit(gUnit)
  }

  /**
   * Registers a weapon to the game controller and model.
   *
   * @param wUnit The weapon to register.
   */
  def registerWeapon(wUnit: Weapon): Unit = {
    for (o <- attackObs) {
      wUnit.registerAttackObserver(o)
    }
    model.addWeapon(Some(wUnit))
  }

  /**
   * Notifies the view to display the initial game message.
   */
  def notifyInitMessage(): Unit = {
    view.displayInitMessage()
  }

  /**
   * Notifies the view to display the game report message.
   */
  def notifyReportMessage(): Unit = {
    view.displayReportMessage(model.allies, model.enemies)
  }

  /**
   * Notifies the view to display the magic report message.
   */
  def notifyMagicReportMessage(): Unit = {
    view.displayMagicReportMessage(model.allies, model.enemies)
  }

  /**
   * Notifies the view to display the start message for a player unit.
   *
   * @param pj The player unit to notify about.
   */
  def notifyPlayerStart(pj: GameUnit): Unit = {
    view.displayPlayerStart(pj)
  }

  /**
   * Notifies the view to display the start message for an enemy unit.
   *
   * @param pj The enemy unit to notify about.
   */
  def notifyEnemyStart(pj: GameUnit): Unit = {
    view.displayEnemyStart(pj)
  }

  /**
   * Notifies the view to display the surrender message for a coward unit.
   *
   * @param coward The coward unit to notify about.
   */
  def notifySurrenderMessage(coward: GameUnit): Unit = {
    view.displaySurrender(coward)
  }

  /**
   * Notifies the view to display the message for choosing an invalid weapon.
   */
  def notifyInvalidWeapon(): Unit = {
    view.displayInvalidWeaponMessage()
  }

  /**
   * Notifies the view to display the message for targeting an invalid enemy.
   */
  def notifyInvalidTarget(): Unit = {
    view.displayInvalidTargetMessage()
  }

  /**
   * Notifies the view to display the message for choosing an invalid spell.
   */
  def notifyInvalidSpell(): Unit = {
    view.displayInvalidSpellMessage()
  }

  /**
   * Notifies the view to display the action message for a magic player action.
   */
  def notifyMagicPlayerAction(): Unit = {
    view.displayMagicPlayerAction()
  }

  /**
   * Notifies the view to display the action message for a player action.
   */
  def notifyPlayerAction(): Unit = {
    view.displayPlayerAction()
  }

  /**
   * Notifies the view to display the target selection message for player units targeting enemies.
   */
  def notifyPlayerTarget(): Unit = {
    view.displayPlayerTarget(model.enemies)
  }

  /**
   * Notifies the view to display the target selection message for magic player units targeting enemies.
   */
  def notifyMagicPlayerTarget(): Unit = {
    view.displayMagicPlayerTarget(model.enemies)
  }

  /**
   * Notifies the view to display the status message of an enemy unit.
   *
   * @param pUnit The enemy unit to notify about.
   */
  def notifyEnemyStatus(pUnit: GameUnit): Unit = {
    view.displayEnemyStatus(pUnit)
  }

  /**
   * Notifies the view to display the healing target selection message for player units.
   */
  def notifyHealingTarget(): Unit = {
    view.displayHealingTarget(model.allies)
  }

  /**
   * Notifies the view to display the available spells for a player unit.
   *
   * @param pUnit The player unit to notify about.
   */
  def notifyPlayerUnitSpells(pUnit: GameUnit): Unit = {
    view.displayPlayerUnitSpells(pUnit.spells())
  }

  /**
   * Notifies the view to display the available weapons for a player unit.
   *
   * @param pUnit The player unit to notify about.
   */
  def notifyPlayerUnitWeapons(pUnit: GameUnit): Unit = {
    view.displayPlayerUnitWeapons(pUnit.weapons())
  }

  /**
   * Notifies the view to display the available weapons for a magic player unit.
   *
   * @param pUnit The magic player unit to notify about.
   */
  def notifyMagicPlayerUnitWeapons(pUnit: GameUnit): Unit = {
    view.displayMagicPlayerUnitWeapons(pUnit.weapons())
  }

  /**
   * Notifies the view to display an error message for an invalid option chosen by the player.
   *
   * @param choice The invalid choice made by the player.
   */
  def notifyErrorInvalidOption(choice: Int): Unit = {
    view.displayErrorInvalidOption(choice)
  }
  def notifyNoMana(): Unit = {
    view.displayNoMana()
  }

  /**
   * Checks if the player has won the game.
   *
   * @return `true` if the player has defeated all enemies, otherwise `false`.
   */
  def win(): Boolean = {
    model.enemies.isDefeated()
  }

  /**
   * Checks if the player has lost the game.
   *
   * @return `true` if all player units are defeated, otherwise `false`.
   */
  def lose(): Boolean = {
    model.allies.isDefeated()
  }

  /**
   * Triggers a white flag scenario, setting all player units' HP to zero.
   */
  def PutWhiteFlag(): Unit = {
    model.allies.setAllHpToZero()
    _WhiteFlag = true
  }
}
