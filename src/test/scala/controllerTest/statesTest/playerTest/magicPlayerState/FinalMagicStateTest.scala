package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.magicPlayer.{ActionMagicState, FinalMagicState}
import model.general.GameModel
import model.spell.dark.Fire
import model.weapons.magic.Staff
import munit.FunSuite
import view.GameView

class FinalMagicStateTest extends FunSuite{
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
    testState = new FinalMagicState(gameController.getAlly(2),gameController.getEnemy(1),
      None,gameModel.participants, None)
    testState.pj.putWeapon(new Staff())
    testState.pj.selectSpell(new Fire())
  }
  test("update to TurnState, after a simple attack"){
    testState.pj.dropSpell()
    testState.update(gameController,0)
    assertEquals(gameController.state.isTurnState(),true)
  }
  test("update to TurnState, after magic attack"){
    testState.update(gameController,0)
    assertEquals(gameController.state.isTurnState(),true)
  }

}
