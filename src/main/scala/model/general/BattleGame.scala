package model.general

import controller.GameController
import view.GameView

/*** Represents the main class to run the battle game. */
class BattleGame {

  /**
   * Starts and runs the battle game. Initializes the game controller with the model and view, and
   * runs the game loop until the game is finished. */
  def run(): Unit = {
    val controller: GameController = new GameController(new GameModel, new GameView)
    while (!controller.hasFinished()) {
      controller.handleInput()
      controller.update()
    }
  }
}
