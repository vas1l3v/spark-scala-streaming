package kafka

import org.apache.spark.sql.Encoders

object KafkaHelper {
  val topicName = "TestTopic"

  val bootstrapServers = "localhost:9092"

  //case class to describe data coming from kafka
  case class Game(match_id: Int,
                  team1: String,
                  team2: String,
                  team1_goals: Int,
                  team2_goals: Int,
                  minutes: Int,
                  seconds: Int
                 )
  val gameSchema = Encoders.product[Game].schema
}
