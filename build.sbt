name := "Uzbekistan"

version := "1.0"

lazy val `uzbekistan` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"





unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
