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
    assertEquals(Neymar.getDp,50)
  }

  test("attack"){

  }
  test("wasInjure"){
    Neymar.wasAttacked(25)
    assertEquals(Neymar.getLife,225)
    Neymar.wasAttacked(300)
    assertEquals(Neymar.getLife,0)
  }

}


