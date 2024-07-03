package controller.states

import controller.GameController
import view.GameView

trait GameState {
  def notify(controller: GameController): Unit
  def handleInput(controller: GameController): Unit
  def update(controller: GameController): Unit

  // General
  def isInitialPlayerState(): Boolean
  def isSurrenderState(): Boolean
  def isTurnState(): Boolean
  def isUnitState(): Boolean

  // Common
  def isActionState(): Boolean
  def isFinalState(): Boolean
  def isTargetState(): Boolean
  def isWeaponState(): Boolean

  // Magic
  def isActionMagicState(): Boolean
  def isFinalMagicState(): Boolean
  def isHealingState(): Boolean
  def isSpellState(): Boolean
  def isTargetMagicState(): Boolean
  def isWeaponMagicState(): Boolean

  // Enemy

  def isAccionEnemyState(): Boolean
  def isBurnedState(): Boolean
  def isFinalEnemyState(): Boolean
  def isInitialEnemyState(): Boolean
  def isParalyzedState(): Boolean
  def isPoisonedState(): Boolean
  def isTargetEnemyState(): Boolean
  def isUnitEnemyState(): Boolean

}   
