package com.ambiata.disorder

import org.scalacheck._
import scala.io.Codec

object Arbitraries {
  implicit def CodecArbitrary: Arbitrary[Codec] = Arbitrary(Gen.oneOf(
      Codec.UTF8
    , Codec.ISO8859
  ))
}
