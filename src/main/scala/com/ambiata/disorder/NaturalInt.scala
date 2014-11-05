package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NaturalInt(value: Int)

object NaturalInt {
  implicit def NaturalIntArbitrary: Arbitrary[NaturalInt] =
    Arbitrary(choose(0, Int.MaxValue).map(NaturalInt.apply))
}
