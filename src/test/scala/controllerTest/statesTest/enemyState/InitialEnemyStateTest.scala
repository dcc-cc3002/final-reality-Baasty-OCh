package controllerTest.statesTest.enemyState

import controller.GameController
import controller.states.GameState
import controller.states.enemy.InitialEnemyState
import controller.states.player.magicPlayer.FinalMagicState
import model.general.GameModel
import model.spell.dark.Fire
import model.weapons.magic.Staff
import munit.FunSuite
import view.GameView

class InitialEnemyStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: GameState = _ // by default TurnState
  var testState2: GameState = _
  override def beforeEach(context: BeforeEach): Unit = {
    testState = new InitialEnemyState(gameModel.participants,gameController.getEnemy(1))
  }
  test("update to TargetEnemyState"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isTargetEnemyState(),true)
  }
  test("update to ParalysisState") {
    testState.pj.setStatus("Paralyzed")
    testState.update(gameController, 0)
    assertEquals(gameController.state.isParalyzedState(), true)
  }
  test("update to PoisonedState"){
    testState.pj.setStatus("Poisoned with Staff")
    testState.update(gameController, 0)
    assertEquals(gameController.state.isPoisonedState(), true)
  }
  test("update to PoisonedState"){
    testState.pj.setStatus("Poisoned with Wand")
    testState.update(gameController, 0)
    assertEquals(gameController.state.isPoisonedState(), true)
  }
  test("update to BurnedState"){
    testState.pj.setStatus("Burned with Staff")
    testState.update(gameController, 0)
    assertEquals(gameController.state.isBurnedState(), true)
  }
  test("update to PoisonedState"){
    testState.pj.setStatus("Burned with Wand")
    testState.update(gameController, 0)
    assertEquals(gameController.state.isBurnedState(), true)
  }
}
