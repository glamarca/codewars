import org.junit.Assert.assertEquals
import org.junit.Test

class BagelTest {
  import BagelSolver.getBagel
  @Test def testBagel(): Unit = {
    assertEquals(getBagel.getValue == 4, java.lang.Boolean.TRUE)
  }
}