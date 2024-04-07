import munit.FunSuite
import model.nonplayable.{Weapon,NonPlayable}
class NonPlayableTest extends FunSuite {
  var Sword: NonPlayable = _
  var Bow: NonPlayable = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword = new Weapon()
    Bow = new Weapon()

  }
