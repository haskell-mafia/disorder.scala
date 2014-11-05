package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NonEmptyList10[A](head: A, tail: List[A]) {
  def value: List[A] = h :: tail
}

object NonEmptyList10 {
  implicit def NonEmptyList10Arbitrary[A: Arbitrary]: Arbitrary[NonEmptList10[A]] =
    Arbitrary(for {
      n <- choose(0, 9)
      h <- arbitrary[A]
      t <- listOfN(n, arbitrary[A])
    } yield NonEmptyList10(h, t))
}
