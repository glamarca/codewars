import java.util.*
import kotlin.test.assertEquals
import org.junit.Test as test

class ExtensionConstructorKtTest{
    @test fun testInt(){
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextInt().let { assertEquals(it, kotlinnn.Int(it.toString())) } }
    }
    @test fun testLong(){
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextLong().let { assertEquals(it, kotlinnn.Long(it.toString())) } }
    }
    @test fun testDouble(){
        val r = Random(System.currentTimeMillis())
        (0..100).forEach { r.nextDouble().let { assertEquals(it, kotlinnn.Double(it.toString())) } }
    }
}