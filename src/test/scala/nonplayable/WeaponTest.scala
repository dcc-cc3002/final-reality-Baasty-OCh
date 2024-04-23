package nonplayable

import model.nonplayable.Weapon
import model.playable.APlayable
import munit.FunSuite
class WeaponTest extends FunSuite {
  var Sword: Weapon = _ // We declare a variable Sword of type Weapon
  var Bow: Weapon = _ // We declare a variable Bow of type Weapon
  var Cristiano: Character = _ // We declare a variable Cristiano of type Character
  var Messi: Character = _ // We declare a variable Messi of type Character

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Weapon class with the specified parameters:
    Sword = new Weapon("Espada",70,100,Cristiano) // -Name : Espada // - Weight: 70 // - Attack: 100 // - Owner : Cristiano
    // Creates a new instance of the Weapon class with the specified parameters:
    Bow = new Weapon("Arco",25,50,Messi) // -Name : Arco // - Weight: 25 // - Attack: 50 // - Owner : Messi

  }
  test("equalsName") { // Test if the returned name value for a sword matches the expected value
    var name: String = Sword.sayName() // Retrieve the name value of the sword and store it in the 'name' variable
    var expected = "Espada" // Define the expected name value
    assertEquals(name, expected) // Compare the actual name value with the expected value
  }

  test("NotEqualsName") { // Test if the name values of two different weapons are not equal
    var name1 = Sword.sayName() // Retrieve the name value of the sword and store it in the 'name1' variable
    var name2 = Bow.sayName() // Retrieve the name value of the bow and store it in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the name values of the sword and the bow are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for a sword matches the expected value
    var weight = Sword.sayWeight() // Retrieve the weight value of the sword and store it in the 'weight' variable
    var expected: Int = 70 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different weapons are not equal
    var weight1 = Sword.sayWeight() // Retrieve the weight value of the sword and store it in the 'weight1' variable
    var weight2 = Bow.sayWeight() // Retrieve the weight value of the bow and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of the sword and the bow are not equal
  }

  test("equalsAttack") { // Test if the returned attack value for a sword matches the expected value
    var attack = Sword.sayAttack() // Retrieve the attack value of the sword and store it in the 'attack' variable
    var expected: Int = 100 // Define the expected attack value
    assertEquals(attack, expected) // Compare the actual attack value with the expected value
  }

  test("NotEqualsAttack") { // Test if the attack values of two different weapons are not equal
    var attack1 = Sword.sayAttack() // Retrieve the attack value of the sword and store it in the 'attack1' variable
    var attack2 = Bow.sayAttack() // Retrieve the attack value of the bow and store it in the 'attack2' variable
    assertNotEquals(attack1, attack2) // Assert that the attack values of the sword and the bow are not equal
  }

  test("equalsOwner") { // Test if the returned owner character for a sword matches the expected character
    var owner: Character = Sword.sayOwner() // Retrieve the owner character of the sword and store it in the 'owner' variable
    var expected: Character = Cristiano // Define the expected owner character
    assertEquals(owner, expected) // Compare the actual owner character with the expected character
  }



}
