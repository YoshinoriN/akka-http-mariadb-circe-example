import sbt.util

logLevel := util.Level.Warn

addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
