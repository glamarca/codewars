def contains(string1: List[Char], string2 : List[Char]) : Boolean = {
  string2 exists (substring => string1 contains substring)
}

val s1 = "x".toList
val s2 = "klklx".toList

contains(s1, s2)
contains(s2, s1)
