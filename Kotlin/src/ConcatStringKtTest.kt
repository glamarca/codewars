import org.junit.Test
import java.util.*
import kotlin.test.*

class ConcatStringKtTest {

    @Test
    fun fixedTest() {
        assertEquals("ice1000", concatString("ice", "1000"))
    }

    @Test
    fun randomTest() {
        val r = Random(System.currentTimeMillis())
        (0..100).forEach {
            val a = r.nextInt().toString(2)
            val b = r.nextInt().toString(2)
            assertEquals(a + b, concatString(a, b))
        }
    }
}
