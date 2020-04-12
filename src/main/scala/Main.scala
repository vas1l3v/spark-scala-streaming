import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoders, SparkSession}
import io.delta.tables._
import org.apache.spark.sql.functions.col
import spark.SparkHelper
import kafka.{KafkaHelper, KafkaSink, KafkaSource}

//job entry
object Main extends App{
  val spark = SparkHelper.getAndConfigureSparkSession()
  //spark.read.csv("hdfs://localhost:9000/source/fifa/players.2019.csv").show

  val dfKafkaStream = KafkaSource.readKafkaStream()
  KafkaSink.loadStreamToHDFS(dfKafkaStream)
  KafkaSink.debugStream(dfKafkaStream)

  spark.streams.awaitAnyTermination()

}
