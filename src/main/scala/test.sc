import scala.collection.mutable.ListBuffer

def makePrimeListBuffer(lowerLimit: Int, upperLimit: Int): ListBuffer[Int] = {

  val list = ListBuffer[Int]()

  if (upperLimit < 2 || lowerLimit > upperLimit) {
    return list
  }

  def isNextPrime(test: Int): Boolean = {

    for (n <- list) {
      if (test % n == 0) return false
    }

    true

  }

  var current = 2

  while (current <= upperLimit) {

    if (isNextPrime(current)) list += current
    current += 1

  }

  list.filter(_ >= lowerLimit)

}

println(makePrimeListBuffer(23, 4))
