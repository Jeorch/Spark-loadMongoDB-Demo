import play.sbt.PlayScala

lazy val commonSettings = Seq(
    organization := "com.blackmirror",
    version := "3.0",
    scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
    jdbc,
    cache,
    ws,
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
//    "org.apache.spark" %% "spark-core" % "2.1.0",
//    "org.apache.spark" %% "spark-sql" % "2.1.0",
//    "org.mongodb.spark" %% "mongo-spark-connector" % "2.0.0"
//    "org.mongodb.scala" %% "mongo-driver" % "3.4.2",
//    "org.mongodb.scala" %% "mongo-scala-driver" % "1.0.1",
//    "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.1",
//    "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7",
//    "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7",
//    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.7",
    "org.mongodb.scala" %% "mongo-scala-driver" % "1.2.1",
    "org.mongodb.scala" %% "mongo-scala-bson" % "1.2.1",
    "org.mongodb.spark" %% "mongo-spark-connector" % "2.0.0",
    "org.apache.spark" %% "spark-core" % "2.0.0",
    "org.apache.spark" %% "spark-sql" % "2.0.0"
)

lazy val root = (project in file(".")).
    settings(commonSettings: _*).
    settings(
        name := "dongda-service",
        fork in run := true,
        javaOptions += "-Xmx5G"
    ).enablePlugins(PlayScala)
