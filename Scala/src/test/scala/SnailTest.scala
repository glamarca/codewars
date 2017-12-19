import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class SnailTest extends FunSuite {
  import Snail.snail

  test("Snail of empty matrix is an empty array"){
    val matrix : Array[Array[Int]] = Array(Array())
    val expected : Array[Int] = Array()
    test_results(matrix, expected)
  }

  test("Snail on an 1x1 matrix should be a list with one element with the same value"){
    val matrix = Array(Array(2))
    val expected = Array(2)
    test_results(matrix, expected)
  }

  test("Snails on 2x2 matrix"){
    val matrix = Array(Array(2, 3), Array(3,4))
    val expected = Array(2,3,4,3)
    test_results(matrix, expected)
  }

  def test_results(matrix : Array[Array[Int]], expected : Array[Int]): Unit ={
    val given = snail(matrix)
    try{
      assert(given.deep == expected.deep)
    } catch {
      case e => {
        printResults(given, expected, matrix)
        throw e
      }
    }
  }

  def printResults(given : Array[Int], expected : Array[Int], matrix : Array[Array[Int]]): Unit = {
    println(s"Given : ${given.mkString("Array(",",", ")")}")
    println(s"Expected : ${expected.mkString("Array(",",", ")")}")
    println(s"Matrix : ${matrix.deep.mkString("Array(",",", ")")}")
  }
}
