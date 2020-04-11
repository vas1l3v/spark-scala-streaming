import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoders, SparkSession}
import io.delta.tables._
import org.apache.spark.sql.functions.col
import spark.SparkHelper
import kafka.{KafkaHelper, KafkaSink, KafkaSource}

//job entry
object Main extends App{
  val spark = SparkHelper.getAndConfigureSparkSession()

  val kafkaStream = KafkaSource.readKafkaStream()
  KafkaSink.debugStream(kafkaStream)

  spark.streams.awaitAnyTermination()

}
