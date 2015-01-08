package com.ambiata.disorder

import org.scalacheck._
import scalaz._, Scalaz._

case class NaturalIntSmall(value: Int)

object NaturalIntSmall {

  implicit def NaturalIntSmallArbitrary: Arbitrary[NaturalIntSmall] =
    Arbitrary(Gen.sized(n => Gen.choose(1, math.max(1, n))).map(NaturalIntSmall.apply))

  implicit def NaturalIntSmallOrder: Order[NaturalIntSmall] = new Order[NaturalIntSmall] {
    def order(a: NaturalIntSmall, b: NaturalIntSmall) = implicitly[Order[Int]].order(a.value, b.value)
  }
}
