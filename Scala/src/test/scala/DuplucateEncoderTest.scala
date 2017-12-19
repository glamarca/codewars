import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class DuplicateEncoderTest extends FunSuite {

  import DuplicateEncoder.duplicateEncode

  test("Empty string should return empty String") {
      assert(duplicateEncode("") == "")
  }

  test("Null string should return empty String") {
    assert(duplicateEncode(null) == "")
  }

  test("One char size string should return '(' "){
    assert(duplicateEncode("x") == "(")
  }

  test("Two sibling char size string should return '))'"){
    assert(duplicateEncode("xx") == "))")
    assert(duplicateEncode("xX") == "))")
  }

  test("A two different char size string should return '(('"){
    assert(duplicateEncode("xy") == "((")
  }

  test("N char string testing..."){
    assert(duplicateEncode("din") == "(((")
    assert(duplicateEncode("recede") == "()()()")
    assert(duplicateEncode("Success") == ")())())")
    assert(duplicateEncode("(( @") == "))((")
  }

}
