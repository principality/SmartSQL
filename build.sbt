name := "SmartSQL"

organization := "me.principality"

version := "0.1"

scalaVersion := "2.12.4"

val akkaVersion = "2.5.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
)