package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NonEmptyString(value: String)

object NonEmptyString {
  implicit def NonEmptyStringArbitrary: Arbitrary[NonEmptyString] =
    Arbitrary(for {
      c <- arbitrary[Char]
      v <- arbitrary[S]
    } yield NonEmptyString(c.toString + v.value))
}
