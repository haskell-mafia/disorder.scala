package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scala.io.Codec
import scalaz._, Scalaz._
import Arbitraries._
import GenPlus._

/**
  Produce a string which is valid for the associated codec
  */
case class EncodingString(value: String, codec: Codec)

object EncodingString {
  implicit def EncodingStringArbitrary: Arbitrary[EncodingString] =
    Arbitrary(checkGenTuple[EncodingString, S, Codec](
        (s, c) => EncodingString(s.value, c)
      , "EncodingString"
      , es => validForCodec(es.value, es.codec)))

  def validForCodec(s: String, c: Codec): Boolean =
    new String(s.getBytes(c.name), c.name) == s
}
