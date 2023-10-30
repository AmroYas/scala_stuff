// instantiate sealed class
sealed abstract class Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(width: Double, height: Double) extends Shape
case class Triangle(base: Double, height: Double) extends Shape
case object UnknownShape extends Shape

object Main {
  def main(args: Array[String]): Unit = {
    val shapes: List[Shape] = List(
      Circle(5.0),
      Rectangle(3.0, 4.0),
      Triangle(6.0, 8.0),
      UnknownShape
    )
    for (shape <- shapes) {
      val description = shape match {
        case Circle(radius) => s"A circle with radius $radius"
        case Rectangle(width, height) => s"A rectangle with width $width and height $height"
        case Triangle(base, height) => s"A triangle with base $base and height $height"
        case UnknownShape => "An unknown shape"
      }
      println(description)
    }
  }
}
