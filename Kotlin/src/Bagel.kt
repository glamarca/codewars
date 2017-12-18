class Bagel {
    val value: Int get() = 3
}

val bagel: Bagel
    get() = Bagel().apply { val value = 4 }
