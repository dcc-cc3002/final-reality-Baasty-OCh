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
    Cristiano = new Character("Cristiano",0,50,70,"Paladin",false)
    Alexis = new MagicCharacter("Alexis", 0, 55, 65, "Mago Blanco", false, 90)

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
    var state: Boolean = Team1.isDefeated
    assertEquals(state,true)

  }
  test("isDefeat"){
    Team1.addPlayable((Cristiano))
    Team1.addPlayable(Alexis)
    assertEquals(Team1.isDefeated,true)
  }
  test("isNotDefeat"){
    Team1.addPlayable((Cristiano))
    Alexis = new MagicCharacter("Alexis",100,90,10,"Mago Blanco",false,50)
    Team1.addPlayable(Alexis)
    assertEquals(Team1.isDefeated,false)
  }

}
