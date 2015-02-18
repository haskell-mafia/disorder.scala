package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scala.io.Codec
import scalaz._, Scalaz._
import S._
import Arbitraries._
import GenPlus._

/**
  Produce a string which is valid for the associated codec
  'EncodingS' represents a String and a Codec where the String
  conforms to the properties specified by 'com.ambiata.disorder.S'.
  'EncodingN' also conforms to the properties specified by
  'com.ambaita.disorder.S' with the additional constraint of having
  no new line characters.
  */
case class EncodingS(value: String, codec: Codec)

case class EncodingListS(value: List[String], codec: Codec)

case class EncodingN(value: String, codec: Codec)

case class EncodingListN(value: List[String], codec: Codec)

object EncodingString {
  implicit def EncodingSArbitrary: Arbitrary[EncodingS] =
    Arbitrary(for {
      c <- arbitrary[Codec]
      s <- codecS(c)
    } yield EncodingS(s, c))

  implicit def EncodingListSArbitrary: Arbitrary[EncodingListS] =
    Arbitrary(for {
      c <- arbitrary[Codec]
      s <- codecListS(c)
    } yield EncodingListS(s, c))

  implicit def EncodingNArbitrary: Arbitrary[EncodingN] =
    Arbitrary(for {
      c <- arbitrary[Codec]
      s <- codecN(c)
    } yield EncodingN(s, c))

  implicit def EncodingListNArbitrary: Arbitrary[EncodingListN] =
    Arbitrary(for {
      c <- arbitrary[Codec]
      s <- codecListN(c)
    } yield EncodingListN(s, c))

  def codecListS(c: Codec): Gen[List[String]] =
    Gen.listOf(codecS(c))

  def codecS(c: Codec): Gen[String] = for {
    r <- checkGen[S](arbitrary[S], "EncodingS", s => validForCodec(s.value, c))
  } yield r.value

  def codecListN(codec: Codec): Gen[List[String]] =
    Gen.listOf(codecN(codec))

  def codecN(codec: Codec): Gen[String] = for {
    s <- arbitrary[S]
    c <- checkGen[Char](arbitrary[Char], "Char", _ != '\n')
    q <- s.map(_.value.replace('\n', c))
    r <- checkGen[String](Gen.const(q), "EncodingN", s => validForCodec(s, codec))
  } yield r

  def validForCodec(s: String, c: Codec): Boolean =
    new String(s.getBytes(c.name), c.name) == s
}
