package adventofcode

import scala.io.{BufferedSource, Source}

trait Problem extends App {
  def inputLines(): Seq[String] = {
    val dayR = raw".+\.(\w+)\..+".r
    val day = getClass.getCanonicalName match {case dayR(day) => day}
    val source: BufferedSource = Source.fromResource(s"adventofcode/$day/input")
    source.getLines().toSeq
  }

  def inputInts(): Seq[Int] = {
    inputLines().map(_.toInt)
  }

  def solution(): Any

  println(solution())
}
