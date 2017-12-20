import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class LongestCommonSubsequenceTest extends FunSuite {
  import LongestCommonSubsequence.solve

  test("Return null if one string is null"){
    assert(solve(null, "") == null)
    assert(solve("", null) == null)
  }

  test("Return empty string if one string is empty"){
    assert(solve("xxx", "") == "")
    assert(solve("", "xxx") == "")
  }

  test("Return one string if same strings"){
    assert(solve("abcdef", "abcdef") == "abcdef")
  }

  test("Return empty string if no subsequence"){
    assert(solve("abc", "def") == "")
  }

  test("Return longest subsequence"){
    assert(solve("abcdef" , "abc") == "abc")
    assert(solve("abcdef" , "acf") == "acf")
    assert(solve("132535365", "123456789") == "12356")
  }

}
