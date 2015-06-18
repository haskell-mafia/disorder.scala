package com.ambiata.disorder

import org.scalacheck._, Arbitrary._
import scala.io.Codec

import scalaz._, Scalaz._, \&/._

object Arbitraries {
  implicit def CodecArbitrary: Arbitrary[Codec] = Arbitrary(Gen.oneOf(
      Codec.UTF8
    , Codec.ISO8859
  ))

  implicit def TheseArbitrary[A: Arbitrary, B: Arbitrary]: Arbitrary[A \&/ B] =
    Arbitrary(Gen.oneOf(arbitrary[A].map(This.apply), arbitrary[B].map(That.apply), arbitrary[A].flatMap(a => arbitrary[B].map(b => Both(a, b)))))
}
