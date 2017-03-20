package dongdasparkmodule

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
    def getUserProfileCount = customRdd.count()
    def getSliceData(f : Int, t : Int) = customRdd.toLocalIterator.slice(f, t)
}

trait SparkContextManager {
    val conf = new SparkConf()
                    .setAppName("dongda-service")
                    .setMaster("local[4]")
    val sc = new SparkContext(conf)

    lazy val customRdd = {
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://localhost/"
                                        , "spark.mongodb.input.database" -> "baby"
                                        , "spark.mongodb.input.collection" -> "user_profile"
                                        , "readPreference.name" -> "secondaryPreferred"))
        val customRdd = MongoSpark.load(sc, readConfig = readConfig)
        customRdd
    }
}
