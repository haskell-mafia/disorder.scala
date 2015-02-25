package com.ambiata.disorder

import org.scalacheck.Gen
import org.specs2.{ScalaCheck, Specification}

class GenPlusSpec extends Specification with ScalaCheck { def is = s2"""

   Choose is always within the range        $choose
   List of sized is always within the range $listOfSized
   Non empty list is never empty            $nonEmptyListOf

"""

  def choose = prop { p: (OrderedPair[NaturalIntSmall]) =>
    val l = GenPlus.choose(p.first.value, p.second.value)(Gen.Parameters.default).get
    l must beGreaterThanOrEqualTo(p.first.value) and (l must beLessThanOrEqualTo(p.second.value))
  }

  def listOfSized = prop { p: (OrderedPair[NaturalIntSmall]) =>
    val l = GenPlus.listOfSized(p.first.value, p.second.value, Gen.const(""))(Gen.Parameters.default)
    l.get.size must beGreaterThanOrEqualTo(p.first.value) and (l.get.size must beLessThanOrEqualTo(p.second.value))
  }

  def nonEmptyListOf =
    GenPlus.nonEmptyListOf(Gen.const(""))(Gen.Parameters.default).map(!_.isEmpty) ==== Some(true)
}
