package kafka

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.from_json
import spark.SparkHelper

object KafkaSource {
  private val spark = SparkHelper.getSparkSession()

  import spark.implicits._

  def readKafkaStream(startingOption: String = "startingOffsets", partitionsAndOffsets: String = "latest"): DataFrame = {
    spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", KafkaHelper.bootstrapServers)
      .option("subscribe", KafkaHelper.topicName)
      .option("enable.auto.commit", false)
      .option(startingOption, partitionsAndOffsets)
      .load()
      .select($"value".cast("string"))
      .select(from_json($"value", KafkaHelper.gameSchema).alias("value")) //parse json coming from kafka
      .select("value.*")
  }
}
