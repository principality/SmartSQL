name := "SmartSQL"

organization := "me.principality"

version := "0.1"

scalaVersion := "2.12.4"

val akkaVersion = "2.5.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe" % "config" % "1.3.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.8.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scodec" %% "scodec-bits" % "1.1.5",
  "org.scodec" %% "scodec-core" % "1.10.3",
  "org.apache.calcite" % "calcite-core" % "1.16.0",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.3",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",
  "org.specs2" %% "specs2-core" % "4.0.2" % Test,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)