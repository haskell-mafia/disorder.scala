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
  implicit def NArbitrary: Arbitrary[N] =
    Arbitrary(for {
      a <- arbitrary[S]
      c <- checkGen[Char](arbitrary[Char], "Char", _ != '\n')
    } yield N(a.value.replace('\n', c)))
}
