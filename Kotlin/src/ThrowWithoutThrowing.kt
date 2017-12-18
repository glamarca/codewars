import java.util.*

fun arrayIndexOutOfBound() {
    val x = IntArray(1)
    for (y in 0..2){
        x[y] = 5
    }
}

fun negativeArraySize() {
    IntArray(-1)
}

fun noSuchElement() {
    emptyArray<Int>().first()
}

fun arithmetic() {
    2/0
}

fun classCast() {
    "xy" as Int
}

fun stackOverflow() {
}

fun nullPointer() {
    val map = mutableMapOf<String, Int>()
    val c = map["truc"]
}

fun numberFormat() {
    "Not a number".toInt()
}

fun illegalArgument() {

}

fun emptyStack() {
}

fun bufferOverflow() {
}

fun arrayStore() {
}

fun unsupportedOperation() {
}

fun illegalState() {
}


