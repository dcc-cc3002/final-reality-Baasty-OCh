package nonplayable

import model.nonplayable.{Enemy, NonPlayable}
import model.playable.Playable
import model.playable.common.Paladin
import munit.FunSuite
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _ // We declare a variable Neymar of type Enemy
  var Bale : Enemy = _  // We declare a variable Bale of type Enemy
  var Cristiano: Playable = _

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Enemy class with the specified parameters:
    Neymar = new Enemy("Neymar") // -Name : Neymar // - Weight: 60 // - Attack: 90 // - Life: 70 // - Defence: 30
    Bale = new Enemy("Bale",40,76,32,89) // Creates a new instance of the Enemy class with the specified parameters:
    // -Name : Bale // - Weight: 70 // - Attack: 85 // - Life: 75 // - Defence: 50
    Cristiano= new Paladin("Cristiano")
  }

  test("equals") {
    assertEquals(Neymar.equals(Neymar),true)
    assertEquals(Neymar.equals(Bale),false)
    assertEquals(Neymar.equals(Cristiano),false)
  }

  test("setName") {
    assertEquals(Neymar.getName, "Neymar")
  }

  test("setWeight") {
    assertEquals(Neymar.getWeight, 50)
  }

  test("setAttack") {
    assertEquals(Neymar.getAttack, 80) // Compare the actual weight value with the expected value
  }

  test("setDefencePoints"){
    assertEquals(Neymar.getDF,50)
  }

  test("attack"){
    val Ronaldo: Playable = new Paladin("Ronaldo",100,200,50)
    val daño2: Int = Neymar.attackPlayer(Ronaldo)

    assertEquals(Neymar.attackPlayer(Cristiano),5)
    assertEquals(daño2,0)
  }
  test("wasInjure"){
    Neymar.wasInjure(25)
    assertEquals(Neymar.getLife,225)
    Neymar.wasInjure(300)
    assertEquals(Neymar.getLife,0)
  }

}


