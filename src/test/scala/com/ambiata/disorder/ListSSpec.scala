package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}

class ListSSpec extends Specification with ScalaCheck { def is = s2"""

  ListS properties are met:

    ${ prop((s: ListS) => s.value.filterNot(_.contains('\n')).length ==== s.value.length) }

"""
}
