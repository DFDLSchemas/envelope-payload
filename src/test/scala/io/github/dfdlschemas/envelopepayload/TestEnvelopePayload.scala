package io.github.dfdlschemas.envelopepayload

import org.junit.AfterClass
import org.junit.Test

import org.apache.daffodil.tdml.Runner

object TestEnvelopePayload {
  lazy val runner = Runner("/io/github/dfdlschemas/envelopepayload/", "TestEnvelopepayload.tdml")

  @AfterClass def shutDown: Unit = {
    runner.reset
  }
}

class TestEnvelopePayload {

  import TestEnvelopePayload._

  @Test def test_envelopepayload_01(): Unit = { runner.runOneTest("test_envelopepayload_01") }
  @Test def test_envelopepayload_02(): Unit = { runner.runOneTest("test_envelopepayload_02") }

}
