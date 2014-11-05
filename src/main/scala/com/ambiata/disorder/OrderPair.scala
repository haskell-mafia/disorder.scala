package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._

case class OrderedPair[A](first: A, second: A)

object OrderedPair {
  implicit def OrderedPairArbitrary[A: Arbitrary: Order]: Arbitrary[OrderedPair[A]] =
    Arbitrary(for {
      a <- arbitrary[A]
      b <- arbitrary[A]
    } yield if (a < b) OrderedPair(a, b) else OrderedPair(b, a))
}
