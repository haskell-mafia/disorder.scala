package com.ambiata.disorder

import org.scalacheck.Gen
import org.specs2.{ScalaCheck, Specification}

class GenPlusSpec extends Specification with ScalaCheck { def is = s2"""

   chooseInt is always within the range     $chooseInt
   chooseLong is always within the range    $chooseLong
   List of sized is always within the range $listOfSized
   List of sized with index increments by 1 $listOfSizedWithIndex
   Non empty list is never empty            $nonEmptyListOf
   Smaller reduces the size                 $smaller

"""

  def chooseInt = prop { p: (OrderedPair[NaturalIntSmall]) =>
    val gen = GenPlus.chooseInt(p.first.value, p.second.value)
    val l = gen(Gen.Parameters.default).get
    l must beGreaterThanOrEqualTo(p.first.value) and (l must beLessThanOrEqualTo(p.second.value))
  }

  def chooseLong = prop { p: (OrderedPair[NaturalLongSmall]) =>
    val gen = GenPlus.chooseLong(p.first.value, p.second.value)
    val l = gen(Gen.Parameters.default).get
    l must beGreaterThanOrEqualTo(p.first.value) and (l must beLessThanOrEqualTo(p.second.value))
  }

  def listOfSized = prop { p: (OrderedPair[NaturalIntSmall]) =>
    val l = GenPlus.listOfSized(p.first.value, p.second.value, Gen.const(""))(Gen.Parameters.default)
    l.get.size must beGreaterThanOrEqualTo(p.first.value) and (l.get.size must beLessThanOrEqualTo(p.second.value))
  }

  def listOfSizedWithIndex = prop { p: (OrderedPair[NaturalIntSmall]) =>
    val l = GenPlus.listOfSizedWithIndex(p.first.value, p.second.value, Gen.const)(Gen.Parameters.default).get
    l ==== (0 until l.size).toList
  }

  def nonEmptyListOf =
    GenPlus.nonEmptyListOf(Gen.const(""))(Gen.Parameters.default).map(!_.isEmpty) ==== Some(true)

  def smaller = prop { p : PositiveInt =>
    GenPlus.smaller(Gen.size)(Gen.Parameters.default.withSize(p.value)).get must beLessThan(p.value)
  }
}
