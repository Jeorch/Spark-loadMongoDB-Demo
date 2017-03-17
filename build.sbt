name := "dongda-service"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-agent" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-camel" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-cluster-metrics" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-contrib" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-multi-node-testkit" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-osgi" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-persistence" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-persistence-tck" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-typed-experimental" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.16"
//libraryDependencies += "com.typesafe.akka" %% "akka-http-core" % "10.0.1"
//libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.1"
//libraryDependencies += "com.typesafe.akka" %% "akka-http-jackson" % "10.0.1"
//libraryDependencies += "com.typesafe.akka" %% "akka-http-xml" % "10.0.1"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"
