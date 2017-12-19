import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class SnailTest extends FunSuite {
  import Snail.snail
  import Snail.rotate
  import Snail.valid_matrix

  test("Valid matrix should be NxN"){
    val matrix_v = List(List(1,2,3,4), List(1,2,3,4), List(1,2,3,4), List(1,2,3,4))
    val matrix_i = List(List(1,2,3,4), List(1,2,3,4), List(1,2,3,4))
    assert(valid_matrix(matrix_v))
    assert(!valid_matrix(matrix_i))
  }

  test("Snail on invalid matrix shoul throw an IllegalArgumentException"){
    val matrix_i = List(List(1,2,3,4), List(1,2,3,4), List(1,2,3,4))
    intercept[IllegalArgumentException]{snail(matrix_i)}
  }

  test("Snail of empty matrix is an empty List"){
    val matrix : List[List[Int]] = List(List())
    val expected : List[Int] = List()
    test_results(matrix, expected)
  }

  test("Snail on an 1x1 matrix should be a list with one element with the same value"){
    val matrix = List(List(2))
    val expected = List(2)
    test_results(matrix, expected)
  }

  test("Rotate on empty List = empty List"){
    val martix = List[List[Int]]()
    val expected = List[List[Int]]()
    assert(expected == rotate(martix))
  }

  test("Rotate on 1x1 return the List"){
    val martix = List(List(1))
    val expected = List(List(1))
    assert(expected == rotate(martix))
  }
  test("Rotate on nx1 return a List 1xn"){
    val martix = List(List(1,2))
    val expected = List(List(2), List(1))
    assert(expected == rotate(martix))
    val martix2 = List(List(1,2,3,4))
    val expected2 = List(List(4), List(3),List(2), List(1))
    assert(expected2 == rotate(martix2))
  }
  test("Rotate on 1xn return a List nx1"){
    val martix = List(List(1), List(2))
    val expected = List(List(1,2))
    assert(expected == rotate(martix))
    val martix2 = List(List(1), List(2), List(3), List(4))
    val expected2 = List(List(1,2,3,4))
    assert(expected2 == rotate(martix2))
  }
  test("Rotate on nxm return an List mxn"){
    val matrix = List(List(1,2,3,4,5), List(1,2,3,4,5), List(1,2,3,4,5))
    val expected = List(List(5,5,5), List(4,4,4), List(3,3,3), List(2,2,2), List(1,1,1))
    assert(expected == rotate(matrix))
  }

  test("Snails on 2x2 matrix"){
    val matrix = List(List(2, 3), List(3,4))
    val expected = List(2,3,4,3)
    test_results(matrix, expected)
  }

  test("Snail on nxn matrix"){
    val matrix = List(List(1,2), List(3,4))
    val expected = List(1,2,4,3)
    val matrix2 = List(List(1,2,3), List(4,5,6), List(7,8,9))
    val expected2 = List(1,2,3,6,9,8,7,4,5)
    test_results(matrix, expected)
    test_results(matrix2, expected2)
  }

  test("First example should work in") {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res = List(1, 2, 3, 6, 9, 8, 7, 4, 5)
    assert(snail(input) == res)
  }

  test("Second example should work in") {
    val input = List(
      List(1, 2, 3),
      List(8, 9, 4),
      List(7, 6, 5))
    val res = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(snail(input) == res)
  }

  def test_results(matrix : List[List[Int]], expected : List[Int]): Unit ={
    val given = snail(matrix)
    try{
      assert(given == expected)
    } catch {
      case e => {
        printResults(given, expected, matrix)
        throw e
      }
    }
  }

  def printResults(given : List[Int], expected : List[Int], matrix : List[List[Int]]): Unit = {
    println(s"Given : ${given.mkString("List(",",", ")")}")
    println(s"Expected : ${expected.mkString("List(",",", ")")}")
    println(s"Matrix : ${matrix.mkString("List(",",", ")")}")
  }
}
