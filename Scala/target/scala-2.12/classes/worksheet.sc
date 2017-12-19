
val x = List(1,2,3)
val y = List(1,2,3)

x == y

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

val matrix = List(x,y)
rotate(matrix)
