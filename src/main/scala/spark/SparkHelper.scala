package spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkHelper {
  def getAndConfigureSparkSession() = {
    val conf = new SparkConf()
      .setAppName("Structured Streaming to Delta Lake")
      .setMaster("local[*]")
      .set("spark.delta.logStore.class", "org.apache.spark.sql.delta.storage.S3SingleDriverLogStore")

    val spark = SparkSession
      .builder()
      .config(conf)
      .getOrCreate()

    spark.sparkContext.setLogLevel("INFO")
    // return spark session
    spark
  }

  def getSparkSession() = {
    SparkSession
      .builder()
      .getOrCreate()
  }
}