package generalTest

import model.general.BattleGame
import munit.FunSuite

class BattleGameTest extends FunSuite{
  val BG: BattleGame = new BattleGame
  test("run"){
    BG.run()
  }

}
