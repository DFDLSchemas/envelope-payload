name := "dfdl-envelope-payload"

organization := "io.github.dfdlschemas"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.18"

retrieveManaged := true

useCoursier := false // required for retrieveManaged to work so that lib_managed gets populated

libraryDependencies ++= Seq(
  "io.github.dfdlschemas" % "dfdl-tcpmessage" % "0.1.0-SNAPSHOT",
  "com.owlcyberdefense" % "dfdl-mil-std-2045" % "1.3.2",
  "com.tresys" % "dfdl-pcap" % "1.3.0",
  "com.github.sbt" % "junit-interface" % "0.13.3" % "test",
  "junit" % "junit" % "4.13.2" % "test",
  "org.apache.daffodil" %% "daffodil-tdml-processor" % "3.6.0" % "test"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

crossPaths := false
