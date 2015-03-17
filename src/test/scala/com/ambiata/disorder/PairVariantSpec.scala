package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

import scalaz._, Scalaz._

class PairVariantSpec extends Specification with ScalaCheck { def is = s2"""

  Constriants are met:

    ${ prop((x: OrderedPair[Int]) => x.first <= x.second) }
    ${ prop((x: DistinctPair[Int]) => x.first != x.second) }
    ${ prop((x: DistinctPair[String]) => x.first != x.second) }

"""
}
