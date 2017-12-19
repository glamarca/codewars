object Snail {

  def valid_matrix(matrix: List[List[Int]]) : Boolean = matrix.forall(_.length == matrix.length)

  def snail(matrix : List[List[Int]]): List[Int] = {
    if(!valid_matrix(matrix) && matrix.lengthCompare(1) != 0){
      throw new IllegalArgumentException("Matrix is not a valid NxN matrix")
    }
    snail_safe(matrix)
  }

  def snail_safe(matrix : List[List[Int]]): List[Int] = {
    matrix match {
      case List(List()) => List[Int]()
      case List(x : List[Int]) => x
      case x : List[List[Int]] =>{
        x(0) ++ snail_safe(rotate(matrix.drop(1)))
      }
    }
  }

  def rotate(matrix: List[List[Int]]): List[List[Int]] = {
    if(matrix.nonEmpty){
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
}
