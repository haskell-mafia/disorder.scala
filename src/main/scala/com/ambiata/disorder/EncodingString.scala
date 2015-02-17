package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scala.io.Codec
import scalaz._, Scalaz._
import Arbitraries._

/**
  Produce a string which is valid for the associated codec
  */
case class EncodingString(value: String, codec: Codec)

object EncodingString {
  implicit def EncodingStringArbitrary: Arbitrary[EncodingString] =
    Arbitrary(gen(0))

  def gen(n: Int): Gen[EncodingString] = {
    if (n > 100) Gen.fail.label("Couldn't generate a EncodingString")
    else for {
      s <- arbitrary[S]
      c <- arbitrary[Codec]
      z <- Gen.size
      r <- if (validForCodec(s, c)) Gen.const(EncodingString(s.value, c)) else Gen.resize(z + 1, gen(n + 1))
    } yield r
  }

  def validForCodec(s: S, c: Codec): Boolean =
    new String(s.value.getBytes(c.name), c.name) == s.value


}
