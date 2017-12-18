import java.nio.BufferOverflowException
import java.util.*
import kotlin.test.assertFailsWith
import org.junit.Test as test

class ThrowWithoutThrowingKtTest{
    @test fun tests() {
        assertFailsWith(ArithmeticException::class, ::arithmetic)
        assertFailsWith(NoSuchElementException::class, ::noSuchElement)
        assertFailsWith(ArrayIndexOutOfBoundsException::class, ::arrayIndexOutOfBound)
        assertFailsWith(ClassCastException::class, ::classCast)
        //assertFailsWith(StackOverflowError::class, ::stackOverflow)
        assertFailsWith(NullPointerException::class, ::nullPointer)
        assertFailsWith(NumberFormatException::class, ::numberFormat)
        //assertFailsWith(IllegalArgumentException::class, ::illegalArgument)
        assertFailsWith(NegativeArraySizeException::class, ::negativeArraySize)
        //assertFailsWith(EmptyStackException::class, ::emptyStack)
        //assertFailsWith(BufferOverflowException::class, ::bufferOverflow)
        //assertFailsWith(ArrayStoreException::class, ::arrayStore)
        //assertFailsWith(UnsupportedOperationException::class, ::unsupportedOperation)
        //assertFailsWith(IllegalStateException::class, ::illegalState)
    }
}