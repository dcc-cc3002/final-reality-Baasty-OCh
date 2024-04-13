import munit.FunSuite
import model.party.Party
import model.playable.{Character,MagicCharacter,Playable}
import model.nonplayable.{Enemy,Weapon,MagicWeapon}
class PartyTest extends FunSuite {
  var Team1: Party = _
  var Cristiano: Playable = _
  var Alexis: MagicCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party()
    Cristiano = new Character("Cristiano",100,50,70,"Paladin",false)
    Alexis = new MagicCharacter("Alexis", 80, 55, 65, "Mago Blanco", false, 90)

  }
  test("addCharacter") {
    Team1.addPlayable(Cristiano)
    val expected: Map[String, Playable] = Map("Paladin" -> Cristiano)
    assertEquals(Team1.allies.toMap, expected)
  }
  test("addMagicCharacter") {
    Team1.addPlayable(Alexis)
    val expected: Map[String, Playable] = Map("Mago Blanco" -> Alexis)
    assertEquals(Team1.allies.toMap, expected)
  }
  test("isEmpty"){
    val expected: Boolean = true
    var state: Boolean = Team1.isDefeated
    assertEquals(state,expected)

  }

}
