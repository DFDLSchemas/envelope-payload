name := "dfdl-envelope-payload"

organization := "io.github.dfdlschemas"

version := "1.0.0"

libraryDependencies ++= Seq(
  "io.github.dfdlschemas" % "dfdl-tcpmessage" % "1.0.0",
  "com.owlcyberdefense" % "dfdl-mil-std-2045" % "1.3.2",
  "com.tresys" % "dfdl-pcap" % "1.4.0",
)

enablePlugins(DaffodilPlugin)
