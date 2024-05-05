import munit.FunSuite
import model.party.Party
import model.playable.{Playable,Paladin,Guerrero,Ninja,MagoBlanco,MagoNegro}
import model.controller.{Shedule,TurnShedule}
import model.nonplayable.{Enemy, AWeapon, Sword, Axe, Bow, Staff, Wand}
class TurnSheduleTest extends FunSuite {
  var Team1: TurnShedule = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable
  var Messi: Playable = _ // We declare a variable Messi of type Playable

  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new TurnShedule() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Paladin("Cristiano",0,50,50,0,false)
    // Creates a new instance of the MagicCharacter class with the specified parameters:
    Alexis = new MagoBlanco("Alexis")// - Kind: Mago Blanco // - Weapon: false
    Messi = new Guerrero("Messi") //
  }

}
