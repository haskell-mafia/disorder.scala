package com.ambiata.disorder

import org.scalacheck._
import scalaz._, Scalaz._

case class NaturalLongSmall(value: Long)

object NaturalLongSmall {

  implicit def NaturalLongSmallArbitrary: Arbitrary[NaturalLongSmall] =
    Arbitrary(GenPlus.chooseLong(0l, Long.MaxValue).map(NaturalLongSmall.apply))

  implicit def NaturalLongSmallOrder: Order[NaturalLongSmall] = new Order[NaturalLongSmall] {
    def order(a: NaturalLongSmall, b: NaturalLongSmall) = implicitly[Order[Long]].order(a.value, b.value)
  }
}
