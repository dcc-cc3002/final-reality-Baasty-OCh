package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.magicPlayer.{TargetMagicState, WeaponMagicState}
import model.general.{GameModel, GameUnit}
import model.spell.light.Healing
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
import view.GameView

class TargetMagicStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: TargetMagicState = _ // by default TurnState

  override def beforeEach(context: BeforeEach): Unit = {
    testState = new TargetMagicState(gameController.getAlly(2),None,gameModel.participants,Some(new Staff()))
    val enemy: GameUnit = gameController.getEnemy(1)
    testState.selected = Some(enemy)
    enemy.setHp(50)
  }
  test("update to TargetMagicState, if chosen a dead enemy"){
    val DeadEnemy = gameController.getEnemy(1)
    DeadEnemy.setHp(0)
    testState.update(gameController,1)
    assertEquals(gameController.state.isTargetMagicState(),true)
  }
  test("update to WeaponMagicState"){

    testState.update(gameController,0)
    assertEquals(gameController.state.isWeaponMagicState(),true)
  }
  test("update to FinalMagicState"){
    testState.update(gameController,1)
    assertEquals(gameController.state.isFinalMagicState(),true)
  }
  test("update to FinalMagicState"){
    testState.update(gameController,2)
    assertEquals(gameController.state.isFinalMagicState(),true)
  }
  test("update to FinalMagicState"){
    testState.update(gameController,3)
    assertEquals(gameController.state.isFinalMagicState(),true)
  }
  test("update to SpellState"){
    testState.update(gameController,4)
    assertEquals(gameController.state.isSpellState(),true)
  }



}
