package controllerTest

import controller.GameController
import model.general.GameModel
import munit.FunSuite
import view.GameView

class GameControllerTest extends FunSuite{
  val gameModel: GameModel = new GameModel()
  val gameView: GameView = new GameView()
  val gameController: GameController = new GameController(gameModel, gameView)
//xd no sirve testar asi
  test("hasFinished"){
    assertEquals(gameController.hasFinished(),false)
  }


}
