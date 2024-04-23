package nonplayable

import model.nonplayable.Enemy
import munit.FunSuite
class EnemyTest extends FunSuite {
  var Neymar: Enemy = _ // We declare a variable Neymar of type Enemy
  var Bale: Enemy = _ // We declare a variable Bale of type Enemy

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Enemy class with the specified parameters:
    Neymar = new Enemy("Neymar", 60, 90, 70, 30) // -Name : Neymar // - Weight: 60 // - Attack: 90 // - Life: 70 // - Defence: 30
    // Creates a new instance of the Enemy class with the specified parameters:
    Bale = new Enemy("Bale", 70, 85, 75, 50) // -Name : Bale // - Weight: 70 // - Attack: 85 // - Life: 75 // - Defence: 50

  }

  test("equalsEnemyName") { // Test if the returned name value for an enemy matches the expected value
    var name: String = Neymar.sayName() // Retrieve the name value of the enemy Neymar and store it in the 'name' variable
    var expected: String = "Neymar" // Define the expected name value
    assertEquals(name, expected) // Compare the actual name value with the expected value
  }

  test("NotEqualsEnemyName") { // Test if the name values of two different enemies are not equal
    var name1: String = Neymar.sayName() // Retrieve the name value of the enemy Neymar and store it in the 'name1' variable
    var name2: String = Bale.sayName() // Retrieve the name value of the enemy Bale and store it in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the name values of Neymar and Bale are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for an enemy matches the expected value
    var weight = Neymar.sayWeight() // Retrieve the weight value of the enemy Neymar and store it in the 'weight' variable
    var expected: Int = 60 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different enemies are not equal
    var weight1 = Neymar.sayWeight() // Retrieve the weight value of the enemy Neymar and store it in the 'weight1' variable
    var weight2 = Bale.sayWeight() // Retrieve the weight value of the enemy Bale and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Neymar and Bale are not equal
  }

  test("equalsAttack") { // Test if the returned attack value for an enemy matches the expected value
    var attack = Neymar.sayAttack() // Retrieve the attack value of the enemy Neymar and store it in the 'attack' variable
    var expected: Int = 90 // Define the expected attack value
    assertEquals(attack, expected) // Compare the actual attack value with the expected value
  }

  test("NotEqualsAttack") { // Test if the attack values of two different enemies are not equal
    var attack1 = Neymar.sayAttack() // Retrieve the attack value of the enemy Neymar and store it in the 'attack1' variable
    var attack2 = Bale.sayAttack() // Retrieve the attack value of the enemy Bale and store it in the 'attack2' variable
    assertNotEquals(attack1, attack2) // Assert that the attack values of Neymar and Bale are not equal
  }

  test("equalsLife") { // Test if the returned life value for an enemy matches the expected value
    var life = Neymar.sayLife() // Retrieve the life value of the enemy Neymar and store it in the 'life' variable
    var expected: Int = 70 // Define the expected life value
    assertEquals(life, expected) // Compare the actual life value with the expected value
  }

  test("NotEqualsLife") { // Test if the life values of two different enemies are not equal
    var life1 = Neymar.sayLife() // Retrieve the life value of the enemy Neymar and store it in the 'life1' variable
    var life2 = Bale.sayLife() // Retrieve the life value of the enemy Bale and store it in the 'life2' variable
    assertNotEquals(life1, life2) // Assert that the life values of Neymar and Bale are not equal
  }

  test("equalsDefence") { // Test if the returned defense value for an enemy matches the expected value
    var defense = Neymar.sayDefence() // Retrieve the defense value of the enemy Neymar and store it in the 'defense' variable
    var expected: Int = 30 // Define the expected defense value
    assertEquals(defense, expected) // Compare the actual defense value with the expected value
  }

  test("NotEqualsDefence") { // Test if the defense values of two different enemies are not equal
    var defense1 = Neymar.sayDefence() // Retrieve the defense value of the enemy Neymar and store it in the 'defense1' variable
    var defense2 = Bale.sayDefence() // Retrieve the de

  }
}
