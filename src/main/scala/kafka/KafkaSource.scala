package kafka

import org.apache.spark.sql.DataFrame
import spark.SparkHelper

object KafkaSource {
  private val spark = SparkHelper.getSparkSession()

  import spark.implicits._

  def readKafkaStream(startingOption: String = "startingOffsets", partitionsAndOffsets: String = "earliest"): DataFrame = {
    spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", KafkaHelper.bootstrapServers)
      .option("subscribe", KafkaHelper.topicName)
      .option("enable.auto.commit", false)
      .option(startingOption, partitionsAndOffsets)
      .load()
      .selectExpr("CAST(key as STRING)", "CAST(value as STRING)")
  }
}
