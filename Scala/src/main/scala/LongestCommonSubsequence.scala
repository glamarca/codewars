object LongestCommonSubsequence {

  def safe_solve(s1: String, s2: String): String = ???
  def solve(s1 : String, s2: String): String ={
      if(s1 == null || s2 == null) null else safe_solve(s1, s2).mkString
  }

}
