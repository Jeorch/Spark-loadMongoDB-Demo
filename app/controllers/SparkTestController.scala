package controllers

import play.api.mvc._
import bmmodule.MongoDBSpark
import javax.inject._
import play.api.inject.Modules

/**
  * Created by Alfred on 17/03/2017.
  */
class SparkTestController @Inject() (msk : MongoDBSpark) extends Controller {
    
    def mongosparktest = Action {
        val a = msk.services.count
        Ok(s"services count is $a")
    }
    
    def mongosparklst = Action {
        val a = msk.services.toLocalIterator.slice(2, 6).map (x => x.getString("user_id")).toList
        Ok(s"abcde result is $a")
    }
}