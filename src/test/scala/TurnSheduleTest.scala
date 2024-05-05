import munit.FunSuite
import model.party.Party
import model.playable.{Guerrero, MagoBlanco, MagoNegro, Ninja, Paladin, Playable}
import model.controller.{Shedule, TurnShedule}
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, Staff, Sword, Wand}

import scala.collection.mutable
class TurnSheduleTest extends FunSuite {
  var Team1: TurnShedule = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable
  var Messi: Playable = _ // We declare a variable Messi of type Playable

  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new TurnShedule() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Paladin("Cristiano",0,50,50,0,Some( new Sword()))
    // Creates a new instance of the MagicCharacter class with the specified parameters:
    Alexis = new MagoBlanco("Alexis")// - Kind: Mago Blanco // - Weapon: false
    Messi = new Guerrero("Messi") //
  }
  test("addPlayer"){
    Team1.addPlayer(Cristiano)
    val expected: Map[Playable, (50,0)] = Map(Cristiano -> (50,0))
    assertEquals(Team1.actionBar.toMap,expected)
  }
  test("isEmpty"){
    assertEquals(Team1.actionBar.isEmpty,true)
  }
  test("deletePlayer"){
    Team1.addPlayer(Cristiano)
    Team1.deletePlayer(Cristiano)
    assertEquals(Team1.actionBar.isEmpty,true)
  }
  test("fillActionBar"){
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(12)
    val expected: Map[Playable, (Int,Int)] = Map(Cristiano -> (50,12), Alexis -> (60,12))
    assertEquals(Team1.actionBar.toMap,expected)
  }
  test("resetActionBar"){
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(12)
    Team1.resetActionBar(Cristiano)
    val expected: Map[Playable, (Int,Int)] = Map(Cristiano -> (50,0), Alexis -> (60,12))
    assertEquals(Team1.actionBar.toMap,expected)
  }
  test("Turns"){
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(55)
    Team1.fillActionBar(20)
    val expected: mutable.Queue[Playable] = mutable.Queue(Cristiano,Alexis)
    assertEquals(Team1.turns,expected)
  }



}
