name := "delta-streaming-example"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq( "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.apache.spark" %% "spark-yarn" % "2.4.5",
  "org.apache.spark" %% "spark-launcher" % "2.4.5",
  "org.apache.spark" %% "spark-hive" % "2.4.5" % "provided",

  //Delta lake library
  "io.delta" %% "delta-core" % "0.5.0",

  //kafka library
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.5",

  //Libraries needed for AWS S3 connectivity, all libraries here should be compatible versions
  "org.apache.hadoop" % "hadoop-common" % "3.1.0",
  "com.amazonaws" % "aws-java-sdk-bundle" % "1.11.271",
  "org.apache.hadoop" % "hadoop-aws" % "3.1.0"

)

//override dependency, hadoop-common works with different jackson dependency than spark-core
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7"

//specify main class
mainClass in (Compile, run) := Some("Main")