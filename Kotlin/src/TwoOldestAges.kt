fun sum (a:Int, b:Int) = a+b

fun twoOldestAges (ages : List<Int>) : List<Int> {
    return ages.sorted().takeLast(2)
    /*return when {
        ages.isEmpty() -> emptyList()
        ages.size == 1 -> listOf(ages[0], ages[0])
        else -> {
            val sortedAges = ages.sorted()
            sortedAges.slice(ages.size-2 until ages.size)
        }
    }*/
}