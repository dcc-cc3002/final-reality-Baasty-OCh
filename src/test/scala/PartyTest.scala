import munit.FunSuite
import model.party.Party
class PartyTest extends FunSuite {
  var Team1: Party = _

  override def beforeEach(context: BeforeEach): Unit = {
    var Team1 = new Party()
  }

}
