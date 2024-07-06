package controllerTest.statesTest.playerTest.magicPlayerState

import controller.GameController
import controller.states.GameState
import controller.states.player.magicPlayer.{HealingState, WeaponMagicState}
import model.general.{GameModel, GameUnit}
import model.spell.light.Healing
import model.weapons.magic.{Staff, Wand}
import munit.FunSuite
import view.GameView

class HealingStateTest extends FunSuite{
  /** Instance of GameModel used for testing. */
  val gameModel: GameModel = new GameModel()

  /** Instance of GameView used for testing. */
  val gameView: GameView = new GameView()

  /** Instance of GameController used for testing. */
  val gameController: GameController = new GameController(gameModel, gameView)
  /**
   * An instance of a subclass of AGameState used for testing.
   */
  var testState: HealingState = _ // by default TurnState

  override def beforeEach(context: BeforeEach): Unit = {
    testState = new HealingState(gameController.getAlly(1),Some(new Healing()),gameModel.participants,Some(new Staff()))
  }
  test("update to HealingState, if selected ally was dead"){
    var ally: GameUnit = gameController.getAlly(2)
    ally.setHp(0)
    testState.selected = Some(ally)
    testState.update(gameController,2)
    assertEquals(gameController.state.isHealingState(),true)
  }
  test("update to TurnState, after apply Effect"){
    var ally: GameUnit = gameController.getAlly(0)
    testState.selected = Some(ally)
    testState.update(gameController,1)
    assertEquals(gameController.state.isTurnState(),true)
  }

  test("update to TurnState, after apply Effect"){
    var ally: GameUnit = gameController.getAlly(1)
    testState.selected = Some(ally)
    testState.update(gameController,2)
    assertEquals(gameController.state.isTurnState(),true)
  }

/*  test("update to TurnState, after apply Effect"){
    var ally: GameUnit = gameController.getAlly(2)
    testState.selected = Some(ally)
    testState.update(gameController,3)
    println(gameController.state)
    assertEquals(gameController.state.isTurnState(),true)
  }*/
}
