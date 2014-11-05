package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NonEmptyList100[A](head: A, tail: List[A]) {
  def value: List[A] = head :: tail
}

object NonEmptyList100 {
  implicit def NonEmptyList100Arbitrary[A: Arbitrary]: Arbitrary[NonEmptyList100[A]] =
    Arbitrary(for {
      n <- choose(0, 9)
      h <- arbitrary[A]
      t <- listOfN(n, arbitrary[A])
    } yield NonEmptyList100(h, t))
}
