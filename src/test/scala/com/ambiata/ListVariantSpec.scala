package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class ListVariantSpec extends Specification with ScalaCheck { def is = s2"""

  Lower bounds are met:

    ${ prop((x: NonEmptyList10[Int]) => x.value.size >= 1) }
    ${ prop((x: NonEmptyList100[Int]) => x.value.size >= 1) }
    ${ prop((x: NonEmptyList1000[Int]) => x.value.size >= 1) }

  Upper bounds are met:

    ${ prop((x: List10[Int]) => x.value.size <= 10) }
    ${ prop((x: List100[Int]) => x.value.size <= 100) }
    ${ prop((x: List1000[Int]) => x.value.size <= 1000) }
    ${ prop((x: NonEmptyList10[Int]) => x.value.size <= 10) }
    ${ prop((x: NonEmptyList100[Int]) => x.value.size <= 100) }
    ${ prop((x: NonEmptyList1000[Int]) => x.value.size <= 1000) }

  Constraints are met:

    ${ prop((x: DistinctList[Int]) => x.value.toSet.toList == x) }

"""
}
