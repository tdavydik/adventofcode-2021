package adventofcode.problem1
import adventofcode.Problem

object Main extends Problem {
  override lazy val problem = "problem1"

  override def solution() = {
    inputInts().sliding(2).map(_.toList).map {
      case prev :: next :: Nil => if (next > prev) 1 else 0
      case _ => 0
    }.sum
  }
}
