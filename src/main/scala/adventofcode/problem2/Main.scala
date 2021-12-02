package adventofcode.problem2

import adventofcode.Problem

object Main extends Problem {
  override lazy val problem = "problem2"

  override def solution() = {
    val movement = raw"(\w+)\s(\d+)".r
    val res = inputLines().foldLeft((0, 0))((coords, line) => (coords, line) match {
      case ((x, y), movement(dest, v)) =>
        val d = v.toInt
        dest match {
          case "forward" => (x + d, y)
          case "down" => (x, y + d)
          case "up" => (x, y - d)
          case _ => (x, y)
        }
      case _ => coords
    })
    res._1 * res._2
  }
}

case class Point(x: Int, y: Int)
