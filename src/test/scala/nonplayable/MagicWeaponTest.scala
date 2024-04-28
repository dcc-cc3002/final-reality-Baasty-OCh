package nonplayable

import model.playable.Playable
import model.nonplayable.{NonPlayable, Staff,Wand}
import munit.FunSuite
class MagicWeaponTest extends FunSuite {
  var Wand: Wand = _ // We declare a variable Wand of type MagicWeapon
  var Staff: Staff = _ // We declare a variable Staff of type MagicWeapon
  var Alexis: Playable = _ // We declare a variable Alexis of type MagicCharacter
  var Vidal: Playable = _ // We declare a variable Vidal of type MagicCharacter
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Character

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the MagicWeapon class with the specified parameters:
    Wand = new Wand(Alexis) // -Name : Barita // - Weight: 10 // - Attack: 50 // - Mana: 50 //- Owner : Alexis
    // Creates a new instance of the MagicWeapon class with the specified parameters:
    Staff = new Staff(Vidal) // -Name : Baston // - Weight: 15 // - Attack: 60 // - Mana: 45 //- Owner : Vidal


  }

  test("equals") { // Test if the returned name value for a sword matches the expected value
    assertEquals(Wand, Wand) // Compare the actual name value with the expected value
    assertEquals(Staff,Staff)
  }



  test("equalsWeight") { // Test if the returned weight value for a sword matches the expected value
    var weight = Staff.getWeight // Retrieve the weight value of the sword and store it in the 'weight' variable
    var expected: Int = 70 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different weapons are not equal
    var weight1 = Staff.getWeight // Retrieve the weight value of the sword and store it in the 'weight1' variable
    var weight2 = Wand.getWeight // Retrieve the weight value of the bow and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of the sword and the bow are not equal
  }

  test("equalsAttack") { // Test if the returned attack value for a sword matches the expected value
    var attack = Staff.getAttack // Retrieve the attack value of the sword and store it in the 'attack' variable
    var expected: Int = 70 // Define the expected attack value
    assertEquals(attack, expected) // Compare the actual attack value with the expected value
  }

  test("NotEqualsAttack") { // Test if the attack values of two different weapons are not equal
    var attack1 = Staff.getAttack // Retrieve the attack value of the sword and store it in the 'attack1' variable
    var attack2 = Wand.getAttack // Retrieve the attack value of the bow and store it in the 'attack2' variable
    assertNotEquals(attack1, attack2) // Assert that the attack values of the sword and the bow are not equal
  }

  test("equalsOwner") { // Test if the returned owner character for a sword matches the expected character
    var owner: Any = Staff.getOwner // Retrieve the owner character of the sword and store it in the 'owner' variable
    var expected: Playable = Vidal // Define the expected owner character
    assertEquals(owner, expected) // Compare the actual owner character with the expected character
  }



}
