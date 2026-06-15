val root = (project in file("."))
  .settings(
    name := "dfdl-envelope-payload",
    organization := "io.github.dfdlschemas",
    version := "1.1.1",

    libraryDependencies ++= Seq(
      "io.github.dfdlschemas" % "dfdl-tcpmessage" % "1.2.0",
      "com.owlcyberdefense" % "dfdl-mil-std-2045" % "1.3.3",
      ("com.owlcyberdefense" % "dfdl-ethernetip" % "1.5.0").daffodilPlugin(daffodilVersion.value),
      "com.tresys" % "dfdl-pcap" % "1.4.1" // if updated past 1.4.0, revisit the warning suppression in config.xml file.
    ),

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
    },

    daffodilTdmlUsesPackageBin := true
  )
  .daffodilProject(crossDaffodilVersions = Seq("4.0.0"))
