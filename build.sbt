name := "dfdl-envelope-payload"

organization := "io.github.dfdlschemas"

version := "1.1.0"

//
// Final assembly DFDL schemas should be setup to create a lib_managed baseDirectory
// This makes it easy to provide tools access to the required dependency jar files.
//
retrieveManaged := true

useCoursier := false // because of bug, retrieveManaged won't work without this


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
