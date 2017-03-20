package controllers

import play.api.mvc._
import dongdasparkmodule.MongoDBSpark
import javax.inject._
import play.api.inject.Modules

/**
  * Created by Alfred on 17/03/2017.
  */
class SparkTestController @Inject() (msk : MongoDBSpark) extends Controller {
    
    def mongosparktest = Action {
        val a = msk.getUserProfileCount
        Ok(s"abcde result is $a")
    }
    
    def mongosparklst = Action {
        val a = msk.getSliceData(2, 6).map (x => x.getString("user_id")).toList
        Ok(s"abcde result is $a")
    }
}