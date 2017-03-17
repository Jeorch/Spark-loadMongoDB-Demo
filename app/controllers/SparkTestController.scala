package controllers

import play.api.mvc._
import dongdasparkdrivers.MongoDBSpark

/**
  * Created by Alfred on 17/03/2017.
  */
object SparkTestController extends Controller {
    def mongosparktest = Action {
        val a = MongoDBSpark.getUserProfileCount
        Ok(s"abcde result is $a")
    }
}
