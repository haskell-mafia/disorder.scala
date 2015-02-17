package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}
import scala.io.Codec
import Arbitraries._

class ArbitrarySpec extends Specification with ScalaCheck { def is = s2"""

  Codec arbitrary is consistent:
    ${ prop((c: Codec) => Codec(c.name).name ==== c.name) }

"""
}
