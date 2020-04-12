package spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkHelper {
  def getAndConfigureSparkSession(): SparkSession = {
    val conf = new SparkConf()
      .setAppName("Structured Streaming to Delta Lake")
      .setMaster("local[*]")
      //.set("spark.delta.logStore.class", "org.apache.spark.sql.delta.storage.S3SingleDriverLogStore")
      .set("spark.delta.logStore.class", "org.apache.spark.sql.delta.storage.HDFSLogStore")

    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")
    // return spark session
    spark
  }

  def getSparkSession(): SparkSession = {
    SparkSession
      .builder()
      .getOrCreate()
  }
}
