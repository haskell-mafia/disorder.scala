package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._
import GenPlus._

/**
  Conforms the same properties specified by 'com.ambiata.disorder.S'
  with the addition constraint of having no new line characters.
  */
case class N(value: String)

object N {

  val newlines: List[Char] = List('\n', '\r', 0x000B, 0x000C, 0x0085, 0x2028, 0x2029)

  implicit def NArbitrary: Arbitrary[N] =
    Arbitrary(for {
      a <- arbitrary[S]
      c <- checkGen[Char](arbitrary[Char], "Char", x => !newlines.contains(x))
    } yield N(newlines.foldLeft(a.value)({ case (b, a) => b.replace(a, c) })))
}
