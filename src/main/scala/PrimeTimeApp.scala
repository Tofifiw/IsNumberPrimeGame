import scala.io.StdIn.readLine
import scala.util.Random
import MathExtensions._

object PrimeTimeApp extends App {
  
  val minAnswer: Int = 201
  val maxAnswer: Int = 300
  var reply: Unit = "?"

  // generate a list of prime numbers from 200 to 500

  var primeList = makePrimeListBuffer(minAnswer, maxAnswer)
  println(primeList)

  do {

    // generate a random number from minAnswer to maxAnswer

    var answer = 0

    while (answer % 2 == 0 || answer % 5 == 0) {
      answer = Random.between(minAnswer, maxAnswer)
    }


    // show the number and ask player if it is prime
    val isPrime = primeList.contains(answer)
    print(s"Is $answer a prime number? (Y/N/X=Exit) ")
    reply = readLine().toUpperCase() match {
      case "Y" => if (isPrime) println(s"Correct, $answer is prime") else println(s"Incorrect, $answer is not prime")
      case "N" => if (isPrime) println(s"Incorrect, $answer is prime") else println(s"Correct $answer is not prime")
      case "X" => System.exit(0)
      case _ => println("You didn't choose answer")
    }


    /*val isPrime = primeList.contains(answer)

    if (isPrime) {
      print(if (reply == "Y") "Correct!" else "Incorrect!")
      println(s" $answer is prime")
    }
    else {
      print(if (reply == "Y") "Incorrect!" else "Correct!")
      println(s" $answer is not prime")
    }*/

  } while (reply != "X")
}
