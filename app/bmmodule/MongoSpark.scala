package bmmodule

import com.mongodb.spark._
import org.bson.Document
import com.mongodb.spark.config._
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import javax.inject.Singleton

/**
  * Created by Alfred on 17/03/2017.
  */
@Singleton
class MongoDBSpark extends SparkContextManager {
    def queryUsers(range : Range) = users
    def queryProfiles(range : Range) = services
}

trait SparkContextManager {
    val conf = new SparkConf()
                    .setAppName("dongda-service")
//                    .setMaster("local[4]")
                    .setMaster("local")
                    .setJars("/home/jeorch/.ivy2/cache/org.mongodb.spark/mongo-spark-connector_2.11/jars/mongo-spark-connector_2.11-2.0.0.jar" ::
                             "/home/jeorch/.ivy2/cache/org.mongodb/mongo-java-driver/jars/mongo-java-driver-3.2.2.jar" ::  Nil)

    val sc = new SparkContext(conf)

    lazy val users = {
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://127.0.0.1/"
                                        , "spark.mongodb.input.database" -> "baby_time_test"
                                        , "spark.mongodb.input.collection" -> "users"
                                        , "readPreference.name" -> "secondaryPreferred"))
//        MongoSpark.load(sc, readConfig = readConfig).sortBy(x => x.getLong("date"), false)
        MongoSpark.load(sc, readConfig = readConfig)
    }

    lazy val services = {
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://127.0.0.1/"
                                        , "spark.mongodb.input.database" -> "baby_time_test"
                                        , "spark.mongodb.input.collection" -> "services"
                                        , "readPreference.name" -> "secondaryPreferred"))
//        MongoSpark.load(sc, readConfig = readConfig).sortBy(x => x.getLong("date"), false)
        MongoSpark.load(sc, readConfig = readConfig)
    }
}
