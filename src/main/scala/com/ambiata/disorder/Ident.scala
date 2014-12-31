package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._

case class Ident(value: String)

object Ident {
  implicit def IdentArbitrary: Arbitrary[Ident] =
    Arbitrary(Gen.identifier.map(Ident.apply))
}
