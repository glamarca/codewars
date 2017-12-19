import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class SingleCharPalindromesTest extends FunSuite {
    import SingleCharPalindromes.solve

    test("Null string should return 'not possible'"){
      assert(solve(null) == "not possible")
    }

    test("Empty string should return 'OK'"){
      assert(solve("") == "OK")
    }

    test("Basic tests"){
      assert(solve("abba") == "OK")
      assert(solve("abbaa") =="remove one")
      assert(solve("abbaab") == "not possible")
      assert(solve("madmam") == "remove one")
      assert(solve("raydarm") == "not possible")
      assert(solve("hannah") == "OK")
    }

    test("Edge cases"){
      assert(solve("baba") == "remove one")
      assert(solve("babab") == "OK")
      assert(solve("bababa") == "remove one")
      assert(solve("abcbad") == "remove one")
      assert(solve("abcdba") == "remove one")
      assert(solve("dabcba") == "remove one")
      assert(solve("abededba") == "remove one")
      assert(solve("abdcdeba") == "remove one")
      assert(solve("abcdedba") == "remove one")
      assert(solve("abbcdedba") == "not possible")
    }



    val valid_simple_palins : List[String] = List("raccar", "onno", "anna", "aa", "alla", "murrum", "weew", "boob", "birrib",
      "babbab","caac", "ciic", "cammac",
      "deiied", "deleeled", "devved", "deed", "detarrated", "diallaid", "dondnod", "drawward",
      "dumbmud", "drawndnward", "elle", "ee", "evillive", "evittive", "goog",
      "haah", "hannah", "ipreerpi", "kaak", "kaak", "kanaanak", "kiniinik", "lewel", "leel",
      "liooil", "liveevil", "maam", "miim", "mirrim", "mm", "myym", "nattan",
      "nocon", "nurssrun", "pottop", "reer", "reiier", "repper", "rottor", "roaaor", "roor",
      "raar", "saas", "sees", "soos", "stts", "teet", "terxret", "tesset", "toiiot", "toppot")

    def get_random_idx_not_middle(s : String) : Int = {
      val x = new scala.util.Random().nextInt(Integer.MAX_VALUE) % s.length
      if ((x != s.length / 2 && s.length % 2 == 0) || ( x != s.length / 2 && x != (s.length / 2)+1 && s.length %2 != 0)){
        x
      } else {
        get_random_idx_not_middle(s)
      }
    }

    def make_minus_one_palins(palins: List[String]): List[String] = {
        palins.map(s => {
          val idx = get_random_idx_not_middle(s)
          s.substring(0,idx ).concat("x").concat(s.substring(idx))
        })
    }

    def make_invalid_palins(palins: List[String]):List[String] = {
      palins.map(s => {
        val idx = get_random_idx_not_middle(s)
        s.substring(0,idx ).concat("kw").concat(s.substring(idx).concat("xy"))
      })
    }

    def more_valid_palins(palins : List[String]): List[String] = {
      (for (i <- 1 to 250) yield {
        val rnd = new scala.util.Random().nextInt(Integer.MAX_VALUE) % 10
        ("x" * rnd).concat(palins(i % palins.length)).concat(("x" * rnd).toString)
      }).toList
    }

    test("Finish tests"){
          val valid_palins = valid_simple_palins ::: more_valid_palins(valid_simple_palins)
          make_random_tests(valid_palins, "OK")
          make_random_tests(make_minus_one_palins(valid_palins), "remove one")
          make_random_tests(make_invalid_palins(valid_palins), "not possible")
      }

    def make_random_tests(candidates : List[String], expected : String): Unit ={
         for (s <- candidates) {
           val given = solve(s)
           try {
             assert(given == expected)
           } catch  {
             case e : Throwable => {
                println(s"Error during test : \nWith  \'$s\' the result should be \'$expected\' instead of \'$given\'")
                throw e
             }
           }
         }
    }

}
