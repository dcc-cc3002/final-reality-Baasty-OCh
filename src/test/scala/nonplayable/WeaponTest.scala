package nonplayable

import model.nonplayable.{NonPlayable,Sword,Axe,Bow}
import model.playable.Playable
import munit.FunSuite
class WeaponTest extends FunSuite {
  var Sword: NonPlayable = _ // We declare a variable Sword of type Weapon
  var Bow: NonPlayable = _ // We declare a variable Bow of type Weapon
  var Axe: NonPlayable = _
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Character
  var Messi: Playable = _ // We declare a variable Messi of type Character
  var Casemiro: Playable = _
  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the Weapon class with the specified parameters:
    Sword  = new Sword(Cristiano) // -Name : Espada // - Weight: 70 // - Attack:
    Bow = new Bow(Messi) // -Name : Arco // - Weight: 25 // - Attack: 50 // - Owner : Messi
    Axe = new Axe(Casemiro)

  }

  test("equals") { // Test if two references to the same character are equal
    assertEquals(Sword, Sword)
    assertEquals(Bow, Bow)
    assertEquals(Axe,Axe)
  }
  test("NotEquals") { // Test if two references to the same character are equal
    assertNotEquals(Bow, Sword)
    assertNotEquals(Axe, Bow)
    assertNotEquals(Sword,Axe)
  }
  test("setName") { // Test if the returned name value for a character matches the expected value
    var name = Sword.getName // Retrieve the name value of the character Cristiano and store it in the 'name' variable
    var name2 = Bow.getName
    var name3 = Axe.getName
    assertEquals(name, "Espada") // Compare the actual name value with the expected value
    assertEquals(name2, "Arco")
    assertEquals(name3, "Hacha")
  }

  test("equalsWeight") { // Test if the returned weight value for a sword matches the expected value
    var weight = Sword.getWeight // Retrieve the weight value of the sword and store it in the 'weight' variable
    var expected: Int = 70 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different weapons are not equal
    var weight1 = Sword.getWeight // Retrieve the weight value of the sword and store it in the 'weight1' variable
    var weight2 = Bow.getWeight // Retrieve the weight value of the bow and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of the sword and the bow are not equal
  }

  test("equalsAttack") { // Test if the returned attack value for a sword matches the expected value
    var attack = Sword.getAttack // Retrieve the attack value of the sword and store it in the 'attack' variable
    var expected: Int = 70 // Define the expected attack value
    assertEquals(attack, expected) // Compare the actual attack value with the expected value
  }

  test("NotEqualsAttack") { // Test if the attack values of two different weapons are not equal
    var attack1 = Sword.getAttack // Retrieve the attack value of the sword and store it in the 'attack1' variable
    var attack2 = Bow.getAttack // Retrieve the attack value of the bow and store it in the 'attack2' variable
    assertNotEquals(attack1, attack2) // Assert that the attack values of the sword and the bow are not equal
  }

  test("equalsOwner") { // Test if the returned owner character for a sword matches the expected character
    var owner: Any = Sword.getOwner // Retrieve the owner character of the sword and store it in the 'owner' variable
    var expected: Playable = Cristiano // Define the expected owner character
    assertEquals(owner, expected) // Compare the actual owner character with the expected character
  }
  test("setMAP"){
    assertEquals(Sword.getMAP,0)
    assertEquals(Bow.getMAP,0)
    assertEquals(Axe.getMAP,0)
  }



}
