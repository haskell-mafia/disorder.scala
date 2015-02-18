package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._
import GenPlus._
import S._

/**
  This is a list of 'String' where there is no new
  line characters.
  */
case class ListS(value: List[String])

object ListS {
  implicit def ListSArbitrary: Arbitrary[ListS] =
    Arbitrary(for {
      a <- arbitrary[List[S]]
      c <- checkGen[Char](arbitrary[Char], "Char", _ != '\n')
    } yield ListS(a.map(_.value.replace('\n', c))))
}
