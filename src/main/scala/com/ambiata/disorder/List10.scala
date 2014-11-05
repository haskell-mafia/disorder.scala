package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class List10[A](value: List[A])

object List10 {
  implicit def List10Arbitrary[A: Arbitrary]: Arbitrary[List10[A]] =
    Arbitrary(for {
      n <- choose(0, 10)
      l <- listOfN(n, arbitrary[A])
    } yield l)
}
