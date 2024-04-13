import munit.FunSuite
import model.nonplayable.{MagicWeapon, NonPlayable, Weapon,Enemy}
import model.playable.{Character, MagicCharacter, Playable}
class MagicWeaponTest extends FunSuite {
  var Wand: MagicWeapon = _ // We declare a variable Wand of type MagicWeapon
  var Staff: MagicWeapon = _ // We declare a variable Staff of type MagicWeapon
  var Alexis: MagicCharacter = _ // We declare a variable Alexis of type MagicCharacter
  var Vidal: MagicCharacter = _ // We declare a variable Vidal of type MagicCharacter
  var Cristiano: Character = _ // We declare a variable Cristiano of type Character

  override def beforeEach(context: BeforeEach): Unit = {
    // Creates a new instance of the MagicWeapon class with the specified parameters:
    Wand = new MagicWeapon("Barita",10,50,50,Alexis) // -Name : Barita // - Weight: 10 // - Attack: 50 // - Mana: 50 //- Owner : Alexis
    // Creates a new instance of the MagicWeapon class with the specified parameters:
    Staff = new MagicWeapon("Baston",15,60,45,Vidal) // -Name : Baston // - Weight: 15 // - Attack: 60 // - Mana: 45 //- Owner : Vidal


  }
  test("equalsName") { // Test if the returned name value for a wand matches the expected value
    var name: String = Wand.sayName() // Retrieve the name value of the wand and store it in the 'name' variable
    var expected = "Barita" // Define the expected name value
    assertEquals(name, expected) // Compare the actual name value with the expected value
  }

  test("NotEqualsName") { // Test if the name values of two different magical items are not equal
    var name1 = Wand.sayName() // Retrieve the name value of the wand and store it in the 'name1' variable
    var name2 = Staff.sayName() // Retrieve the name value of the staff and store it in the 'name2' variable
    assertNotEquals(name1, name2) // Assert that the name values of the wand and the staff are not equal
  }

  test("equalsWeight") { // Test if the returned weight value for a wand matches the expected value
    var weight = Wand.sayWeight() // Retrieve the weight value of the wand and store it in the 'weight' variable
    var expected: Int = 10 // Define the expected weight value
    assertEquals(weight, expected) // Compare the actual weight value with the expected value
  }

  test("NotEqualsWeight") { // Test if the weight values of two different magical items are not equal
    var weight1 = Wand.sayWeight() // Retrieve the weight value of the wand and store it in the 'weight1' variable
    var weight2 = Staff.sayWeight() // Retrieve the weight value of the staff and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of the wand and the staff are not equal
  }

  test("equalsAttack") { // Test if the returned attack value for a wand matches the expected value
    var attack = Wand.sayAttack() // Retrieve the attack value of the wand and store it in the 'attack' variable
    var expected: Int = 50 // Define the expected attack value
    assertEquals(attack, expected) // Compare the actual attack value with the expected value
  }

  test("NotEqualsAttack") { // Test if the attack values of two different magical items are not equal
    var attack1 = Wand.sayAttack() // Retrieve the attack value of the wand and store it in the 'attack1' variable
    var attack2 = Staff.sayAttack() // Retrieve the attack value of the staff and store it in the 'attack2' variable
    assertNotEquals(attack1, attack2) // Assert that the attack values of the wand and the staff are not equal
  }

  test("equalsMana") { // Test if the returned mana value for a wand matches the expected value
    var mana = Wand.sayMana() // Retrieve the mana value of the wand and store it in the 'mana' variable
    var expected: Int = 50 // Define the expected mana value
    assertEquals(mana, expected) // Compare the actual mana value with the expected value
  }

  test("NotEqualsMana") { // Test if the mana values of two different magical items are not equal
    var mana1 = Wand.sayMana() // Retrieve the mana value of the wand and store it in the 'mana1' variable
    var mana2 = Staff.sayAttack() // Retrieve the mana value of the staff and store it in the 'mana2' variable
    assertNotEquals(mana1, mana2) // Assert that the mana values of the wand and the staff are not equal
  }

  test("equalsMagicOwner") { // Test if the returned owner character for a wand matches the expected character
    var owner: MagicCharacter = Wand.sayOwner() // Retrieve the owner character of the wand and store it in the 'owner' variable
    var expected: MagicCharacter = Alexis // Define the expected owner character
    assertEquals(owner, expected) // Compare the actual owner character with the expected character
  }

}
