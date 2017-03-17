package dongdasparkdrivers

import com.mongodb.spark._
import org.bson.Document
import com.mongodb.spark.config._
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Alfred on 17/03/2017.
  */
object MongoDBSpark extends SparkContextManager with  java.io.Serializable {
    def getUserProfileCount = {
        loadUserProfileData.count()
//        loadUserProfileData
//        1
    }
}

trait SparkContextManager {
    val conf = new SparkConf()
                    .setAppName("dongda-service")
                    .setMaster("local[4]")
    val sc = new SparkContext(conf)

//    val spark = SparkSession.builder()
//        .master("local")
//        .appName("dongda-service")
//        .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/baby.users")
//        .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/baby.users")
//        .getOrCreate()

    def loadUserProfileData = {
        println(sc.getClass)
        val readConfig = ReadConfig(Map("spark.mongodb.input.uri" -> "mongodb://localhost/"
                                        , "spark.mongodb.input.database" -> "baby"
                                        , "spark.mongodb.input.collection" -> "user_profile"
                                        , "readPreference.name" -> "secondaryPreferred"))
        val customRdd = MongoSpark.load(sc, readConfig = readConfig)
//        val customRdd = sc.loadFromMongoDB(readConfig = readConfig)
//        val customRdd = spark.loadFromMongoDB(Map("uri" -> "mongodb://127.0.0.1/baby.user_profile"))
        customRdd
//        val rdd = MongoSpark.load(spark)
//        rdd

//        import org.apache.hadoop.conf.Configuration
//        import org.apache.spark.{SparkContext, SparkConf}
//        import org.apache.spark.rdd.RDD
//
//        import org.bson.BSONObject
//        import com.mongodb.hadoop.{
//        MongoInputFormat, MongoOutputFormat,
//        BSONFileInputFormat, BSONFileOutputFormat}
//        import com.mongodb.hadoop.io.MongoUpdateWritable
//
//        val mongoConfig = new Configuration()
//        mongoConfig.set("mongo.input.uri",
//            "mongodb://localhost:27017/baby.users")
//        val documents = sc.newAPIHadoopRDD(
//            mongoConfig,                // Configuration
//            classOf[MongoInputFormat],  // InputFormat
//            classOf[Object],            // Key type
//            classOf[BSONObject])        // Value type
//
//        documents
    }
}
