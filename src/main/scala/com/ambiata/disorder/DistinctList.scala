package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._

case class DistinctList[A](value: List[A])

object DistinctList {
  implicit def DistinctListArbitrary[A: Arbitrary]: Arbitrary[DistinctList[A]] =
    Arbitrary(Gen.sized(n => for {
      seed <- Gen.listOfN(n * 2, arbitrary[A])
    } yield DistinctList(seed.toSet.toList.take(n))))
}
