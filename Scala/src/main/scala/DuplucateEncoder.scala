object DuplicateEncoder {

  def duplicateEncode(word: String): String = {
    if (word == null) ""
    else {
      word.map(x => if (word.count(_.toUpper == x.toUpper) > 1) ")" else "(").mkString
    }
  }
}

