def rotateSafe(matrix: List[List[Int]])(times : Int) : List[List[Int]] = {

  if((times % 4) == 0) matrix else rotateSafe (matrix) (times % 4 - 1)
}
val matrix = List(List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4), List(1, 2, 3, 4))