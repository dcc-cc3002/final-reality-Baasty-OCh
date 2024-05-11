package nonplayable

import model.nonplayable.{Enemy, NonPlayable}
import model.playable.{Paladin, Playable}
import munit.FunSuite
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _ // We declare a variable Neymar of type Enemy
  var Bale : Enemy = _  // We declare a variable Bale of type Enemy
  var Cristiano: Playable = _

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Enemy class with the specified parameters:
    Neymar = new Enemy("Neymar") // -Name : Neymar // - Weight: 60 // - Attack: 90 // - Life: 70 // - Defence: 30
    Bale = new Enemy(("Bale")) // Creates a new instance of the Enemy class with the specified parameters:
    // -Name : Bale // - Weight: 70 // - Attack: 85 // - Life: 75 // - Defence: 50
    Cristiano= new Paladin("Cristiano")
  }

  test("equals") { // Test if two references to the same character are equal
    assertEquals(Neymar, Neymar)
  }

  test("setName") { // Test if the returned name value for a character matches the expected value
    var name = Neymar.getName
    assertEquals(name, "Neymar") // Compare the actual name value with the expected value
  }

  test("setWeight") { // Test if the returned weight value for a sword matches the expected value
    var weight = Neymar.getWeight // Retrieve the weight value of the sword and store it in the 'weight' variable
    assertEquals(weight, 50) // Compare the actual weight value with the expected value
  }

  test("setAttack") { // Test if the returned weight value for a sword matches the expected value
    var attack = Neymar.getAttack // Retrieve the weight value of the sword and store it in the 'weight' variable
    assertEquals(attack, 80) // Compare the actual weight value with the expected value
  }

  test("setDefencePoints"){
    assertEquals(Neymar.getDF,50)
  }

  test("attack"){
    val daño: Int = Neymar.attackPlayer(Cristiano)
    val expected: Int = 80 - 75
    val Ronaldo: Playable = new Paladin("Ronaldo",100,200,50,0)
    val daño2: Int = Neymar.attackPlayer(Ronaldo)
    assertEquals(daño,expected)
    assertEquals(daño2,0)
  }
  test("wasInjure"){
    assertEquals(Neymar.wasInjure(25).getLife,225)
    assertEquals(Neymar.wasInjure(300).getLife,0)
  }

}


