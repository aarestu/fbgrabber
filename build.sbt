name := "facebook"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "io.spray" %%  "spray-json" % "1.3.2",
  "net.liftweb" %% "lift-json" % "2.6"
)