package nonplayable

import model.nonplayable.Enemy
import munit.FunSuite
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _ // We declare a variable Neymar of type Enemy
  // We declare a variable Bale of type Enemy


  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Enemy class with the specified parameters:
    Neymar = new Enemy("Neymar") // -Name : Neymar // - Weight: 60 // - Attack: 90 // - Life: 70 // - Defence: 30
    // Creates a new instance of the Enemy class with the specified parameters:
    // -Name : Bale // - Weight: 70 // - Attack: 85 // - Life: 75 // - Defence: 50

  }
}


