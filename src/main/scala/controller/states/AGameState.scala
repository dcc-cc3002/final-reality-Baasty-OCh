package controller.states

import controller.GameController
import view.GameView
import scala.collection.mutable.ArrayBuffer

abstract class AGameState extends GameState {
  override def handleInput(controller: GameController): Unit = {}
  override def update(controller: GameController): Unit = {}
  override def notify(controller: GameController): Unit = {}

  // General
  override def isInitialPlayerState(): Boolean = false
  override def isSurrenderState(): Boolean = false
  override def isTurnState(): Boolean = false
  override def isUnitState(): Boolean = false

  // Common
  override def isActionState(): Boolean = false
  override def isFinalState(): Boolean = false
  override def isTargetState(): Boolean = false
  override def isWeaponState(): Boolean = false

  // Magic
  override def isActionMagicState(): Boolean = false
  override def isFinalMagicState(): Boolean = false
  override def isHealingState(): Boolean = false
  override def isSpellState(): Boolean = false
  override def isTargetMagicState(): Boolean = true
  override def isWeaponMagicState(): Boolean = false

  // Enemy

  override def isAccionEnemyState(): Boolean = false
  override def isBurnedState(): Boolean = false
  override def isFinalEnemyState(): Boolean = false
  override def isInitialEnemyState(): Boolean = false
  override def isParalyzedState(): Boolean = false
  override def isPoisonedState(): Boolean = false
  override def isTargetEnemyState(): Boolean = false
  override def isUnitEnemyState(): Boolean = false



}

