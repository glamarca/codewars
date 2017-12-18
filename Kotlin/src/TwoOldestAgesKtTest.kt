
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.Test as test

class TwoOldestAgesKtTest() {
    @test fun testSum(){
        assertEquals(5, sum(2,3))
    }

    @test fun testTwoOldestAges(){
        assertTrue(twoOldestAges(emptyList()).isEmpty())
        assertTrue(listOf(4, 4).containsAll(twoOldestAges(listOf(4))))
        assertTrue(listOf(45, 87).containsAll(twoOldestAges(listOf(1,5,87,45,8,8))))
    }
}

