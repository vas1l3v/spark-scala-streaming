name := "delta-streaming-example"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq( "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.apache.spark" %% "spark-yarn" % "2.4.5",
  "org.apache.spark" %% "spark-launcher" % "2.4.5",
  //Delta lake library
  "io.delta" %% "delta-core" % "0.5.0",

  //kafka library
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.5"
)

//specify main class
mainClass in (Compile, run) := Some("Main")