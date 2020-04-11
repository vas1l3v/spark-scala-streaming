package kafka

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.streaming.StreamingQuery

class KafkaSink {
  def loadStreamToHDFS(dfInputStream: DataFrame): StreamingQuery = {
    dfInputStream
      .writeStream
      .queryName("Debug stream from kafka")
      .format("delta")
      .outputMode("append")
      .option("checkpointLocation", "delta path")
      .start("delta path")
  }

  def debugStream(dfInputStream: DataFrame): StreamingQuery = {
    dfInputStream
      .writeStream
      .queryName("Debug stream from kafka")
      .format("console")
      .start()
  }
}
