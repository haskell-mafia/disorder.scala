package com.ambiata.disorder

import org.scalacheck._
import scalaz._, Scalaz._

case class NaturalIntSmall(value: Int)

object NaturalIntSmall {

  implicit def NaturalIntSmallArbitrary: Arbitrary[NaturalIntSmall] =
    Arbitrary(GenPlus.chooseInt(0, Int.MaxValue).map(NaturalIntSmall.apply))

  implicit def NaturalIntSmallOrder: Order[NaturalIntSmall] = new Order[NaturalIntSmall] {
    def order(a: NaturalIntSmall, b: NaturalIntSmall) = implicitly[Order[Int]].order(a.value, b.value)
  }
}
