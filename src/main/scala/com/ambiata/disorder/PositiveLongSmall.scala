package com.ambiata.disorder

import org.scalacheck._
import scalaz._, Scalaz._

case class PositiveLongSmall(value: Long)

object PositiveLongSmall {

  implicit def PositiveLongSmallArbitrary: Arbitrary[PositiveLongSmall] =
    Arbitrary(GenPlus.chooseLong(1l, Long.MaxValue).map(PositiveLongSmall.apply))

  implicit def PositiveLongSmallOrder: Order[PositiveLongSmall] = new Order[PositiveLongSmall] {
    def order(a: PositiveLongSmall, b: PositiveLongSmall) = implicitly[Order[Long]].order(a.value, b.value)
  }
}
