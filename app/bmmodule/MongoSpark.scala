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
    def queryProfiles(range : Range) = user_profile
}

trait SparkContextManager {
    val conf = new SparkConf()
                    .setAppName("dongda-service")
                    .setMaster("local[4]")
    val sc = new SparkContext(conf)

    lazy val users = {
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://localhost/"
                                        , "spark.mongodb.input.database" -> "baby"
                                        , "spark.mongodb.input.collection" -> "users"
                                        , "readPreference.name" -> "secondaryPreferred"))
//        MongoSpark.load(sc, readConfig = readConfig).sortBy(x => x.getLong("date"), false)
        MongoSpark.load(sc, readConfig = readConfig)
    }
    
    lazy val user_profile = {
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://localhost/"
                                        , "spark.mongodb.input.database" -> "baby"
                                        , "spark.mongodb.input.collection" -> "user_profile"
                                        , "readPreference.name" -> "secondaryPreferred"))
//        MongoSpark.load(sc, readConfig = readConfig).sortBy(x => x.getLong("date"), false)
        MongoSpark.load(sc, readConfig = readConfig)
    }
}
