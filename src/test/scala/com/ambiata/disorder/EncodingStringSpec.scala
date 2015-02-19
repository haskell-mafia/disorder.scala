package com.ambiata.disorder

import org.specs2.{ScalaCheck, Specification}
import scala.io.Codec
import EncodingString._


class EncodingStringSpec extends Specification with ScalaCheck { def is = s2"""

  EncodingString properties are met:

    ${ prop((s: EncodingS) => Codec(s.codec.name).name ==== s.codec.name) }

    ${ prop((s: EncodingS) => new String(s.value.getBytes(s.codec.name), s.codec.name) ==== s.value) }

    ${ prop((e: EncodingListS) => e.value.map(s =>
         new String(s.getBytes(e.codec.name), e.codec.name)) ==== e.value) }

    ${ prop((s: EncodingN) => new String(s.value.getBytes(s.codec.name), s.codec.name) ==== s.value) }

    ${ prop((s: EncodingN) => s.value.contains('\n') ==== false) }

    ${ prop((s: EncodingN) => s.value.contains('\r') ==== false) }

    ${ prop((s: EncodingListN) => s.value.filterNot(_.contains('\n')).length ==== s.value.length) }

"""
}
