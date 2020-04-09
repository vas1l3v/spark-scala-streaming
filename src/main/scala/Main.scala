import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoders, SparkSession}
import io.delta.tables._
import org.apache.spark.sql.functions.col
import spark.SparkHelper

//job entry
object Main extends App{
  val spark = SparkHelper.getAndConfigureSparkSession()
  spark.sql("select 1").show

}
