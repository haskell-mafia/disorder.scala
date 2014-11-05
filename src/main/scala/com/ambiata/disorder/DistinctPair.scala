package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._

case class DistinctPair[A](first: A, second: A)

object DistinctPair {
  implicit def DistinctPairArbitrary[A: Arbitrary]: Arbitrary[DistinctPair[A]] =
    Arbitrary(for {
      a <- arbitrary[A]
      b <- arbitrary[A]
      r <- if (a != b) Gen.const(DistinctPair[A](a, b)) else arbitrary[DistinctPair[A]]
    } yield r)
}
