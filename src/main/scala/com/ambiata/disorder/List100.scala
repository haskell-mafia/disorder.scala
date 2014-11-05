package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class List100[A](value: List[A])

object List100 {
  implicit def List100Arbitrary[A: Arbitrary]: Arbitrary[List100[A]] =
    Arbitrary(for {
      n <- choose(0, 100)
      l <- listOfN(n, arbitrary[A])
    } yield l)
}
