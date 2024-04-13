import munit.FunSuite
import model.party.Party
import model.playable.{Character,MagicCharacter}
import model.nonplayable.{Enemy,Weapon,MagicWeapon}
class PartyTest extends FunSuite {
  var Team1: Party = _
  var Cristiano: Character = _
  var Alexis: MagicCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new Party()
    Cristiano = new Character("Cristiano",100,50,70,"Paladin",false)
    Alexis = new MagicCharacter("Alexis", 80, 55, 65, "Mago Blanco", false, 90)

  }


}
