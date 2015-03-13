package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class NSpec extends Specification with ScalaCheck { def is = s2"""

  N properties are met:

    ${ prop((n: N) => n.value.contains('\n') ==== false) }

    ${ prop((n: N) => n.value.contains('\r') ==== false) }

    ${ prop((n: N) => n.value.contains(0x000B) ==== false) }

    ${ prop((n: N) => n.value.contains(0x000C) ==== false) }

    ${ prop((n: N) => n.value.contains(0x0085) ==== false) }

    ${ prop((n: N) => n.value.contains(0x2028) ==== false) }

    ${ prop((n: N) => n.value.contains(0x2029) ==== false) }

"""
}
