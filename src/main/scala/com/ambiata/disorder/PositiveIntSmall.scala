package com.ambiata.disorder

import org.scalacheck._
import scalaz._, Scalaz._

case class PositiveIntSmall(value: Int)

object PositiveIntSmall {

  implicit def PositiveIntSmallArbitrary: Arbitrary[PositiveIntSmall] =
    Arbitrary(GenPlus.chooseInt(1, Int.MaxValue).map(PositiveIntSmall.apply))

  implicit def PositiveIntSmallOrder: Order[PositiveIntSmall] = new Order[PositiveIntSmall] {
    def order(a: PositiveIntSmall, b: PositiveIntSmall) = implicitly[Order[Int]].order(a.value, b.value)
  }
}
