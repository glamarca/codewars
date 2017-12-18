import kotlin.test.assertEquals
import org.junit.Test as test

class ThreeFundamentalFunctionsKtTest{

    private fun testUnlessHelper(boolean: Boolean) {
        var int = 1
        unless(boolean) { int = 2 }
        assertEquals(if (boolean) 1 else 2, int)
    }

    private fun testUntilHelper(boolean: Int) {
        var int = 1
        var cond = boolean
        until({ (cond--) == 0 }) { int++ }
        assertEquals(boolean + 1, int)
    }

    @test fun testUnless() {
            val r = java.util.Random(System.currentTimeMillis())
            (0..30).forEach { testUnlessHelper(r.nextBoolean()) }
    }

    @test fun testUntil() {
        val r = java.util.Random(System.currentTimeMillis())
        (0..30).forEach { testUntilHelper(Math.abs(r.nextInt(10))) }
    }

    @test fun testForceRun() {
        val r = java.util.Random(System.currentTimeMillis())
        (0..30).forEach { forceRun { listOf(1)[r.nextInt()] } }
        var a = 1
        forceRun { a = 2 }
        assertEquals(a, 2)
    }
}