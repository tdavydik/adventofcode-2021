package adventofcode.day3

import adventofcode.Problem

object Part1 extends Problem {

  override def solution() = {
    val l = 12
    val lines = inputLines()
    val total = inputLines().length
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

  }
}
