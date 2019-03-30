val Organization = "net.yoshinorin"
val Name = "akkahttpexample"
val version = "0.0.1"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

val circeVersion = "0.11.1"
val akkaVersion = "2.5.21"
val akkaHttpVersion = "10.1.8"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe" % "config" % "1.3.3",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "io.getquill" %% "quill-jdbc" % "3.1.0",
  "org.flywaydb" % "flyway-core" % "6.0.0-beta",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.4.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

scalafmtOnCompile := true
