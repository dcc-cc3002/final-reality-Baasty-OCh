import model.general.BattleGame

/**The main object to run the battle game. */
object Main {

  /**
   * The main method to start the battle game.
   * @param args The command-line arguments (not used in this application). */
  def main(args: Array[String]): Unit = {
    val game = new BattleGame()
    game.run()
  }

}
