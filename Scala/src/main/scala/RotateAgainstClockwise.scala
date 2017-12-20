object RotateAgainstClockwise {
    def rotate(matrix : List[List[Int]], times: Int) : List[List[Int]] = {
      if(matrix != null && matrix.nonEmpty && matrix.head.nonEmpty) rotateSafe(matrix, times) else matrix
    }

  def rotateOnce2(matrix: List[List[Int]]): List[List[Int]] = {
    if(matrix != null && matrix.nonEmpty && matrix.head.nonEmpty){
      (for {
        i <- matrix.head.indices
        interMed = (for {
          j <- matrix.indices
        } yield matrix(j).reverse(i)).toList
      } yield interMed).toList
    } else {
      matrix
    }
  }

  def rotateOnce3(matrix: List[List[Int]]): List[List[Int]] = {
    if(matrix != null && matrix.nonEmpty && matrix.head.nonEmpty){
      matrix.indices.map(x => matrix.indices.map(y => matrix(y).reverse(x)).toList).toList
    } else {
      matrix
    }
  }

  def rotateSafe(matrix: List[List[Int]], times : Int): List[List[Int]] = {
    if (times % 4 == 0) matrix else rotateSafe(matrix.transpose.reverse, times % 4 - 1)
  }

  def isValidMatrix(matrix: List[List[Int]]) : Boolean = matrix.forall(_.lengthCompare(matrix.length) == 0)
}
