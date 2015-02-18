package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._
import GenPlus._

case class DistinctPair[A](first: A, second: A)

object DistinctPair {
  implicit def DistinctPairArbitrary[A: Arbitrary]: Arbitrary[DistinctPair[A]] =
    Arbitrary(checkGenTuple[DistinctPair[A], A, A](
        (a, b) => DistinctPair[A](a, b)
      , "DistinctPair"
      , dp => dp.first != dp.second))
}
