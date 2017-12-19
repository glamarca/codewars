object Snail {

  def snail(matrix : Array[Array[Int]]): Array[Int] = {
    matrix match {
      case Array(Array()) => Array[Int]()
      case Array(Array(x:Int)) => Array(x)
      case Array(Array(x: Int, y: Int), Array(v:Int, w:Int)) =>{
        Array(x, y, w, v)
      }
    }
  }

}
