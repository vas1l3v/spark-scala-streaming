package kafka

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.streaming.StreamingQuery

object KafkaSink {
  def loadStreamToHDFS(dfInputStream: DataFrame): StreamingQuery = {
    dfInputStream
      .writeStream
      .queryName("Load kafka stream to sink delta table")
      .outputMode("append")
      .format("delta")
      .option("checkpointLocation", "hdfs://localhost:9000/streams/games/_checkpoints")
      .option("path", "hdfs://localhost:9000/streams/games")
      .start()
  }

  def debugStream(dfInputStream: DataFrame): StreamingQuery = {
    dfInputStream
      .writeStream
      .queryName("Debug stream from kafka")
      .format("console")
      .start()
  }
}
