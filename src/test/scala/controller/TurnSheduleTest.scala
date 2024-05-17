package controller

import model.controller.TurnSchedule
import model.nonplayable.weapons.{Bow,Sword,Axe,Staff,Wand}
import model.playable.common.{Paladin, Warrior}
import model.playable.magic.WhiteMagican
import model.playable.Playable
import munit.FunSuite

import scala.collection.mutable
class TurnSheduleTest extends FunSuite {
  var Team1: TurnSchedule = _ // We declare a variable Team1 of type Party
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Playable
  var Alexis: Playable = _ // We declare a variable Alexis of type Playable
  var Messi: Playable = _ // We declare a variable Messi of type Playable

  override def beforeEach(context: BeforeEach): Unit = {
    Team1 = new TurnSchedule() // Creates a new instance of the Party class and assigns it to the variable Team1.
    // Creates a new instance of the Character class with the specified parameters:
    Cristiano = new Paladin("Cristiano",0,50,50)
    // Creates a new instance of the MagicCharacter class with the specified parameters:
    Alexis = new WhiteMagican("Alexis")// - Kind: Mago Blanco // - Weapon: false
    Messi = new Warrior("Messi") //
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

    assertEquals(Team1.actionBar.isEmpty,false)

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
  test("canPlay"){
    Team1.addPlayer(Cristiano)
    Team1.addPlayer(Alexis)
    Team1.fillActionBar(55)
    Team1.fillActionBar(20)
    val expected: Playable = Team1.CanPlay(Team1.turns)
    val expected2: Playable = Team1.CanPlay(Team1.turns)

    assertEquals(Cristiano,expected)
    assertEquals(Alexis,expected2)
  }



}
