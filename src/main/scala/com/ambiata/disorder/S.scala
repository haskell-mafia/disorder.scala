package com.ambiata.disorder

import org.scalacheck._, Arbitrary._, Gen._
import scalaz._, Scalaz._


/**
  This is replace the use of `Arbtirary[String]` which should allow
  for a better spread of test cases apart from the general empty
  string and unicode characters that are generally associated with
  `Arbitrary[String]`.
  */
case class S(value: String)

object S {

  implicit def SArbitrary: Arbitrary[S] =
    Arbitrary(for {
      v <- Gen.sized(i =>
        if (i < 2) Gen.frequency(50 -> emptyString, 50 -> specialChar)
        else if (i >= 2 && i < 10) Gen.frequency(2-> emptyString, 3 -> specialChar, 5 -> random, 10 -> sentences, 80 -> words)
        else if  (i >= 10 && i < 20) Gen.frequency(50 -> random, 25 -> sentences, 25 -> words)
        else arbitrary[String]
      )
    } yield S(v))

  def emptyString: Gen[String] =
    Gen.const("")

  def specialChar: Gen[String] =
    Gen.oneOf("\n", "\\", "\t", "\uD83D\uDCA9")

  def random: Gen[String] =
    arbitrary[List[Char]] map (_.mkString)

  def words: Gen[String] = for {
    l <- Gen.oneOf(languages)
    d <- Gen.oneOf(delimeters)
    f <- Gen.oneOf(descriptions)
    t <- Gen.oneOf(terminators)
  } yield l + d + f + t

  def sentences: Gen[String] = Gen.sized(i => for {
    l <- Gen.choose(2, math.max(3, i))
    w <- Gen.listOfN(i, words)
  } yield w.mkString(" "))

  val delimeters = List("/", "|", ",", ".", "\n", "\t", "\\", "-", "_", "`",  "~", "^")
  val terminators = List("!", ".")

  val languages =  List(
      "Agda"
    , "Axum"
    , "Batch"
    , "C"
    , "C#"
    , "C++"
    , "Cobol"
    , "Delphi"
    , "F#"
    , "Lisp"
    , "Hack"
    , "Haskell"
    , "Java"
    , "Julia"
    , "Python"
    , "R"
    , "Sed"
    , "WebQL"
    , "Zeno"
  )

  val descriptions = List(
      "Noob"
    , "Novice"
    , "Rookie"
    , "Beginner"
    , "Talented"
    , "Skilled"
    , "Intermediate"
    , "Skillful"
    , "Seasoned"
    , "Proficient"
    , "Experienced"
    , "Advanced"
    , "Senior"
    , "Expert"
  )




}
