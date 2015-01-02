package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._

case class DistinctPair[A](first: A, second: A)

object DistinctPair {
  implicit def DistinctPairArbitrary[A: Arbitrary]: Arbitrary[DistinctPair[A]] =
    Arbitrary(pair(0))

  def pair[A: Arbitrary](n: Int): Gen[DistinctPair[A]] = {
    if (n > 100) Gen.fail.label("Couldn't generate a DistinctPair")
    else for {
      a <- arbitrary[A]
      b <- arbitrary[A]
      z <- Gen.size
      r <- if (a != b) Gen.const(DistinctPair[A](a, b)) else Gen.resize(z + 1, pair[A](n + 1))
    } yield r
  }
}
