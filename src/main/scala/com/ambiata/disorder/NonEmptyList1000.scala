package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._

case class NonEmptyList1000[A](head: A, tail: List[A]) {
  def value: List[A] = head :: tail
}

object NonEmptyList1000 {
  implicit def NonEmptyList1000Arbitrary[A: Arbitrary]: Arbitrary[NonEmptyList1000[A]] =
    Arbitrary(for {
      n <- choose(0, 9)
      h <- arbitrary[A]
      t <- listOfN(n, arbitrary[A])
    } yield NonEmptyList1000(h, t))
}
