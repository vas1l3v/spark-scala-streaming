package kafka

import org.apache.spark.sql.types.{LongType, StringType, StructType}
import spark.SparkHelper

object KafkaHelper {

  val topicName = "TestTopic"

  val bootstrapServers = "localhost:9092"

  // TODO
  val schemaOutput = new StructType()
}
