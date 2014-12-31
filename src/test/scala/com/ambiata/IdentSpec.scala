package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class IdentSpec extends Specification with ScalaCheck { def is = s2"""

  Bounds are met:
    ${ prop((x: Ident) => x.value.forall(c => c.isLetterOrDigit || c == '_')) }

"""
}
