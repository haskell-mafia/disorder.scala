package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class NonEmptyStringSpec extends Specification with ScalaCheck { def is = s2"""

  Bounds are met:
    ${ prop((x: NonEmptyString) => x.value.length >= 1) }
    ${ prop((x: NonEmptyString) => x.value != "") }

"""
}
