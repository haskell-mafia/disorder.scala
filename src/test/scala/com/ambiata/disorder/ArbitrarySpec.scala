package com.ambiata.disorder

import com.ambiata.disorder.Arbitraries._
import org.specs2.{ScalaCheck, Specification}

import scala.io.Codec

class ArbitrarySpec extends Specification with ScalaCheck { def is = s2"""

  Codec arbitrary is consistent:
    ${ prop((c: Codec) => Codec(c.name).name ==== c.name) }

"""
}
