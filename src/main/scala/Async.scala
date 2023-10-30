import scala.concurrent.{Future, ExecutionContext}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}


object Async {
  def main(args: Array[String]): Unit = {
    // Define functions to calculate square and cube asynchronously
    def calculateSquare(number: Int): Future[Int] = Future {
      // Simulate an asynchronous operation (e.g., a computation)
      Thread.sleep(1000)
      number * number
    }

    def calculateCube(number: Int): Future[Int] = Future {
      // Simulate another asynchronous operation
      Thread.sleep(1500)
      number * number * number
    }

    val number = 5

    val squareFuture: Future[Int] = calculateSquare(number)
    val cubeFuture: Future[Int] = calculateCube(number)

    // Combine the results when both are complete
    val result: Future[(Int, Int)] = squareFuture.zip(cubeFuture)

    result.onComplete {
      case Success((square, cube)) =>
        println(s"Square: $square, Cube: $cube")
      case Failure(ex) =>
        println(s"Error: ${ex.getMessage}")
    }

    // Ensure the program doesn't exit immediately (to allow the futures to complete)
    Thread.sleep(3000)


  }
}
