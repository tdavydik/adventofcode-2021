package adventofcode.day3

import adventofcode.Problem

import scala.annotation.tailrec

object Part1 extends Problem {

  override def solution() = {
    val l = 12
    val lines = inputLines()
    val total = lines.length
    val a = lines.foldLeft(Array.fill(l) {
      0
    })((bs, line) => {
      for (i <- 0 until l) {
        val v = line(i) match {
          case '1' => 1
          case _ => 0
        }
        bs(i) += v
      }
      bs
    })
      .fold(0)((v: Int, next: Int) => {
        val bit = next match {
          case _ if next >= total / 2 => 1
          case _ => 0
        }
        (v << 1) | bit
      }
    )
    val x = Math.pow(2, l) - 1
    a * (a ^ x.toInt)
  }
}

object Part2 extends Problem {

  override def solution() = {
    val l = 12
    val lines = inputLines()

    lazy val oxy = filterOut(lines, 0, mostCommon = true)
    lazy val co2 = filterOut(lines, 0, mostCommon = false)

    @tailrec
    def filterOut(input: Seq[String], index: Int, mostCommon: Boolean): Seq[String] = {
      if (index < l && input.size > 1)
        filterOut(input.filterByBit(index, input.detectBit(index, mostCommon)), index + 1, mostCommon)
      else
        input
    }
    Integer.parseInt(oxy.head, 2) * Integer.parseInt(co2.head, 2)
  }



  implicit class Filterable(arr: Seq[String]) {
    def filterByBit(index: Int, bit: Char): Seq[String] = {
      arr.filter(_.charAt(index) == bit)
    }

    def detectBit(index:Int, mostCommon: Boolean): Char = {
      val seq1 = arr.groupBy(_.charAt(index)).map {
        case (bit, seq) => (bit, seq.length)
      }.toSeq
      seq1.sortWith((kv1, kv2) => kv1._2 - kv2._2 match {
        case x if x < 0 => if (mostCommon) false else true
        case x if x > 0 => if (mostCommon) true else false
        case _ if mostCommon => kv1._1 == '1'
        case _ => kv1._1 == '0'
      }).head._1
    }
  }
}


