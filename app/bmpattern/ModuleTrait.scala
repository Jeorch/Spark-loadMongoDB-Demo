package bmpattern


import play.api.libs.json.JsValue
import bmmessages.MessageDefines

trait ModuleTrait {
	def dispatchMsg(msg : MessageDefines)(pr : Option[Map[String, JsValue]]) : (Option[Map[String, JsValue]], Option[JsValue])
}