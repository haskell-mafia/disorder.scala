package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class NumericVariantSpec extends Specification with ScalaCheck { def is = s2"""

  Ranges are met:

    ${ prop((x: NaturalLong) => x.value >= 0) }
    ${ prop((x: NaturalInt) => x.value >= 0) }

  Alias works:

    ${ prop((x: Natural) => x.value >= 0) }

"""
}
