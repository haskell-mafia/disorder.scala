package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}
import scala.io.Codec


class EncodingStringSpec extends Specification with ScalaCheck { def is = s2"""

  EncodingString properties are met:
    ${ prop((s: EncodingString) => Codec(s.codec.name).name ==== s.codec.name) }
    ${ prop((s: EncodingString) => new String(s.value.getBytes(s.codec.name), s.codec.name) ==== s.value) }

"""
}
