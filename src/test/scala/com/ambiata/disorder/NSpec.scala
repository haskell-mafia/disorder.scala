package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class NSpec extends Specification with ScalaCheck { def is = s2"""

  N properties are met:

    ${ prop((n: N) => n.value.contains('\n') ==== false) }

    ${ prop((n: N) => n.value.contains('\r') ==== false) }

"""
}
