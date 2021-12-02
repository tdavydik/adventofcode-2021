package adventofcode.day1
import adventofcode.Problem

object Part1 extends Problem {
  override lazy val day = 1

  override def solution() = {
    inputInts().sliding(2).map(_.toList).map {
      case prev :: next :: Nil => if (next > prev) 1 else 0
      case _ => 0
    }.sum
  }
}

object Part2 extends Problem {
  override lazy val day = 1

  override def solution() = {
    inputInts().sliding(4).foldLeft(0)((sum, w) => w match {
      case _ if w(3) > w.head => sum + 1
      case _ => sum
    })
  }
}
