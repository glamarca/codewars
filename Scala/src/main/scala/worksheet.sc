var data: String = "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9" +
  "\n" +
  "London:Jan 48.0,Feb 38.9,Mar 39.9,Apr 42.2,May 47.3,Jun 52.1,Jul 59.5,Aug 57.2,Sep 55.4,Oct 62.0,Nov 59.0,Dec 52.9" +
  "\n" +
  "Paris:Jan 182.3,Feb 120.6,Mar 158.1,Apr 204.9,May 323.1,Jun 300.5,Jul 236.8,Aug 192.9,Sep 66.3,Oct 63.3,Nov 83.2,Dec 154.7" +
  "\n" +
  "NY:Jan 108.7,Feb 101.8,Mar 131.9,Apr 93.5,May 98.8,Jun 93.6,Jul 102.2,Aug 131.8,Sep 92.0,Oct 82.3,Nov 107.8,Dec 94.2" +
  "\n" +
  "Vancouver:Jan 145.7,Feb 121.4,Mar 102.3,Apr 69.2,May 55.8,Jun 47.1,Jul 31.3,Aug 37.0,Sep 59.6,Oct 116.3,Nov 154.6,Dec 171.5" +
  "\n" +
  "Sydney:Jan 103.4,Feb 111.0,Mar 131.3,Apr 129.7,May 123.0,Jun 129.2,Jul 102.8,Aug 80.3,Sep 69.3,Oct 82.6,Nov 81.4,Dec 78.2" +
  "\n" +
  "Bangkok:Jan 10.6,Feb 28.2,Mar 30.7,Apr 71.8,May 189.4,Jun 151.7,Jul 158.2,Aug 187.0,Sep 319.9,Oct 230.8,Nov 57.3,Dec 9.4" +
  "\n" +
  "Tokyo:Jan 49.9,Feb 71.5,Mar 106.4,Apr 129.2,May 144.0,Jun 176.0,Jul 135.6,Aug 148.5,Sep 216.4,Oct 194.1,Nov 95.6,Dec 54.4" +
  "\n" +
  "Beijing:Jan 3.9,Feb 4.7,Mar 8.2,Apr 18.4,May 33.0,Jun 78.1,Jul 224.3,Aug 170.0,Sep 58.4,Oct 18.0,Nov 9.3,Dec 2.7" +
  "\n" +
  "Lima:Jan 1.2,Feb 0.9,Mar 0.7,Apr 0.4,May 0.6,Jun 1.8,Jul 4.4,Aug 3.1,Sep 3.3,Oct 1.7,Nov 0.5,Dec 0.7"


def subMean(values: List[Double]) = {
    values.sum / values.length
}

def getValues(town : String, strng : String) = {
    val subvalues = strng.split("\n").filter(_.startsWith(town))
    if(subvalues.isEmpty) List()
    else subvalues.mkString.split(":").drop(1).mkString.split(",").toList.map(_.substring(4).toDouble)
}


def mean(town: String, strng: String): Double = {
    val values = getValues(town, strng)
    if(values.isEmpty){
        -1
    } else {
        print(values.mkString)
        subMean(values)
    }
}

def variance(town: String, strng: String): Double = {
    val values = getValues(town, strng)
    if(values.isEmpty){
        -1
    } else {
        val mean = subMean(values)
        subMean(values.map( x => math.pow(x-mean, 2)))
    }

}

mean("Lonn",data)
variance("Ldon", data)



def loveVsFriendship(s: String): Int = {
    s.toList.foldLeft(0)((a : Int,b : Char) => a + (b.toInt-96))
}

loveVsFriendship("attitude")


def reverseString(s: String): String = {
    s.toList.reverse.mkString
}

reverseString("world")


def number(busStops: List[(Int, Int)]): Int = busStops match {
    case Nil => 0
    case x::xs => (x._1-x._2) + number(xs)
}

number(List((10, 0)))

def createPhoneNumber(numbers: Seq[Int]) = {
    val numAsStr = numbers.mkString
    f"(${numAsStr}%.3s) ${numAsStr.drop(3)}%.3s-${numAsStr.drop(6)}"
}

createPhoneNumber(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))

def solution(number: Int): Long ={
  (1 until number).filter(n => n % 3 == 0 || n % 5 == 0).map(x => x.longValue()).sum
}

solution(19)
solution(36)

def isPrime(n: Long): Boolean = ! ((2L until n-1L) exists (n % _ == 0))

def backwardsPrime(start: Long, nd: Long): String = {
    (start to nd).filter(p => p != p.toString.reverse.toLong && isPrime(p) && isPrime(p.toString.reverse.toLong)).mkString(",")
}

val s = "48.0"
s.toDouble



backwardsPrime(70000, 70245)
