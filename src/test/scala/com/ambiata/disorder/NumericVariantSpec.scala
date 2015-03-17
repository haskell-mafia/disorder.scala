package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class NumericVariantSpec extends Specification with ScalaCheck { def is = s2"""

  Ranges are met:

    ${ prop((x: NaturalLong) => x.value >= 0) }
    ${ prop((x: NaturalInt) => x.value >= 0) }
    ${ prop((x: NaturalLongSmall) => x.value >= 0 && x.value <= 10).set(maxSize = 10) }
    ${ prop((x: NaturalIntSmall) => x.value >= 0 && x.value <= 10).set(maxSize = 10) }

    ${ prop((x: PositiveLong) => x.value >= 1) }
    ${ prop((x: PositiveInt) => x.value >= 1) }
    ${ prop((x: PositiveLongSmall) => x.value >= 1 && x.value <= 10).set(maxSize = 10) }
    ${ prop((x: PositiveIntSmall) => x.value >= 1 && x.value <= 10).set(maxSize = 10) }

  Alias works:

    ${ prop((x: Natural) => x.value >= 0) }
    ${ prop((x: Positive) => x.value >= 1) }

"""
}
