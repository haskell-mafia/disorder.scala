package com.ambiata.disorder

import org.scalacheck._, Gen._

case class PositiveLong(value: Long)

object PositiveLong {
  implicit def PositiveLongArbitrary: Arbitrary[PositiveLong] =
    Arbitrary(choose(1l, Long.MaxValue).map(PositiveLong.apply))
}
