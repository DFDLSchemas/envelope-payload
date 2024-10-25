name := "dfdl-envelope-payload"

organization := "io.github.dfdlschemas"

version := "1.1.0"

daffodilVersion := "3.9.0"

libraryDependencies ++= Seq(
  "io.github.dfdlschemas" % "dfdl-tcpmessage" % "1.1.0",
  "com.owlcyberdefense" % "dfdl-mil-std-2045" % "1.3.2",
  "com.tresys" % "dfdl-pcap" % "1.4.0" // if updated past 1.4.0, revisit the warning suppression in config.xml file.
)

enablePlugins(DaffodilPlugin)

daffodilPackageBinVersions := Seq(daffodilVersion.value)

daffodilPackageBinInfos := {
  val configFile =
    (Compile / baseDirectory).value /"config.xml"
  Seq(
    DaffodilBinInfo(
      schema = "/io/github/dfdlschemas/envelopepayload/xsd/envelopePayload.dfdl.xsd",
      root = Some("message"),
      config = Some(configFile)
    )
  )
}

daffodilTdmlUsesPackageBin := true
