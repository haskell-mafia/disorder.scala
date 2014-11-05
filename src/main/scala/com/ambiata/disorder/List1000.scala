package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class List1000[A](value: List[A])

object List1000 {
  implicit def List1000Arbitrary[A: Arbitrary]: Arbitrary[List1000[A]] =
    Arbitrary(for {
      n <- choose(0, 1000)
      l <- listOfN(n, arbitrary[A])
    } yield l)
}
