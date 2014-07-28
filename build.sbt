import AssemblyKeys._
  
name := """akka-remote-joke"""

version := "1.0"

scalaVersion := "2.11.1"

assemblySettings

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.4"