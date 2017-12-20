import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class RotateAgainstClockwiseTest extends FunSuite {
  import RotateAgainstClockwise.rotate

  test("null matrix should return null"){
      val matrix = null
      assert(rotate(matrix, 5) == null)
  }

  test("empty matrix should return empty matrix"){
    val matrix = List(List())
    assert(rotate(matrix, 1) == List(List()))
  }

  test("sigleton should return itself"){
    val matrix = List(List(5))
    assert(rotate(matrix, 3) == List(List(5)))
  }

  test("Rotate on 2X2"){
    val matrix = List(List(1, 2), List(1, 2))
    val expected_r1 = List(List(2, 2), List(1, 1))
    val expected_r2 = List(List(2, 1), List(2, 1))
    val expected_r3 = List(List(1, 1), List(2, 2))
    val expected_r4 = List(List(1, 2), List(1, 2))
    val expected_r7 = List(List(1, 1), List(2, 2))
    assert(rotate(matrix, 1) == expected_r1)
    assert(rotate(matrix, 2) == expected_r2)
    assert(rotate(matrix, 3) == expected_r3)
    assert(rotate(matrix, 4) == expected_r4)
    assert(rotate(matrix, 7) == expected_r7)
  }

  test("Rotate on 3X3"){
    val matrix = List(List(1, 2, 3), List(1, 2, 3), List(1, 2, 3))
    val expected_r1 = List(List(3, 3, 3), List(2, 2, 2), List(1, 1, 1))
    val expected_r2 = List(List(3, 2, 1), List(3, 2, 1), List(3, 2, 1))
    val expected_r3 = List(List(1, 1, 1), List(2, 2, 2), List(3, 3, 3))
    val expected_r4 = List(List(1, 2, 3), List(1, 2, 3), List(1, 2, 3))
    val expected_r10 = List(List(3, 2, 1), List(3, 2, 1), List(3, 2, 1))
    assert(rotate(matrix, 1) == expected_r1)
    assert(rotate(matrix, 2) == expected_r2)
    assert(rotate(matrix, 3) == expected_r3)
    assert(rotate(matrix, 4) == expected_r4)
    assert(rotate(matrix, 10) == expected_r10)

  }

  test("Rotate on 4x4"){
    val matrix = List(List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4))
    val expected_r1 = List(List(4, 4, 4, 4), List(3, 3, 3, 3), List(2, 2, 2, 2), List(1, 1, 1, 1))
    val expected_r2 = List(List(4, 3, 2, 1), List(4, 3, 2, 1), List(4, 3, 2, 1), List(4, 3, 2, 1))
    val expected_r3 = List(List(1, 1, 1, 1), List(2, 2, 2, 2), List(3, 3, 3, 3), List(4, 4, 4, 4))
    val expected_r4 = List(List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4))
    val expected_r9 = List(List(4, 4, 4, 4), List(3, 3, 3, 3), List(2, 2, 2, 2), List(1, 1, 1, 1))
    assert(rotate(matrix, 1) == expected_r1)
    assert(rotate(matrix, 2) == expected_r2)
    assert(rotate(matrix, 3) == expected_r3)
    assert(rotate(matrix, 4) == expected_r4)
    assert(rotate(matrix, 9) == expected_r9)

    val matrix2 = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9, 10, 11, 12), List(13, 14, 15, 16))
    val expected2_r1 = List(List(4, 8, 12, 16), List(3, 7, 11, 15), List(2, 6, 10, 14), List(1, 5, 9, 13))
    val expected2_r2 = List(List(16, 15, 14, 13), List(12, 11, 10, 9), List(8, 7, 6, 5), List(4, 3, 2, 1))
    val expected2_r3 = List(List(13, 9, 5, 1), List(14, 10, 6, 2), List(15, 11, 7, 3), List(16, 12, 8, 4))
    val expected2_r4 = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9, 10, 11, 12), List(13, 14, 15, 16))
    val expected2_r8 = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9, 10, 11, 12), List(13, 14, 15, 16))
    assert(rotate(matrix2, 1) == expected2_r1)
    assert(rotate(matrix2, 2) == expected2_r2)
    assert(rotate(matrix2, 3) == expected2_r3)
    assert(rotate(matrix2, 4) == expected2_r4)
    assert(rotate(matrix2, 8) == expected2_r8)
  }

  test("Rotate on nxn"){
    val matrix = List(List(1,2,3,4,5,6,7,8),
                List(9,10,11,12,13,14,15,16),
                List(17, 18, 19, 20, 21, 22, 23, 24),
                List(25, 26, 27, 28, 29, 30, 31, 32),
                List(33, 34, 35, 36, 37, 38, 39, 40),
                List(41, 42, 43, 44, 45, 46, 47, 48),
                List(49, 50, 51, 52, 53, 54, 55, 56),
                List(57, 58, 59, 60, 61, 62, 63, 64))
    val rotated = List(List(57, 49, 41, 33, 25, 17, 9, 1),
                List(58, 50, 42, 34, 26, 18, 10, 2),
                List(59, 51, 43, 35, 27, 19, 11, 3),
                List(60, 52, 44, 36, 28, 20, 12, 4),
                List(61, 53, 45, 37, 29, 21, 13, 5),
                List(62, 54, 46, 38, 30, 22, 14, 6),
                List(63, 55, 47, 39, 31, 23, 15, 7),
                List(64, 56, 48, 40, 32, 24, 16, 8))
    assert(rotate(matrix, 3) == rotated)
  }

  test("Final Tests"){
    (5 to 1000).foreach(x => {
      (1 to 10).foreach(y => make_test(x, y))
    })
  }

  def make_test( n:Int, times : Int): Unit ={
    try{
      val (matrix, rotaded) = make_matrix_and_expected_rotate(n,times)
      assert(rotaded == rotate(matrix, times))
    } catch {
      case e => {
        println(s"Error: $times rotation(s) on matrix $n X $n")
        throw e
      }
    }
  }

  def make_matrix_and_expected_rotate(n:Int, times : Int): (List[List[Int]], List[List[Int]]) ={
    val matrix: List[List[Int]] = (0 until n).toList.map(_ => (0 until n).toList.map(y => y + 1))
    (matrix, get_solution_turn_left(matrix, times))
  }

  def get_solution_turn_left(matrix : List[List[Int]], times : Int): List[List[Int]] = {
    if (times%4 == 0) matrix else get_solution_turn_left(matrix.transpose.reverse, times%4-1)
  }

}
