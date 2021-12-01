package adventofcode

import scala.collection.Iterator
import scala.io.{BufferedSource, Source}

trait Problem extends App {
  val problem: String

  def inputLines(): Iterator[String] = {
    val source: BufferedSource = Source.fromResource(s"adventofcode/$problem/input")
    source.getLines()
  }

  def inputInts(): Iterator[Int] = {
    inputLines().map(_.toInt)
  }

  def solution(): Any

  println(solution())
}
