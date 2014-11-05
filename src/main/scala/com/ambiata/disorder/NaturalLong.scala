package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NaturalLong(value: Long)

object NaturalLong {
  implicit def NaturalLongArbitrary: Arbitrary[NaturalLong] =
    Arbitrary(choose(0l, Long.MaxValue).map(NaturalLong.apply))
}
