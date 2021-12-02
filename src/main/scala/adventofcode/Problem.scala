package adventofcode

import scala.collection.Iterator
import scala.io.{BufferedSource, Source}

trait Problem extends App {
  def inputLines(): Iterator[String] = {
    val dayR = raw".+\.(\w+)\..+".r
    val day = getClass.getCanonicalName match {case dayR(day) => day}
    val source: BufferedSource = Source.fromResource(s"adventofcode/$day/input")
    source.getLines()
  }

  def inputInts(): Iterator[Int] = {
    inputLines().map(_.toInt)
  }

  def solution(): Any

  println(solution())
}
