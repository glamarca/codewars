val s = "4terxret4"

s.length
s.length % 2
s.length / 2

def get_random_idx_not_middle(s : String) : Int = {
  val x = new scala.util.Random().nextInt(Integer.MAX_VALUE) % s.length
  println(x)
  if ((x != s.length / 2 && (s.length % 2 == 0)) || ( ((x != (s.length / 2) -1) || (x != (s.length / 2))) && (s.length %2 != 0))){
    x
  } else {
    get_random_idx_not_middle(s)
  }
}

val idx = 5
s.substring(0,idx ).concat("x").concat(s.substring(idx))
