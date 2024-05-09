package playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.{APlayable, Warrior, Ninja, Paladin}
import munit.FunSuite
class CharacterTest extends FunSuite {
  var Cristiano: Playable = _ // We declare a variable Cristiano of type Character
  var Casemiro: Playable = _ // We declare a variable Messi of type Character
  var Messi: Playable = _ // We declare a variable Messi of type Character
  var Neymar: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Paladin("Cristiano")
    Casemiro = new Warrior("Casemiro")
    Messi = new Ninja("Messi")
    Neymar = new Enemy("Neymar")

  }




  test("NotEqualsWeight") { // Test if the weight values of two different characters are not equal
    var weight1 = Cristiano.getWeight // Retrieve the weight value of the character Cristiano and store it in the 'weight1' variable
    var weight2 = Messi.getWeight // Retrieve the weight value of the character Messi and store it in the 'weight2' variable
    assertNotEquals(weight1, weight2) // Assert that the weight values of Cristiano and Messi are not equal
  }

  test("zeroMana") { // Test if the returned kind value for a character matches the expected value
    var mana = Cristiano.getMana // Retrieve the kind value of the character Cristiano and store it in the 'kind' variable
    var mana2 = Messi.getMana
    var mana3 = Casemiro.getMana
    var expected: Int = 0 // Define the expected kind value
    assertEquals(mana, expected) // Compare the actual kind value with the expected value
    assertEquals(mana2, expected)
    assertEquals(mana3, expected)
  }
  test("NotHaveWeapon"){
    assertEquals(Cristiano.haveWeapon,None)
  }
  test("haveWeapon"){
    var Espada: Sword = new Sword(Cristiano)
    Cristiano.putWeapon(Espada)
    var expeted: Option[AWeapon] = Some(new Sword(Cristiano))
    assertEquals(expeted,Cristiano.haveWeapon)
  }
  test("attack"){
    Cristiano.putWeapon(new Sword())
    val daño: Int = Cristiano.attackEnemy(Neymar)
    val expected: Int = 70 - 50
    assertEquals(daño,expected)
  }
  test("wasAttacked"){
    assertEquals(Cristiano.wasAttacked(25).getHp,75) // 100 de vida - 25 de daño -> 75 de vida
    assertEquals(Cristiano.wasAttacked(125).getHp,0)
  }




}