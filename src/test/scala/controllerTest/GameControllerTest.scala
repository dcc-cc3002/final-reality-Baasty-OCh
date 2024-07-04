package controllerTest

import controller.GameController
import controller.states.{InitialPlayerState, TurnState}
import model.general.GameModel
import munit.FunSuite
import view.GameView

class GameControllerTest extends FunSuite{
  val gameModel: GameModel = new GameModel()
  val gameView: GameView = new GameView()
  val gameController: GameController = new GameController(gameModel, gameView)

  test("hasFinished"){
    assertEquals(gameController.hasFinished(),false)
  }
  test("Default state is TurnsState"){
    assertEquals(gameController.state.isTurnState(),true)
  }
  test("SetState"){
    val pj = gameController.state.calcTurns(gameModel.participants)
    gameController.SetState(new InitialPlayerState(gameModel.participants,pj))
    val newState = gameController.state
    assertEquals(newState.isInitialPlayerState(),true)
  }
  test("getEnemy"){
    println(gameController.getEnemy(0))
    println(gameController.getEnemy(1))
    println(gameController.getEnemy(2))
  }



}
