package adventofcode.day2

import adventofcode.Problem

object Part1 extends Problem {

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

object Part2 extends Problem {

  override def solution() = {
    val movement = raw"(\w+)\s(\d+)".r
    val res = inputLines().foldLeft((0, 0, 0))((coords, line) => (coords, line) match {
      case ((aim, x, y), movement(dest, v)) =>
        val d = v.toInt
        dest match {
          case "forward" => (aim, x + d, y + aim * d)
          case "down" => (aim + d, x, y)
          case "up" => (aim - d, x, y)
          case _ => (aim, x, y)
        }
      case _ => coords
    })
    res._2 * res._3
  }
}
