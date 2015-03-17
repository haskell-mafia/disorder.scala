package com.ambiata.disorder

import org.scalacheck._, Gen._

case class PositiveInt(value: Int)

object PositiveInt {
  implicit def PositiveIntArbitrary: Arbitrary[PositiveInt] =
    Arbitrary(choose(1, Int.MaxValue).map(PositiveInt.apply))
}
