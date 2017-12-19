object NPointCrossover {

  def truc(x : Int): Int = {
    x*x
  }

  def crossover[T](ns: List[Int], xs: List[T], ys: List[T]): (List[T],List[T]) = {
    def crossover_acc[T](ns: List[Int], xs: List[T], ys: List[T], ns_done: List[Int]): (List[T], List[T]) = {
      ns match {
        case Nil => (xs, ys)
        case n :: nss =>
          if (ns_done.contains(n)) {
            crossover_acc(nss, xs, ys, ns_done)
          } else {
            crossover_acc(nss, xs.splitAt(n)._1 ::: ys.splitAt(n)._2, ys.splitAt(n)._1 ::: xs.splitAt(n)._2, n::ns_done)
          }
      }
    }
    if (xs == null || ys == null || xs == Nil || xs.isEmpty || ys == Nil || ys.isEmpty || xs.lengthCompare(ys.length) != 0) {
      (Nil, Nil)
    } else if (ns == null || xs.lengthCompare(ns.length) < 0) {
      (xs, ys)
    }else{
      crossover_acc(ns.sorted, xs, ys, Nil)
    }
  }
}
