package adventofcode

import scala.collection.Iterator
import scala.io.{BufferedSource, Source}

trait Problem extends App {
  val day: Int

  def inputLines(): Iterator[String] = {
    val source: BufferedSource = Source.fromResource(s"adventofcode/day$day/input")
    source.getLines()
  }

  def inputInts(): Iterator[Int] = {
    inputLines().map(_.toInt)
  }

  def solution(): Any

  println(solution())
}
