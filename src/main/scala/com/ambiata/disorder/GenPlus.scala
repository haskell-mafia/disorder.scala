package com.ambiata.disorder

import org.scalacheck.Gen

object GenPlus {

  // The Gen version of this function results in too many discarded tests
  def nonEmptyListOf[A](gen: => Gen[A]): Gen[List[A]] =
    listOfSized(0, Int.MaxValue, gen)

  /**
   * A handy replacement for:
   *
   * {{{
   *   n <- Gen.choose(x, y)
   *   _ <- Gen.listOfN(n, ...)
   * }}}
   */
  def listOfSized[A](from: Int, to: Int, gen: => Gen[A]): Gen[List[A]] =
    Gen.sized(n => Gen.choose(from, Math.max(from, Math.min(n, to))).flatMap(i => Gen.listOfN(i, gen)))
}
