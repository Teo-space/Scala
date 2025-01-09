ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.2"

lazy val root = (project in file("."))
    .settings(
        name := "Scala",
        libraryDependencies ++= Seq(
            "org.playframework" %% "play-json" % "3.0.4",
            "io.github.mutsuhiro6" % "ulid-scala3_3" % "1.0.0",
            "com.github.nscala-time" %% "nscala-time" % "2.32.0"
        )
    )
