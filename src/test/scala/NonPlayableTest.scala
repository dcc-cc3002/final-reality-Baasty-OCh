import munit.FunSuite
import model.nonplayable.{Weapon,NonPlayable}
class NonPlayableTest extends FunSuite {
  var Sword: NonPlayable = _
  var Bow: NonPlayable = _
  var Alexis: MagicCharacter = _
  var Vidal: MagicCharacter = _
  override def beforeEach(context: BeforeEach): Unit = {
    Cristiano = new Character()
    Messi = new Character()
    Alexis = new MagicCharacter()
    Vidal = new MagicCharacter()

  }
